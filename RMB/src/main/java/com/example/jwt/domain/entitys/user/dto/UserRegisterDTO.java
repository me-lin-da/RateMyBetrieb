package com.example.jwt.domain.entitys.user.dto;

import com.example.jwt.core.generic.ExtendedDTO;
import com.example.jwt.domain.role.dto.RoleDTO;

import javax.validation.constraints.Email;
import java.util.Set;
import java.util.UUID;

public class UserRegisterDTO extends ExtendedDTO {

    private Integer age;
    private String firstName;

    private String lastName;

    @Email
    private String email;

    private String password;

    private Set<RoleDTO> roles;

    public UserRegisterDTO() {
    }

    public UserRegisterDTO(UUID id, Integer age, String firstName, String lastName, String email, String password, Set<RoleDTO> roles) {
        super(id);
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleDTO> roles) {
        this.roles = roles;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegisterDTO setAge(Integer age) {
        this.age = age;
        return this;
    }
}
