package com.example.test.services;

import com.example.test.shared.Dto.AddressDto;
import com.example.test.shared.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdressService {
    AddressDto getAddressById(String id);
   List<AddressDto> getAddressByUser(String id);

}
