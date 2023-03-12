package com.will.hexagonal.adapters.out;

import com.will.hexagonal.adapters.out.repository.ICustomerRepository;
import com.will.hexagonal.adapters.out.repository.mapper.ICustomerEntityMapper;
import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.out.IFindCustomerByIdOutputPort;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements IFindCustomerByIdOutputPort {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Optional<Customer> find(String id) {

        var customerEntity = iCustomerRepository.findById(id);
        ICustomerEntityMapper iCustomerEntityMapper = Mappers.getMapper(ICustomerEntityMapper.class);
        return customerEntity.map(entity -> iCustomerEntityMapper.toCustomer(entity));
    }
}
