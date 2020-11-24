package com.example.inklow.builder;

import com.example.inklow.entities.Role;
import com.example.inklow.entities.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserBuilder {
    private UUID id;
    private String firstName = "";
    private String lastName = "";
    private String gender = "";
    private Date birthDate;
    private String username = "";
    private String password = "";
    private String email = "";
    private String phoneNumber = "";

    private List<Role> roles;

    public UserBuilder() { }

    public UserBuilder(UUID id) {
        this.id = id;
    }

    public UserBuilder(UUID id, String firstName, String lastName, String gender, Date birthDate, String username, String password, String email,  String phoneNumber, List<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
    }

    public UserBuilder id(UUID id) {
        this.id = id;
        return this;
    }

    public UserBuilder firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder gender(String gender) {
        this.gender = gender;
        return this;
    }

    public UserBuilder birthDate(Date birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public UserBuilder username(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder password(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder email(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public UserBuilder roles(List<Role> roles) {
        this.roles = roles;
        return this;
    }

    public User build() {
        return new User(id, firstName, lastName, gender, birthDate, username, password, email, phoneNumber, roles);
    }
}
