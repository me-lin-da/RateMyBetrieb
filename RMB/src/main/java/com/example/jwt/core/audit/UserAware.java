package com.example.jwt.core.audit;

import com.example.jwt.domain.entitys.user.User;
import com.example.jwt.domain.entitys.user.UserDetailsImpl;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserAware implements AuditorAware<User> {

    @Override
    public Optional<User> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetailsImpl) {
                return Optional.of(((UserDetailsImpl) principal).user());
            }
        }

        return Optional.empty();
    }
}