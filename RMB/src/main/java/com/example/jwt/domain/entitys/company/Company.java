package com.example.jwt.domain.entitys.company;

import com.example.jwt.core.generic.ExtendedAuditEntity;
import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company extends ExtendedAuditEntity {

    @Column(name = "companyName")
    private String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

}
