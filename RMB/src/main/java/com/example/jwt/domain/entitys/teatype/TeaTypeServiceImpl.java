package com.example.jwt.domain.entitys.teatype;

import com.example.jwt.core.generic.ExtendedServiceImpl;

public class TeaTypeServiceImpl extends ExtendedServiceImpl<TeaType> implements TeaTypeService {

    protected TeaTypeServiceImpl(TeaTypeRepository repository) {
        super(repository);
    }

}
