package com.example.jwt.domain.entitys.company;

import com.example.jwt.core.generic.ExtendedAuditEntity;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "company")
public class Company extends ExtendedAuditEntity {

    @Column(name = "companyName")
    private String companyName;

    @Column(name= "description")
    private String description;

    public Company(String companyName, String description) {
        this.companyName = companyName;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

}
