package com.example.jwt.unit.rankUnitTests;

import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.entitys.ranking.RankRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RankRepositoryUnitTests {

    @Autowired
    RankRepository rankRepository;

    private List<Rank> dummyRanks;

    @BeforeEach
    public void setUp() {
        dummyRanks = rankRepository.saveAll(Stream.of(new Rank(UUID.randomUUID(),20,"Iron",31,22, (float) 0.8), new Rank(UUID.randomUUID(), 20,"Gold",40,32, (float) 0.9)).collect(Collectors.toList()));
    }

    @Test
    public void findById_requestRankById_expectRank() {
        assertThat(rankRepository.findByTitle(dummyRanks.get(0).getTitle())).hasValue(dummyRanks.get(0));
    }

    @Test
    public void findAll_requestAllRanks_expectAllRanks() {
        assertThat(rankRepository.findAll()).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(dummyRanks);
    }
}
