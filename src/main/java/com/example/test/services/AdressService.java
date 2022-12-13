package com.example.test.services;

import com.example.test.shared.Dto.AddressDto;
import com.example.test.shared.Dto.UserDto;
import org.springframework.stereotype.Service;


public interface AdressService {
    AddressDto getAddtessById(String id);

}
