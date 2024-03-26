package com.example.jwt.unit.orderUnitTests;

import com.example.jwt.domain.entitys.order.Order;
import com.example.jwt.domain.entitys.order.OrderRepository;
import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.entitys.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderRepositoryUnitTest {

    @Autowired
    OrderRepository orderRepository;

    private List<Order> dummyOrders;

    @BeforeEach
    public void setUp() {
        dummyOrders = orderRepository.saveAll(Stream.of(new Order(UUID.randomUUID(), 20, new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",new Rank(),new HashSet<>()),new HashSet<>()), new Order(UUID.randomUUID(), 12, new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",new Rank(),new HashSet<>()),new HashSet<>())).collect(Collectors.toList()));
    }

    @Test
    public void findById_requestOrderId_expectOrder() {
        assertThat(orderRepository.findById(dummyOrders.get(0).getId())).hasValue(dummyOrders.get(0));
    }

    @Disabled
    @Test
    public void findAll_requestAllOrders_expectAllOrders() {
        assertThat(orderRepository.findAll()).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(dummyOrders);
    }
}
