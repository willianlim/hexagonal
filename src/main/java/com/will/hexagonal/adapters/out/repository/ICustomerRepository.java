package com.will.hexagonal.adapters.out.repository;

import com.will.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICustomerRepository extends MongoRepository<CustomerEntity, String> {
}
