package com.example.test.io.repository;

import com.example.test.io.entity.AddressEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AddressRepository extends CrudRepository<AddressEntity, Long>, PagingAndSortingRepository<AddressEntity,Long> {
AddressEntity findByAddressId(String id);
}
