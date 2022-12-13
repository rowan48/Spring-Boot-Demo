package com.example.test.models.request;

import java.util.List;

public class UserData {
    private String fullname;
    private String email;
    private String password;
    private List<AddressData> useradresses;

    public List<AddressData> getUseradresses() {
        return useradresses;
    }

    public void setUseradresses(List<AddressData> useradresses) {
        this.useradresses = useradresses;
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




}
