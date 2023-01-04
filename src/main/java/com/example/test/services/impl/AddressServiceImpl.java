package com.example.test.services.impl;

import com.example.test.io.entity.AddressEntity;
import com.example.test.io.entity.UserEntity;
import com.example.test.io.repository.AddressRepository;
import com.example.test.io.repository.UserRepository;
import com.example.test.services.AdressService;
import com.example.test.shared.Dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class AddressServiceImpl implements AdressService {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public AddressDto getAddressById(String id) {
        AddressEntity addressEntity;
        AddressDto addressDto;
        ModelMapper modelMapper = new ModelMapper();
        addressEntity= addressRepository.findByAddressId(id);
       // addressEntity=addressRepository.findByAddressId(id);
        addressDto=modelMapper.map(addressEntity,AddressDto.class);

        return addressDto;
    }

    @Override
    public List<AddressDto> getAddressByUser(String id) {
        List<AddressDto> addressDtos=new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity =userRepository.findByUserId(id);
        if(userEntity==null )return  addressDtos;
      Iterable<AddressEntity> addressEntities=  addressRepository.findAllByuseradresses(userEntity);
      for(AddressEntity addressEntity: addressEntities){
          addressDtos.add(modelMapper.map(addressEntity,AddressDto.class));
      }
        return  addressDtos;
    }
}
