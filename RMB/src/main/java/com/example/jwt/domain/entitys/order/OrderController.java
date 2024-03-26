package com.example.jwt.domain.entitys.order;

import com.example.jwt.domain.entitys.order.dto.OrderASCDTO;
import com.example.jwt.domain.entitys.order.dto.OrderCountDTO;
import com.example.jwt.domain.entitys.order.dto.OrderCreateDTO;
import com.example.jwt.domain.entitys.order.dto.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    // HIER SPEICHERST DU EINE NEUE BESTELLUNG
    @PostMapping
    @PreAuthorize("hasAuthority('USER_SEE')")
    public ResponseEntity<OrderCreateDTO> save(@RequestBody @Valid OrderCreateDTO orderCreateDTO) {
        Order order = orderService.createOrder(orderMapper.fromDTO(orderCreateDTO));
        return new ResponseEntity<>(orderMapper.toDTO(order), HttpStatus.CREATED);
    }

    @GetMapping
    public List<OrderCreateDTO> findOwn() {
        return orderMapper.toDTOs(orderService.findOwn());
    }

    @GetMapping("/statistics")
    @PreAuthorize("hasAuthority('CAN_SEE_STATISTICS')")
    public List<OrderASCDTO> findMostActiveUser() {
        return orderService.findMostActiveUser();
    }

    @GetMapping("/teas")
    public List<OrderCountDTO> findTeas() {
        return orderService.findTeas();
    }

    @GetMapping("/page/{pageNo}/{pageSize}")
    public ResponseEntity<List<OrderCreateDTO>> getAllOrders(
            @PathVariable Integer pageNo,
            @PathVariable Integer pageSize) {
        List<OrderCreateDTO> list = orderService.getAllOrders(pageNo, pageSize);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}


