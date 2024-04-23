package com.example.jwt.domain.entitys.company;

import com.example.jwt.core.generic.ExtendedRepository;
import com.example.jwt.core.generic.ExtendedServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends ExtendedServiceImpl<Company> implements CompanyService {

    protected CompanyServiceImpl(ExtendedRepository<Company> repository) {
        super(repository);
    }
}
