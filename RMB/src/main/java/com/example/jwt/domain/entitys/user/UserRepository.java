package com.example.jwt.domain.entitys.user;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.domain.entitys.user.dto.UserRabatDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ExtendedRepository<User> {
    Optional<User> findByEmail(String email);

    @Query(value = "select sum(o.price / r.reduction - o.price) as rabat from users left join rank as r on r.id=users.rank_id left join orders o on users.id = o.user_id left join tea t on o.price = t.price", nativeQuery = true)
    Optional<List<UserRabatDTO>> findRabat();
}
