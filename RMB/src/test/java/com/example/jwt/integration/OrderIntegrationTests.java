package com.example.jwt.integration;

import com.example.jwt.core.security.config.AuthorizationSchemas;
import com.example.jwt.core.security.config.JwtProperties;
import com.example.jwt.domain.entitys.authority.Authority;
import com.example.jwt.domain.entitys.authority.AuthorityRepository;
import com.example.jwt.domain.entitys.order.Order;
import com.example.jwt.domain.entitys.order.OrderRepository;
import com.example.jwt.domain.entitys.order.OrderService;
import com.example.jwt.domain.entitys.order.dto.OrderMapper;
import com.example.jwt.domain.entitys.user.User;
import com.example.jwt.domain.entitys.user.UserRepository;
import com.example.jwt.domain.role.Role;
import com.example.jwt.domain.role.RoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class OrderIntegrationTests {

    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private JwtProperties jwtProperties;
    @MockBean
    private OrderService orderService;
    @Autowired
    private OrderMapper orderMapper;
    private String generateToken(UUID subject) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtProperties.getSecret());

        return Jwts.builder()
                .setClaims(Map.of("sub", subject))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpirationMillis()))
                .setIssuer(jwtProperties.getIssuer())
                .signWith(Keys.hmacShaKeyFor(keyBytes))
                .compact();
    }
    @BeforeEach
    public void setUp() {
}
    @Test
    public void save_saveOrder_expectSavedOrderAsDTOS() throws Exception {
        Authority authority = authorityRepository.saveAndFlush(new Authority().setName("USER_SEE"));
        Role role = roleRepository.saveAndFlush(new Role().setName("ADMIN").setAuthorities(Set.of(authority)));
        User user = userRepository.saveAndFlush(new User().setEmail("john@doe.com").setRoles(Set.of(role)));
        List<Order> dummyOrders = orderRepository.saveAllAndFlush(Stream.of(new Order(UUID.randomUUID(), 20, user,new HashSet<>()), new Order(UUID.randomUUID(), 12, user,new HashSet<>())).collect(Collectors.toList()));

        dummyOrders.get(0).setId(null);
        dummyOrders.get(1).setId(null);

        mvc.perform(MockMvcRequestBuilders
                        .post("/order")
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + generateToken(user.getId()))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(orderMapper.toDTO(dummyOrders.get(0)))))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").doesNotExist());
    }
}
