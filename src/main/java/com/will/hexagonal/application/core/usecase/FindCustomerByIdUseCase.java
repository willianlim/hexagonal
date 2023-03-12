package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.IFindCustomerByIdInputPort;
import com.will.hexagonal.application.ports.out.IFindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements IFindCustomerByIdInputPort {

    private final IFindCustomerByIdOutputPort iFindCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(IFindCustomerByIdOutputPort iFindCustomerByIdOutputPort) {
        this.iFindCustomerByIdOutputPort = iFindCustomerByIdOutputPort;
    }

    @Override
    public Customer find(String id) {

        return iFindCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found."));
    }
}
