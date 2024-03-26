package com.example.jwt.domain.entitys.teatype.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.entitys.ranking.Rank;

public class TeaTypeDTO extends ExtendedDTO {

    private Integer age;
    private Rank rank;

    private String teaType;

    public Rank getRank() {
        return rank;
    }

    public TeaTypeDTO setRank(Rank rank) {
        this.rank = rank;
        return this;
    }

    public String getTeaType() {
        return teaType;
    }

    public TeaTypeDTO setTeaType(String teaType) {
        this.teaType = teaType;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public TeaTypeDTO setAge(Integer age) {
        this.age = age;
        return this;
    }
}
