package com.example.jwt.domain.entitys.user;

import com.example.jwt.core.generic.ExtendedServiceImpl;
import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.entitys.ranking.RankService;
import com.example.jwt.domain.entitys.user.dto.UserRabatDTO;
import com.example.jwt.domain.role.Role;
import com.example.jwt.domain.role.RoleServiceImpl;
import com.example.jwt.domain.role.RoleValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RankService rankService;

    private final RoleServiceImpl roleServiceImpl;

    @Autowired
    public UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder, RankService rankService, RoleServiceImpl roleServiceImpl) {
        super(repository);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.rankService = rankService;
        this.roleServiceImpl = roleServiceImpl;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return ((UserRepository) super.getRepository()).findByEmail(email).map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    public User findByEmail(String email) {
        return findOrThrow(((UserRepository) super.getRepository()).findByEmail(email));
    }


    @Override
    public User register(User user) {
        Rank rank = rankService.findByTitle("bronze");
        Role role = roleServiceImpl.findByName("USER");
        user.setRoles(Collections.singleton(role));
        user.setRank(rank);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return save(user);
    }

//    @Override
//    public UserDetailsImpl findCurrentUser() {
//        return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//    }

    public User findCurrentUser(){
        //Get User UUID
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        User user = ((UserDetailsImpl) principal).user();
        return user;
    }

    public List<UserRabatDTO> findRabat() {
        Optional<List<UserRabatDTO>> optional = ((UserRepository) super.getRepository()).findRabat();
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    @Transactional
    @Override
    public User lockUser(UUID id) {
        if (getRepository().existsById(id)) {
            User user = findById(id);
            if (user.getRank().getTitle() != RoleValue.ADMIN.getValue()) {
                user.setNotLocked(false);
            }
            return save(user);
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

}
