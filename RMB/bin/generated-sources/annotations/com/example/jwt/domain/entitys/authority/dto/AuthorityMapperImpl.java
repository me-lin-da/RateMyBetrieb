package com.example.jwt.domain.entitys.authority.dto;

import com.example.jwt.domain.entitys.authority.Authority;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-25T10:33:38+0200",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class AuthorityMapperImpl implements AuthorityMapper {

    @Override
    public Authority fromDTO(AuthorityDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Authority authority = new Authority();

        authority.setId( dto.getId() );
        authority.setName( dto.getName() );

        return authority;
    }

    @Override
    public List<Authority> fromDTOs(List<AuthorityDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Authority> list = new ArrayList<Authority>( dtos.size() );
        for ( AuthorityDTO authorityDTO : dtos ) {
            list.add( fromDTO( authorityDTO ) );
        }

        return list;
    }

    @Override
    public Set<Authority> fromDTOs(Set<AuthorityDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<Authority> set = new LinkedHashSet<Authority>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( AuthorityDTO authorityDTO : dtos ) {
            set.add( fromDTO( authorityDTO ) );
        }

        return set;
    }

    @Override
    public AuthorityDTO toDTO(Authority BO) {
        if ( BO == null ) {
            return null;
        }

        AuthorityDTO authorityDTO = new AuthorityDTO();

        authorityDTO.setId( BO.getId() );
        authorityDTO.setName( BO.getName() );

        return authorityDTO;
    }

    @Override
    public List<AuthorityDTO> toDTOs(List<Authority> BOs) {
        if ( BOs == null ) {
            return null;
        }

        List<AuthorityDTO> list = new ArrayList<AuthorityDTO>( BOs.size() );
        for ( Authority authority : BOs ) {
            list.add( toDTO( authority ) );
        }

        return list;
    }

    @Override
    public Set<AuthorityDTO> toDTOs(Set<Authority> BOs) {
        if ( BOs == null ) {
            return null;
        }

        Set<AuthorityDTO> set = new LinkedHashSet<AuthorityDTO>( Math.max( (int) ( BOs.size() / .75f ) + 1, 16 ) );
        for ( Authority authority : BOs ) {
            set.add( toDTO( authority ) );
        }

        return set;
    }
}
