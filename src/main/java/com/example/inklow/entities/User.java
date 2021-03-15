package com.example.inklow.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User {
    private final UUID id;
    private String firstName;
    private String lastName;
    private final String gender;
    private final Date birthDate;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    private List<Role> roles;
    private List<ReportInquiry> reportInquiries;

    public User(UUID id, String firstName, String lastName, String gender, Date birthDate, String username, String password, String email,  String phoneNumber, List<Role> roles, List<ReportInquiry> reportInquiries) {
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
        this.reportInquiries = reportInquiries;
    }

    public UUID getId() {
        return id;
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

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<ReportInquiry> getReportInquiries() {
        return reportInquiries;
    }

    public void setReportInquiries(List<ReportInquiry> reportInquiries) {
        this.reportInquiries = reportInquiries;
    }

    public final static class Builder {
        private UUID id;
        private String firstName = "";
        private String lastName = "";
        private String gender = "";
        private Date birthDate;
        private String username = "";
        private String password = "";
        private String email = "";
        private String phoneNumber = "";

        private List<Role> roles = new ArrayList<>();
        private List<ReportInquiry> reportInquiries = new ArrayList<>();

        public Builder() { }

        public Builder(UUID id) {
            this.id = id;
        }

        public Builder(UUID id, String firstName,
                       String lastName,
                       String gender,
                       Date birthDate,
                       String username,
                       String password,
                       String email,
                       String phoneNumber,
                       List<Role> roles,
                       List<ReportInquiry> reportInquiries) {
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
            this.reportInquiries = reportInquiries;
        }

        public Builder id(UUID id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder birthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder roles(List<Role> roles) {
            this.roles = roles;
            return this;
        }

        public Builder reportInquiries(List<ReportInquiry> reportInquiries) {
            this.reportInquiries = reportInquiries;
            return this;
        }

        public User build() {
            return new User(id, firstName, lastName, gender, birthDate, username, password, email, phoneNumber, roles, reportInquiries);
        }

    }
}