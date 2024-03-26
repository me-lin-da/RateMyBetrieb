package com.example.jwt.core.generic;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class ExtendedEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @PrePersist
    protected void onCreate() {
        if (Objects.isNull(this.id)) {
            this.id = UUID.randomUUID();
        }
    }

    protected ExtendedEntity() {
    }

    protected ExtendedEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}