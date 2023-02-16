package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.IInsertCustomerInputPort;
import com.will.hexagonal.application.ports.out.IFindAddressByZipCodeOutputPort;
import com.will.hexagonal.application.ports.out.IInsertCustomerOutputPort;
import com.will.hexagonal.application.ports.out.ISendCpfForValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class InsertCustomerUseCase implements IInsertCustomerInputPort {

    @Autowired
    IFindAddressByZipCodeOutputPort iFindAddressByZipCodeOutputPort;

    @Autowired
    IInsertCustomerOutputPort iInsertCustomerOutputPort;

    public void insert(Customer customer, String zipcode) {

        var address = iFindAddressByZipCodeOutputPort.find(zipcode);
        customer.setAddress(address);
        iInsertCustomerOutputPort.inset(customer);
    }
}
