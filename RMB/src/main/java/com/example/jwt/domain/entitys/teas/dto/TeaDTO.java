package com.example.jwt.domain.entitys.teas.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.entitys.country.dto.CountryDTO;
import com.example.jwt.domain.entitys.teatype.dto.TeaTypeDTO;

import java.util.Date;

public class TeaDTO extends ExtendedDTO {

    private Integer amountInStock;
    private String description;

    private float price;

    private Date harvestDate;

    private TeaTypeDTO teaType;

    private CountryDTO country;

    public TeaDTO() {

    }

    public String getDescription() {
        return description;
    }

    public TeaDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public TeaDTO setPrice(float price) {
        this.price = price;
        return this;
    }

    public Date getHarvestDate() {
        return harvestDate;
    }

    public TeaDTO setHarvestDate(Date harvestDate) {
        this.harvestDate = harvestDate;
        return this;
    }

    public TeaTypeDTO getTeaType() {
        return teaType;
    }

    public TeaDTO setTeaType(TeaTypeDTO teaType) {
        this.teaType = teaType;
        return this;
    }

    public CountryDTO getCountry() {
        return country;
    }

    public TeaDTO setCountry(CountryDTO country) {
        this.country = country;
        return this;
    }

    public Integer getAmountInStock() {
        return amountInStock;
    }

    public TeaDTO setAmountInStock(Integer amountInStock) {
        this.amountInStock = amountInStock;
        return this;
    }
}
