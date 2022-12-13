package com.example.test.models.response;

import com.example.test.shared.Dto.UserDto;

public class AdressRet {
    private String addressId;
    private String city;
    private String country;
    private String streetName;
  //  private UserDto userDto;

//    public UserDto getUserDto() {
//        return userDto;
//    }
//
//    public void setUserDto(UserDto userDto) {
//        this.userDto = userDto;
//    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
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


}
