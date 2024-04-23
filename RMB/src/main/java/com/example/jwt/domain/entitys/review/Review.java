package com.example.jwt.domain.entitys.review;

import com.example.jwt.core.generic.ExtendedAuditEntity;
import com.example.jwt.domain.entitys.company.Company;

import javax.persistence.*;


@Entity
@Table(name = "review")
public class Review extends ExtendedAuditEntity {

    @Column(name = "Title")
    private String title;

    @Column(name = "Text")
    private String text;

    @ManyToOne( cascade = CascadeType.PERSIST)
    @JoinColumn(name = "company_id", referencedColumnName = "id", nullable = false)
    private Company company;

    public String getTitle() {
        return title;
    }

    public Review setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getText() {
        return text;
    }

    public Review setText(String text) {
        this.text = text;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Review setCompany(Company company) {
        this.company = company;
        return this;
    }
}
