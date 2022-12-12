package com.example.test.io.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name="adresses")
public class AddressEntity implements Serializable {
    private static  final long serialVersionUID =10l;
    @Id
    private Long id;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String addressId;
    @Column(nullable = false)

    private String country;
    @Column(nullable = false)

    private String streetName;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity useradresses;
    public UserEntity getUseradresses() {
        return useradresses;
    }

    public void setUseradresses(UserEntity useradresses) {
        this.useradresses = useradresses;
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



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
