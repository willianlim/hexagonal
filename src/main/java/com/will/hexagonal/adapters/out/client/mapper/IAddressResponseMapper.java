package com.will.hexagonal.adapters.out.client.mapper;

import com.will.hexagonal.adapters.out.client.response.AddressResponse;
import com.will.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);
}
