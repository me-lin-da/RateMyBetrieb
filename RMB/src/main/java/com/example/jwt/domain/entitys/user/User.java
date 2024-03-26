package com.example.jwt.domain.entitys.user;

import com.example.jwt.core.generic.ExtendedAuditEntity;
import com.example.jwt.domain.entitys.ranking.Rank;
import com.example.jwt.domain.role.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User extends ExtendedAuditEntity {

    @Column(name = "isNotLocked")
    private boolean isNotLocked = true;

    @Column(name = "seeds")
    private Integer seeds = 0;

    @Column(name = "age")
    private Integer age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rank rank;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(UUID id, Integer seeds, Integer age, String firstName, String lastName, String email, String password, Rank rank, Set<Role> roles) {
        super(id);
        this.seeds = seeds;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.rank = rank;
        this.roles = roles;
    }

    public Integer getSeeds() {
        return seeds;
    }

    public void setSeeds(Integer seeds) {
        this.seeds = seeds;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rank getRank() {
        return rank;
    }

    public User setRank(Rank rank) {
        this.rank = rank;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public boolean isNotLocked() {
        return isNotLocked;
    }

    public User setNotLocked(boolean notLocked) {
        isNotLocked = notLocked;
        return this;
    }
}
