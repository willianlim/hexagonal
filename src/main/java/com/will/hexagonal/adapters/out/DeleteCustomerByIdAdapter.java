package com.will.hexagonal.adapters.out;

import com.will.hexagonal.adapters.out.repository.ICustomerRepository;
import com.will.hexagonal.application.ports.out.IDeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements IDeleteCustomerByIdOutputPort {

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public void delete(String id) {

        iCustomerRepository.deleteById(id);
    }
}
