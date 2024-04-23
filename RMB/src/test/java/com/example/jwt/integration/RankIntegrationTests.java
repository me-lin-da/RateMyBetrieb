package com.example.jwt.integration;

import com.example.jwt.core.security.config.AuthorizationSchemas;
import com.example.jwt.core.security.config.JwtProperties;
import com.example.jwt.domain.entitys.authority.Authority;
import com.example.jwt.domain.entitys.authority.AuthorityRepository;
import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.entitys.ranking.RankRepository;
import com.example.jwt.domain.entitys.user.User;
import com.example.jwt.domain.entitys.user.UserRepository;
import com.example.jwt.domain.entitys.role.Role;
import com.example.jwt.domain.entitys.role.RoleRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test_rank")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RankIntegrationTests {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private JwtProperties jwtProperties;
    @Autowired
    private AuthorityRepository authorityRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RankRepository rankRepository;

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
    public void setUp() {}

    //So the test works on its own but when I try to run all of the tests, this one fails...
    // could fix that with a new applications.properties
    @Test
    public void findAll_findAllRanks_expectAllRanksAsDTOS() throws Exception {
        Authority authority = authorityRepository.saveAndFlush(new Authority().setName("USER_SEE"));
        Role role = roleRepository.saveAndFlush(new Role().setName("ADMIN").setAuthorities(Set.of(authority)));
        User user = userRepository.saveAndFlush(new User().setEmail("john@doe.com").setRoles(Set.of(role)));
        List<Rank> dummyRanks = rankRepository.saveAllAndFlush(Stream.of(new Rank(UUID.randomUUID(),20,"Iron",31,22, (float) 0.8), new Rank(UUID.randomUUID(), 20,"Gold",40,32, (float) 0.9)).collect(Collectors.toList()));



        mvc.perform(MockMvcRequestBuilders
                        .get("/rank")
                        .header(HttpHeaders.AUTHORIZATION, AuthorizationSchemas.BEARER + " " + generateToken(user.getId()))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].id").value(Matchers.containsInAnyOrder(dummyRanks.get(0).getId().toString(), dummyRanks.get(1).getId().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].title").value(Matchers.containsInAnyOrder(dummyRanks.get(0).getTitle(), dummyRanks.get(1).getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].valueOrder").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].discount").value(Matchers.containsInAnyOrder(dummyRanks.get(0).getDiscount(), dummyRanks.get(1).getDiscount())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].seeds").value(Matchers.containsInAnyOrder(dummyRanks.get(0).getSeeds(), dummyRanks.get(1).getSeeds())));

    }

}
