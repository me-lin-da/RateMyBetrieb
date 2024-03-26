package com.example.jwt.domain.entitys.order;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.core.generic.ExtendedServiceImpl;
import com.example.jwt.domain.entitys.order.dto.OrderASCDTO;
import com.example.jwt.domain.entitys.order.dto.OrderCountDTO;
import com.example.jwt.domain.entitys.order.dto.OrderCreateDTO;
import com.example.jwt.domain.entitys.order.dto.OrderMapper;
import com.example.jwt.domain.entitys.ranking.RankService;
import com.example.jwt.domain.entitys.teas.Tea;
import com.example.jwt.domain.entitys.teas.TeaService;
import com.example.jwt.domain.entitys.user.UserService;
import com.example.jwt.domain.orderposition.OrderPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

// Keep in mind
//Java provides the following two groups of datatypes for numbers:
//Whole numbers: byte, small, int, long
//Fractional numbers: float, double

@Service
public class OrderServiceImpl extends ExtendedServiceImpl<Order> implements OrderService {

    private final UserService userService;
    private final TeaService teaService;
    private final RankService rankService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(ExtendedRepository<Order> repository, UserService userService, TeaService teaService, RankService rankService, OrderMapper orderMapper) {
        super(repository);
        this.userService = userService;
        this.teaService = teaService;
        this.rankService = rankService;
        this.orderMapper = orderMapper;
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        order.setUser(userService.findCurrentUser());
        Set<OrderPosition> detachedPositions = order.getOrderPositions();
        Order cachedOrder = save(order.setOrderPositions(new HashSet<>()));
        cachedOrder.setOrderPositions(detachedPositions.stream().map(orderPos -> {
                isOrderValid(orderPos);
                orderPos.setOrder(cachedOrder);
            return  orderPos;
                }
        ).collect(Collectors.toSet()));
        save(cachedOrder);
       calculateSeedsAndRank(cachedOrder);
        return save(cachedOrder);
    }

    public OrderPosition isOrderValid(OrderPosition orderPos){
        orderPos.setTea(teaService.findById(orderPos.getTea().getId()));
        if (isUserOldEnough(orderPos.getTea()) && isRankHighEnough(orderPos.getTea()) && orderPos.getAmount() <= orderPos.getTea().getAmountInStock()) {
            orderPos.getTea().setAmountInStock(orderPos.getTea().getAmountInStock() - orderPos.getAmount());
        } else {
            throw new RuntimeException("Bestellkonditionen wurden nicht erfüllt");
        }
        return orderPos;
    }

        public Order calculateSeedsAndRank(Order order){

        int sum = order.getOrderPositions().stream().mapToInt(p -> (int) p.getTea().getPrice() * p.getAmount()).sum();
        order.setPrice(sum * order.getUser().getRank().getReduction());
        order.getUser().setSeeds((int) order.getPrice() / 2 + order.getUser().getSeeds());
        order.getUser().setRank(rankService.findRankBySeeds(order.getUser().getSeeds()));
        return order;
    }


    public boolean isUserOldEnough(Tea tea) {
        return userService.findCurrentUser().getAge() >= tea.getTeaType().getAge();
    }

    public boolean isRankHighEnough(Tea tea) {
        return userService.findCurrentUser().getRank().getValueOrder() >= tea.getTeaType().getRank().getValueOrder();
    }

    public List<Order> findOwn() {
        Optional<List<Order>> optional = ((OrderRepository) super.getRepository()).findOwn(userService.findCurrentUser().getId());
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    public List<OrderCountDTO> findTeas() {
        Optional<List<OrderCountDTO>> optional = ((OrderRepository) super.getRepository()).findTeas(userService.findCurrentUser().getId());
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    public List<OrderASCDTO> findMostActiveUser() {
        Optional<List<OrderASCDTO>> optional = ((OrderRepository) super.getRepository()).findMostActiveUser();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    @Override
    public List<OrderCreateDTO> getAllOrders(Integer pageNo, Integer pageSize) {
        List<Order> order = findAll(PageRequest.of(pageNo, pageSize));
        return orderMapper.toDTOs(order);
    }
}

