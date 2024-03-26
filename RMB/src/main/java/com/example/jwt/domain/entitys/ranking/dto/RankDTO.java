package com.example.jwt.domain.entitys.ranking.dto;

import com.example.jwt.core.generic.ExtendedDTO;

public class RankDTO extends ExtendedDTO {

    String title;
    int seeds;
    float reduction;
    private Integer discount;

    public String getTitle() {
        return title;
    }

    public RankDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getSeeds() {
        return seeds;
    }

    public RankDTO setSeeds(int seeds) {
        this.seeds = seeds;
        return this;
    }

    public float getReduction() {
        return reduction;
    }

    public RankDTO setReduction(float reduction) {
        this.reduction = reduction;
        return this;
    }

    public Integer getDiscount() {
        return discount;
    }

    public RankDTO setDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }
}
