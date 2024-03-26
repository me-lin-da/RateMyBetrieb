package com.example.jwt.unit.orderUnitTests;

import com.example.jwt.domain.entitys.country.Country;
import com.example.jwt.domain.entitys.order.Order;
import com.example.jwt.domain.entitys.order.OrderRepository;
import com.example.jwt.domain.entitys.order.OrderService;
import com.example.jwt.domain.entitys.order.OrderServiceImpl;
import com.example.jwt.domain.entitys.order.dto.OrderMapper;
import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.entitys.ranking.RankService;
import com.example.jwt.domain.entitys.teas.Tea;
import com.example.jwt.domain.entitys.teas.TeaService;
import com.example.jwt.domain.entitys.teatype.TeaType;
import com.example.jwt.domain.entitys.user.User;
import com.example.jwt.domain.entitys.user.UserService;
import com.example.jwt.domain.orderposition.OrderPosition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplUnitTest {

    @InjectMocks
    private OrderServiceImpl orderServiceImpl;
    @Mock
    private TeaService teaService;
    @Mock
    private RankService rankService;
    @Mock
    private OrderService orderService;
    @Mock
    private UserService userService;
    @Mock
    private OrderRepository orderRepository;
    private User dummyUser;
    private Tea dummyTea;
    private Rank dummyRank;
    private Order dummyOrder;
    private OrderPosition dummyOrderPosition;

    private Set<OrderPosition> dummyOrderPositions;
    private List<Order> dummyOrders;

    private  TeaType dummyTeaType;

    @BeforeEach
    public void setUp() {
        dummyRank = new Rank(UUID.randomUUID(),10,"Bronze",30,10, (float) 0.9);
        dummyTeaType = new TeaType(UUID.randomUUID(),12,"withe", dummyRank);
        dummyTea = new Tea(UUID.randomUUID(),30,"Greentea",50,new Date(2022),dummyTeaType,new Country());
        dummyUser = new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",dummyRank,new HashSet<>());
        dummyOrderPositions = Set.of(new OrderPosition(UUID.randomUUID(),2,dummyOrder,dummyTea));
        dummyOrder = new Order(UUID.randomUUID(), 12,dummyUser,dummyOrderPositions);
        dummyOrderPosition = new OrderPosition(UUID.randomUUID(),2,dummyOrder,dummyTea);
        dummyOrders = Stream.of(new Order(UUID.randomUUID(), 20, new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",dummyRank,new HashSet<>()),new HashSet<>()), new Order(UUID.randomUUID(), 12, new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",dummyRank,new HashSet<>()),new HashSet<>())).collect(Collectors.toList());    }

    //create order
    @Test
    public void createOrder_requestCreateOrder_expectNewOrder() throws Exception {
        given(userService.findCurrentUser()).willReturn(dummyUser);
        given(teaService.findById(any(UUID.class))).willReturn(dummyTea);
        given(rankService.findRankBySeeds(any())).willReturn(dummyRank);

        assertThat(orderServiceImpl.calculateSeedsAndRank(dummyOrder)).usingRecursiveComparison().isEqualTo(dummyOrder);
        assertThat(orderServiceImpl.isOrderValid(dummyOrderPosition)).usingRecursiveComparison().isEqualTo(dummyOrderPosition);

        ArgumentCaptor<Order> productArgumentCaptor = ArgumentCaptor.forClass(Order.class);
        verify(teaService, times(1)).findById(dummyTea.getId());
//        assertThat(productArgumentCaptor.getValue()).isEqualTo(dummyTea);
    }

    //findById
    @Test
    public void findById_requestProductById_expectProduct() throws Exception {
        given(orderRepository.findById(any(UUID.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0)))
                throw new NoSuchElementException("No such product present");
            return Optional.of(dummyOrder);
        });

        assertThat(orderServiceImpl.findById(dummyOrder.getId())).usingRecursiveComparison().isEqualTo(dummyOrder);

        ArgumentCaptor<UUID> productArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(orderRepository, times(1)).findById(productArgumentCaptor.capture());
    }

    //age
    @Test
    public void isUserOldEnough_requestUser_expectUser() throws Exception {
        given(userService.findCurrentUser()).willReturn(dummyUser);

        assertThat(orderServiceImpl.isUserOldEnough(dummyTea)).isEqualTo(true);

        verify(userService, times(1)).findCurrentUser();
    }

    //rank
    @Test
    public void isRankHighEnough_requestOrder_expectOrder() throws Exception {
        given(userService.findCurrentUser()).willReturn(dummyUser);

        assertThat(orderServiceImpl.isRankHighEnough(dummyTea)).isEqualTo(true);

        verify(userService, times(1)).findCurrentUser();
    }

    // isOrderValid
    @Test
    public void isOrderValid_requestOrderPosition_expectOrderPosition() throws Exception {
        given(userService.findCurrentUser()).willReturn(dummyUser);
        given(teaService.findById(any(UUID.class))).willReturn(dummyTea);

        assertThat(orderServiceImpl.isOrderValid(dummyOrderPosition)).isEqualTo(dummyOrderPosition);

        verify(teaService, times(1)).findById(dummyTea.getId());
    }

    //calculate Seeds and Rank
    @Test
    public void calculateSeedsAndRank_requestOrder_expectOrder() throws Exception {
        given(rankService.findRankBySeeds(any())).willReturn(dummyRank);

        assertThat(rankService.findRankBySeeds(dummyRank.getSeeds())).isEqualTo(dummyRank);

        verify(rankService, times(1)).findRankBySeeds(dummyRank.getSeeds());
    }
}
