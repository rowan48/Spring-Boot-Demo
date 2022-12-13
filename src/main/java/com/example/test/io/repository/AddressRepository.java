package com.example.test.io.repository;

import com.example.test.io.entity.AddressEntity;
import com.example.test.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<AddressEntity, Long> {

List<AddressEntity> findAllByuseradresses(UserEntity userEntity);
 AddressEntity findByAddressId(String AddressId);
}
