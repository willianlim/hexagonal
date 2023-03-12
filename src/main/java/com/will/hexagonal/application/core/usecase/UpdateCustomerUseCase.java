package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.IFindCustomerByIdInputPort;
import com.will.hexagonal.application.ports.in.IUpdateCustomerInputPort;
import com.will.hexagonal.application.ports.out.IFindAddressByZipCodeOutputPort;
import com.will.hexagonal.application.ports.out.IUpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements IUpdateCustomerInputPort {

    private final IFindCustomerByIdInputPort iFindCustomerByIdInputPort;

    private final IFindAddressByZipCodeOutputPort iFindAddressByZipCodeOutputPort;

    private final IUpdateCustomerOutputPort iUpdateCustomerOutputPort;

    public UpdateCustomerUseCase(
            IFindCustomerByIdInputPort iFindCustomerByIdInputPort,
            IFindAddressByZipCodeOutputPort iFindAddressByZipCodeOutputPort,
            IUpdateCustomerOutputPort iUpdateCustomerOutputPort
    ) {
        this.iFindCustomerByIdInputPort = iFindCustomerByIdInputPort;
        this.iFindAddressByZipCodeOutputPort = iFindAddressByZipCodeOutputPort;
        this.iUpdateCustomerOutputPort = iUpdateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {

        iFindCustomerByIdInputPort.find(customer.getId());
        var address = iFindAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        iUpdateCustomerOutputPort.update(customer);
    }
}
