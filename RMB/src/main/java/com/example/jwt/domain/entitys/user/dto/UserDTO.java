package com.example.jwt.domain.entitys.user.dto;

import com.example.jwt.core.generic.ExtendedDTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class UserDTO extends ExtendedDTO {

    private Integer age;
    @Min(value = 0)
    private Integer seeds;

    private String firstName;

    private String lastName;

    @Email
    private String email;

//    private Set<RoleDTO> roles;

    public UserDTO() {
    }

    public Integer getAge() {
        return age;
    }

    public UserDTO setAge(Integer age) {
        this.age = age;
        return this;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSeeds() {
        return seeds;
    }

    public void setSeeds(Integer seeds) {
        this.seeds = seeds;
    }

}