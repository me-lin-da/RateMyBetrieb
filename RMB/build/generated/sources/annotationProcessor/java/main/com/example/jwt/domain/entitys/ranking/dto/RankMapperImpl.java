package com.example.jwt.domain.entitys.ranking.dto;

import com.example.jwt.domain.entitys.ranking.Rank;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-09T14:57:57+0100",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.jar, environment: Java 17.0.3 (JetBrains s.r.o.)"
)
@Component
public class RankMapperImpl implements RankMapper {

    @Override
    public List<Rank> fromDTOs(List<RankDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Rank> list = new ArrayList<Rank>( dtos.size() );
        for ( RankDTO rankDTO : dtos ) {
            list.add( fromDTO( rankDTO ) );
        }

        return list;
    }

    @Override
    public Set<Rank> fromDTOs(Set<RankDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Rank> set = new LinkedHashSet<Rank>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( RankDTO rankDTO : dtos ) {
            set.add( fromDTO( rankDTO ) );
        }

        return set;
    }

    @Override
    public List<RankDTO> toDTOs(List<Rank> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<RankDTO> list = new ArrayList<RankDTO>( BOs.size() );
        for ( Rank rank : BOs ) {
            list.add( toDTO( rank ) );
        }

        return list;
    }

    @Override
    public Set<RankDTO> toDTOs(Set<Rank> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<RankDTO> set = new LinkedHashSet<RankDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( Rank rank : BOs ) {
            set.add( toDTO( rank ) );
        }

        return set;
    }

    @Override
    public Rank fromDTO(RankDTO rankDTO) {
        if ( rankDTO == null ) {
            return null;
        }

        Rank rank = new Rank();

        rank.setId( rankDTO.getId() );
        rank.setDiscount( rankDTO.getDiscount() );
        rank.setTitle( rankDTO.getTitle() );
        rank.setSeeds( rankDTO.getSeeds() );
        rank.setReduction( rankDTO.getReduction() );

        return rank;
    }

    @Override
    public RankDTO toDTO(Rank rank) {
        if ( rank == null ) {
            return null;
        }

        RankDTO rankDTO = new RankDTO();

        rankDTO.setId( rank.getId() );
        rankDTO.setTitle( rank.getTitle() );
        rankDTO.setSeeds( rank.getSeeds() );
        rankDTO.setReduction( rank.getReduction() );
        rankDTO.setDiscount( rank.getDiscount() );

        return rankDTO;
    }
}
