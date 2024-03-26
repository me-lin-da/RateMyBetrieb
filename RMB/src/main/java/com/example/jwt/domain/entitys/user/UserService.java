package com.example.jwt.domain.entitys.user;

import com.example.jwt.core.generic.ExtendedService;
import com.example.jwt.domain.entitys.user.dto.UserRabatDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface UserService extends UserDetailsService, ExtendedService<User> {
    User findByEmail(String email);

    User register(User user);

    User findCurrentUser();

    List<UserRabatDTO> findRabat();


    User lockUser(UUID id);
}
