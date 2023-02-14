package com.will.hexagonal.adapters.out;

import com.will.hexagonal.adapters.out.repository.ICustomerRepository;
import com.will.hexagonal.adapters.out.repository.mapper.ICustomerEntityMapper;
import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.out.IUpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements IUpdateCustomerOutputPort {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private ICustomerEntityMapper iCustomerEntityMapper;

    @Override
    public void update(Customer customer) {

        var customerEntity = iCustomerEntityMapper.toCustomerEntity(customer);
        iCustomerRepository.save(customerEntity);
    }
}
