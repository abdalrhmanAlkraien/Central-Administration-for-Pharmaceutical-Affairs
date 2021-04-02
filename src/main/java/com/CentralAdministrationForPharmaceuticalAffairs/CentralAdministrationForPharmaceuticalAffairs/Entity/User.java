package com.CentralAdministrationForPharmaceuticalAffairs.CentralAdministrationForPharmaceuticalAffairs.Entity;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "password")
    private String password;

    @Column(name = "token")
    private String token;

    @Column(name = "email")
    private String email;

    @Column(name = "salt")
    private String salt;

    @Column(name = "access")
    private String access;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(createdAt, user.createdAt) &&
                Objects.equals(password, user.password) &&
                Objects.equals(token, user.token) &&
                Objects.equals(email, user.email) &&
                Objects.equals(salt, user.salt) &&
                Objects.equals(access, user.access);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, createdAt, password, token, email, salt, access);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt=" + createdAt +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", email='" + email + '\'' +
                ", salt='" + salt + '\'' +
                ", access='" + access + '\'' +
                '}';
    }

    public String validation(){
        String valid="";

        if (getId()!=null)
        {
            valid+="id must be empty ";
        }

        if(getFirstName()==null)
        {
            valid+="First name is null";
        }
        if(getLastName()==null)
        {
            valid+="Last name is null";
        }
        if(getEmail()==null)
        {
            valid+="Email is null";
        }
        if(getPassword()==null)
        {
            valid+="Password is null";
        }

        if (!getAccess().toLowerCase().equals("admin") && !getAccess().toLowerCase().equals("user"))
        {
            valid+="Access name is wrong";
        }
        return valid;
    }
}
