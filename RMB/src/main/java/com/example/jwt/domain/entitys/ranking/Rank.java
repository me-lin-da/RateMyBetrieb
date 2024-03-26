package com.example.jwt.domain.entitys.ranking;

import com.example.jwt.core.generic.ExtendedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "rank")
public class Rank extends ExtendedEntity {

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "seeds", nullable = false)
    private int seeds;

    @Column(name = "value_order", nullable = false)
    private int valueOrder;

    @Column(name = "reduction", nullable = false)
    private float reduction;


    public Rank() {

    }

    public Rank(UUID id, Integer discount, String title, int seeds, int valueOrder, float reduction) {
        super(id);
        this.discount = discount;
        this.title = title;
        this.seeds = seeds;
        this.valueOrder = valueOrder;
        this.reduction = reduction;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Rank setDiscount(Integer discount) {
        this.discount = discount;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSeeds() {
        return seeds;
    }

    public void setSeeds(int seeds) {
        this.seeds = seeds;
    }

    public float getReduction() {
        return reduction;
    }

    public void setReduction(float reduction) {
        this.reduction = reduction;
    }

    public int getValueOrder() {
        return valueOrder;
    }

    public Rank setValueOrder(int valueOrder) {
        this.valueOrder = valueOrder;
        return this;
    }
}
