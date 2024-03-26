package com.example.jwt.domain.entitys.teatype;

import com.example.jwt.core.generic.ExtendedEntity;
import com.example.jwt.domain.entitys.ranking.Rank;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tea_type")
public class TeaType extends ExtendedEntity {
    @Column(name = "age_restriction")
    private Integer age;
    @Column(name = "tea_type", unique = true, nullable = false)
    private String teatype;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "required_rank", referencedColumnName = "id")
    private Rank rank;

    public TeaType() {

    }

    public TeaType(UUID id, Integer age, String teatype, Rank rank) {
        super(id);
        this.age = age;
        this.teatype = teatype;
        this.rank = rank;
    }

    public String getTeatype() {
        return teatype;
    }

    public TeaType setTeatype(String teatype) {
        this.teatype = teatype;
        return this;
    }

    public Rank getRank() {
        return rank;
    }

    public TeaType setRank(Rank rank) {
        this.rank = rank;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public TeaType setAge(Integer age) {
        this.age = age;
        return this;
    }
}
