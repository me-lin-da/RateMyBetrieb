package com.example.jwt.unit.userUnitTests;

import com.example.jwt.core.security.config.AuthorizationSchemas;
import com.example.jwt.core.security.config.JwtProperties;
import com.example.jwt.domain.entitys.authority.Authority;
import com.example.jwt.domain.entitys.order.Order;
import com.example.jwt.domain.entitys.order.OrderService;
import com.example.jwt.domain.entitys.order.dto.OrderMapper;
import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.entitys.user.User;
import com.example.jwt.domain.entitys.user.UserService;
import com.example.jwt.domain.role.Role;
import com.example.jwt.domain.role.RoleRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc()
public class userControllerUnitTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JwtProperties jwtProperties;

    @MockBean
    private UserService userService;

    @MockBean
    private RoleRepository roleRepository;

    @MockBean
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;
    private List<User> dummyUsers;
    private User dummyUser;
    private Role dummyRole;
    private String dummyToken;
    private Rank dummyRank;
    private Set<Authority> dummyAuthority;
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
        dummyAuthority = Stream.of( new Authority(UUID.randomUUID(),"USER_MODIFY"), new Authority(UUID.randomUUID(),"USER_DELETE")).collect(Collectors.toSet());
        dummyRole = new Role(UUID.randomUUID(),"ADMIN", dummyAuthority);
        dummyRank = new Rank(UUID.randomUUID(),10,"Bronze",30,10, (float) 0.9);
        dummyOrder = new Order(UUID.randomUUID(), 12, new User(),new HashSet<>());
        dummyUsers = List.of(new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",dummyRank,new HashSet<>()), new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",dummyRank,new HashSet<>()));
        dummyUser = new User(UUID.randomUUID(),30,12,"Johann","Studer","johann.s@gmail.com","123",dummyRank,new HashSet<>());
        dummyOrders = Stream.of(new Order(UUID.randomUUID(), 20, dummyUser,new HashSet<>()), new Order(UUID.randomUUID(), 12, dummyUser,new HashSet<>())).collect(Collectors.toList());
    }



    @Test
    public void updateUser_requestUserDTOToBeUpdated_expectUpdatedUserDTO() throws Exception {
        Integer updatedUserAge = 15;
        given(userService.findById(any(UUID.class))).willReturn(new User());
        given(userService.updateById(any(UUID.class),any(User.class))).willReturn(dummyUser.setAge(updatedUserAge));

        mvc.perform(MockMvcRequestBuilders
                        .put("/users/{id}", dummyUser.getId())
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .content(new ObjectMapper().writeValueAsString(dummyUser))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(dummyUser.getId().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(updatedUserAge));

        User userArgumentCaptor = dummyUser;
        verify(userService, times(1)).updateById(any(UUID.class),any(User.class));
        assertAll(
                () -> assertThat(userArgumentCaptor.getId()).isEqualTo(dummyUser.getId()),
                () -> assertThat(userArgumentCaptor.getAge()).isEqualTo(updatedUserAge)
        );
    }

    @Test
    public void deleteUserById_requestDeletionOfUserById_expectAppropriateState() throws Exception {
        given(userService.findById(any(UUID.class))).willReturn(new User());
        given(userService.deleteById(any(UUID.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0)))
                throw new NoSuchElementException("No such product present");
            return null;
        });

        mvc.perform(MockMvcRequestBuilders
                        .delete("/users/{id}", dummyUser.getId())
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isNoContent());

        ArgumentCaptor<UUID> productArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(userService, times(1)).deleteById(productArgumentCaptor.capture());
        assertThat(productArgumentCaptor.getValue()).isEqualTo(dummyUser.getId());
    }
}

