package com.will.hexagonal.adapters.out.repository.mapper;

import com.will.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.will.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);
    Customer toCustomer(CustomerEntity customerEntity);
}
