package com.will.hexagonal.adapters.out;

import com.will.hexagonal.adapters.out.repository.ICustomerRepository;
import com.will.hexagonal.adapters.out.repository.mapper.ICustomerEntityMapper;
import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.out.IInsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements IInsertCustomerOutputPort {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Autowired
    private ICustomerEntityMapper iCustomerEntityMapper;

    @Override
    public void inset(Customer customer) {

        var customerEntity = iCustomerEntityMapper.toCustomerEntity(customer);
        iCustomerRepository.save(customerEntity);
    }
}
