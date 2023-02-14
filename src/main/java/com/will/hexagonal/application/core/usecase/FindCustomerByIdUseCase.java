package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.out.IFindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class FindCustomerByIdUseCase {

    @Autowired
    IFindCustomerByIdOutputPort iFindCustomerByIdOutputPort;

    public Customer find(String id) {

        return iFindCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found."));
    }
}
