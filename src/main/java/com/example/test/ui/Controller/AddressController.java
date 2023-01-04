package com.example.test.ui.Controller;

import com.example.test.io.repository.AddressRepository;
import com.example.test.models.response.AdressRet;
import com.example.test.models.response.UserRet;
import com.example.test.services.AdressService;
import com.example.test.shared.Dto.AddressDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("addresses")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
@Autowired
    AdressService adressService;


    @GetMapping(path = "/{id}")
    public AdressRet getAddress(@PathVariable String id){
        AdressRet returneddata;
        AddressDto addressDto ;
        addressDto=adressService.getAddressById(id);
        ModelMapper modelMapper = new ModelMapper();
        returneddata=modelMapper.map(addressDto,AdressRet.class);
        return returneddata;

    }
    @GetMapping(path = "/users/{UserId}/address")
    public List<AdressRet> getAddressesForUser(@PathVariable String UserId  ){
        ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<AdressRet>>() {}.getType();
       List<AddressDto> addressDtos= adressService.getAddressByUser(UserId);
            List<AdressRet> returnedData = modelMapper.map(addressDtos, listType);
        return returnedData;
    }
}
