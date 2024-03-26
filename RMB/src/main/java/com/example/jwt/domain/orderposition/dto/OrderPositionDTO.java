package com.example.jwt.domain.orderposition.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.entitys.teas.dto.TeaDTO;

public class OrderPositionDTO extends ExtendedDTO {

    private Integer amount;

    private TeaDTO tea;


    public Integer getAmount() {
        return amount;
    }

    public OrderPositionDTO setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public TeaDTO getTea() {
        return tea;
    }

    public OrderPositionDTO setTea(TeaDTO tea) {
        this.tea = tea;
        return this;
    }

}
