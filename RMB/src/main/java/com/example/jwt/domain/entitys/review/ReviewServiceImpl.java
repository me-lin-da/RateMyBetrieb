package com.example.jwt.domain.entitys.review;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.core.generic.ExtendedServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl extends ExtendedServiceImpl<Review> implements ReviewService {
    protected ReviewServiceImpl(ExtendedRepository<Review> repository) {
        super(repository);
    }
}
