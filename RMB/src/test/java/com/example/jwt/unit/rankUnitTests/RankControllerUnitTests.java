package com.example.jwt.unit.rankUnitTests;

import com.example.jwt.core.security.config.AuthorizationSchemas;
import com.example.jwt.core.security.config.JwtProperties;
import com.example.jwt.domain.entitys.authority.Authority;
import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.entitys.ranking.RankService;
import com.example.jwt.domain.entitys.user.User;
import com.example.jwt.domain.entitys.user.UserService;
import com.example.jwt.domain.role.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc()
public class RankControllerUnitTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JwtProperties jwtProperties;

    @MockBean
    private RankService rankService;

    @MockBean
    private UserService userService;
    private String dummyToken;
    private Rank dummyRank;
    private List<Rank> dummyRanks;

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
        dummyRank = new Rank(UUID.randomUUID(),20,"Bronze",30,12, (float) 0.7);
        dummyRanks = Stream.of(new Rank(UUID.randomUUID(),20,"Iron",31,22, (float) 0.8), new Rank(UUID.randomUUID(), 20,"Gold",40,32, (float) 0.9)).collect(Collectors.toList());
    }

    //AAA Arange Act Asert
    @DisplayName("Hello")
    @Test
    public void findAll_findAllRanks_expectAllRanksAsDTOS() throws Exception {
        // Arrangement
        given(userService.findById(any(UUID.class))).willReturn(
                new User().setRoles(Set.of(new Role().setAuthorities(Set.of(new Authority().setName("USER_SEE"))))));
        given(rankService.findAll()).willReturn(dummyRanks);

        //Acting
        mvc.perform(MockMvcRequestBuilders
                        .get("/rank")
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + dummyToken)
                        .accept(MediaType.APPLICATION_JSON))
                //Assertions
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(Matchers.containsInAnyOrder(dummyRanks.get(0).getId().toString(), dummyRanks.get(1).getId().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].valueOrder").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].title").value(Matchers.containsInAnyOrder(dummyRanks.get(0).getTitle(), dummyRanks.get(1).getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].discount").value(Matchers.containsInAnyOrder(dummyRanks.get(0).getDiscount(), dummyRanks.get(1).getDiscount())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].seeds").value(Matchers.containsInAnyOrder(dummyRanks.get(0).getSeeds(), dummyRanks.get(1).getSeeds())));

        verify(rankService, times(1)).findAll();
    }
}