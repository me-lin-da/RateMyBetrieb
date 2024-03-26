package com.example.jwt.domain.entitys.ranking;

import com.example.jwt.domain.entitys.ranking.dto.RankDTO;
import com.example.jwt.domain.entitys.ranking.dto.RankMapper;
import com.example.jwt.domain.entitys.user.User;
import com.example.jwt.domain.entitys.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {

    private final RankService rankService;

    private final RankMapper rankMapper;

    public RankController(RankService rankService, RankMapper rankMapper) {
        this.rankService = rankService;
        this.rankMapper = rankMapper;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER_SEE')")
    public @ResponseBody ResponseEntity<List<RankDTO>> findAll() {
        List<Rank> ranks = rankService.findAll();
        return new ResponseEntity<>(rankMapper.toDTOs(ranks), HttpStatus.OK);

    }
}
