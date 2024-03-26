package com.example.jwt.domain.entitys.ranking.dto;

import com.example.jwt.core.generic.ExtendedMapper;
import com.example.jwt.domain.entitys.ranking.Rank;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RankMapper extends ExtendedMapper<Rank, RankDTO> {
    Rank fromDTO(RankDTO rankDTO);
    RankDTO toDTO(Rank rank);

}
