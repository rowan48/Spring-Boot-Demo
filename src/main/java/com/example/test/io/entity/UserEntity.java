package com.example.test.io.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity(name="users")
public class UserEntity implements  Serializable {
    private static  final long serialVersionUID =10l;
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)

    private String userId;
    @Column(nullable = false)
    private String fullname;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "useradresses",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AddressEntity> useradresses;


    public List<AddressEntity> getUseradresses() {
        return useradresses;
    }

    public void setUseradresses(List<AddressEntity> useradresses) {
        this.useradresses = useradresses;
    }



    private String encryptePassword;
    private String emailVerificationToken;
    private boolean emailVerificationStatus=false;
    public boolean isEmailVerificationStatus() {
        return emailVerificationStatus;
    }


    public void setEmailVerificationStatus(boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getEncryptePassword() {
        return encryptePassword;
    }

    public void setEncryptePassword(String encryptePassword) {
        this.encryptePassword = encryptePassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }





    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
