package com.example.test.models.request;

import com.example.test.shared.Dto.UserDto;

public class AddressData {
    private String city;
    private String country;
    private String streetName;
    private UserDto useradresses;

    public UserDto getUseradresses() {
        return useradresses;
    }

    public void setUseradresses(UserDto useradresses) {
        this.useradresses = useradresses;
    }




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String postalCode;
    private String type;


}
