package com.will.hexagonal.adapters.in.consumer.mapper;

import com.will.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.will.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface ICustomerMessageMapper {

    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerMessage customerMessage);
}
