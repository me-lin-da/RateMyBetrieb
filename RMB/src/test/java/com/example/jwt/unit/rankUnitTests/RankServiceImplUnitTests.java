package com.example.jwt.unit.rankUnitTests;

import com.example.jwt.core.security.config.JwtProperties;
import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.entitys.ranking.RankRepository;
import com.example.jwt.domain.entitys.ranking.RankService;
import com.example.jwt.domain.entitys.ranking.RankServiceImpl;
import com.example.jwt.domain.entitys.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class RankServiceImplUnitTests {

    @Autowired
    private JwtProperties jwtProperties;

    @InjectMocks
    private RankServiceImpl rankServiceImpl;

    @Mock
    private RankRepository rankRepository;
    private Rank dummyRank;
    private List<Rank> dummyRanks;

    @BeforeEach
    public void setUp() {
        dummyRank = new Rank(UUID.randomUUID(),20,"Bronze",30,12, (float) 0.7);
        dummyRanks = Stream.of(new Rank(UUID.randomUUID(),20,"Iron",31,22, (float) 0.8), new Rank(UUID.randomUUID(), 20,"Gold",40,32, (float) 0.9)).collect(Collectors.toList());
    }

    @Test
    public void findById_requestRankById_expectRank() throws Exception {
        given(rankRepository.findById(any(UUID.class))).will(invocation -> {
            if ("non-existent".equals(invocation.getArgument(0)))
                throw new NoSuchElementException("No such product present");
            return Optional.of(dummyRank);
        });

        assertThat(rankServiceImpl.findById(dummyRank.getId())).usingRecursiveComparison().isEqualTo(dummyRank);

        ArgumentCaptor<UUID> uuidArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
        verify(rankRepository, times(1)).findById(uuidArgumentCaptor.capture());
        assertThat(uuidArgumentCaptor.getValue()).isEqualTo(dummyRank.getId());
    }

}
