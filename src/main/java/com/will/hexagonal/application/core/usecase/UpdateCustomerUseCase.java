package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.IFindCustomerByIdInputPort;
import com.will.hexagonal.application.ports.out.IFindAddressByZipCodeOutputPort;
import com.will.hexagonal.application.ports.out.IUpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateCustomerUseCase {

    @Autowired
    private IFindCustomerByIdInputPort iFindCustomerByIdInputPort;

    @Autowired
    private IFindAddressByZipCodeOutputPort iFindAddressByZipCodeOutputPort;

    @Autowired
    private IUpdateCustomerOutputPort iUpdateCustomerOutputPort;

    public void update(Customer customer, String zipCode) {

        iFindCustomerByIdInputPort.find(customer.getId());
        var address = iFindAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
    }
}
