package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.IFindCustomerByIdInputPort;
import com.will.hexagonal.application.ports.out.IFindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class FindCustomerByIdUseCase implements IFindCustomerByIdInputPort {

    @Autowired
    IFindCustomerByIdOutputPort iFindCustomerByIdOutputPort;

    @Override
    public Customer find(String id) {

        return iFindCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found."));
    }
}
