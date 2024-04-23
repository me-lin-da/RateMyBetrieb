package com.example.jwt.unit.orderUnitTests;

import com.example.jwt.core.security.config.AuthorizationSchemas;
import com.example.jwt.core.security.config.JwtProperties;
import com.example.jwt.domain.entitys.authority.Authority;
import com.example.jwt.domain.entitys.order.Order;
import com.example.jwt.domain.entitys.order.OrderService;
import com.example.jwt.domain.entitys.order.dto.OrderMapper;
import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.entitys.user.User;
import com.example.jwt.domain.entitys.user.UserService;
import com.example.jwt.domain.entitys.role.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.matchesPattern;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc()
public class OrderControllerUnitTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JwtProperties jwtProperties;

    @MockBean
    private UserService userService;

    @MockBean
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;
    private List<User> dummyUsers;
    private User dummyUser;

    private String dummyToken;
    private Rank dummyRank;
    private Order dummyOrder;
    private List<Order> dummyOrders;

    private String generateToken() {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());

        return Jwts.builder()
                .setClaims(Map.of("sub", UUID.randomUUID()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMillis()))
                .setIssuer(jwtProperties.getIssuer())
                .signWith(Keys.hmacShaKeyFor(keyBytes))
                .compact();
    }

    @BeforeEach
    public void setUp() {
        dummyToken = generateToken();
        dummyRank = new Rank(UUID.randomUUID(),10,"Bronze",30,10, (float) 0.9);
        dummyOrder = new Order(UUID.randomUUID(), 12, new User(),new HashSet<>());
        dummyUsers = List.of(new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",dummyRank,new HashSet<>()), new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",dummyRank,new HashSet<>()));
        dummyUser = new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",dummyRank,new HashSet<>());
        dummyOrders = Stream.of(new Order(UUID.randomUUID(), 20, dummyUser,new HashSet<>()), new Order(UUID.randomUUID(), 12, dummyUser,new HashSet<>())).collect(Collectors.toList());
    }

    //get
    @Test
    public void findOwn_findOwnOrder_expectOwnOrderAsDTOS() throws Exception {
        given(userService.findById(any(UUID.class))).willReturn(
                new User().setRoles(Set.of(new Role().setAuthorities(Set.of(new Authority().setName("USER_SEE"))))));
        given(orderService.findOwn()).willReturn(dummyOrders);

        mvc.perform(MockMvcRequestBuilders
                        .get("/order")
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(Matchers.containsInAnyOrder(dummyOrders.get(0).getId().toString(), dummyOrders.get(1).getId().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].price").doesNotExist());
                //.andExpect(MockMvcResultMatchers.jsonPath("$[*].user").value(Matchers.containsInAnyOrder(dummyOrders.get(0).getUser().toString(), dummyOrders.get(1).getUser().toString())));
                //.andExpect(MockMvcResultMatchers.jsonPath("$[*].orderPositions").value(Matchers.containsInAnyOrder(dummyOrders.get(0).getOrderPositions(), dummyOrders.get(1).getOrderPositions())));

        verify(orderService, times(1)).findOwn();
    }

    //post
    @Test
    public void save_saveOrder_expectSavedOrderAsDTOS() throws Exception {
        given(userService.findById(any(UUID.class))).willReturn(
                new User().setRoles(Set.of(new Role().setAuthorities(Set.of(new Authority().setName("USER_SEE"))))));
        given(orderService.save(any(Order.class))).willReturn(dummyOrder);

        mvc.perform(MockMvcRequestBuilders
                        .post("/order").header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(orderMapper.toDTO(dummyOrders.get(0))))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").doesNotExist());

        verify(userService, times(1)).findById(any(UUID.class));
    }


}

