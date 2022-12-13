package com.example.test.services.impl;

import com.example.test.io.entity.AddressEntity;
import com.example.test.io.repository.AddressRepository;
import com.example.test.services.AdressService;
import com.example.test.shared.Dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class AddressServiceImpl implements AdressService {
    @Autowired
    AddressRepository addressRepository;
    @Override
    public AddressDto getAddtessById(String id) {
        AddressEntity addressEntity;
        AddressDto addressDto;
        ModelMapper modelMapper = new ModelMapper();
        addressEntity=addressRepository.findByAddressId(id);
        addressDto=modelMapper.map(addressEntity,AddressDto.class);

        return addressDto;
    }
}
