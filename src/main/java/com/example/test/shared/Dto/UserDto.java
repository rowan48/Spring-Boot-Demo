package com.example.test.shared.Dto;

import java.io.Serializable;

public class UserDto implements Serializable {
 private static  final long serialVersionUID =10l;

    private int id;
    private String userId;
    private String fullname;
    private String email;
    private String password;
    private String encryptePassword;
    private String emailVerificationToken;

    private String emailVerificationStatus;

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

    public String getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(String emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
