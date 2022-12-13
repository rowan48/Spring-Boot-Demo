package com.example.test.models.response;

import com.example.test.models.request.AddressData;

import java.util.List;

public class UserRet {
    private String fullname;
    private String email;
    private String userId;
    private List<AdressRet> useradresses;

    public List<AdressRet> getUseradresses() {
        return useradresses;
    }

    public void setUseradresses(List<AdressRet> useradresses) {
        this.useradresses = useradresses;
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




}
