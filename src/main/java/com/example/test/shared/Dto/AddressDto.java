package com.example.test.shared.Dto;

public class AddressDto {
    private long id;
    private String addressId;
    private String city;
    private UserDto useradresses;

    public UserDto getUseradresses() {
        return useradresses;
    }

    public void setUseradresses(UserDto useradresses) {
        this.useradresses = useradresses;
    }







    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    private String country;
    private String streetName;

}
