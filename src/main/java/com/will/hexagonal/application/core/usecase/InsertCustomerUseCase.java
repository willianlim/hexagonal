package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.IInsertCustomerInputPort;
import com.will.hexagonal.application.ports.out.IFindAddressByZipCodeOutputPort;
import com.will.hexagonal.application.ports.out.IInsertCustomerOutputPort;
import com.will.hexagonal.application.ports.out.ISendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements IInsertCustomerInputPort {

    private final IFindAddressByZipCodeOutputPort iFindAddressByZipCodeOutputPort;

    private final IInsertCustomerOutputPort iInsertCustomerOutputPort;

    private final ISendCpfForValidationOutputPort iSendCpfForValidationOutputPort;

    public InsertCustomerUseCase(
            IFindAddressByZipCodeOutputPort iFindAddressByZipCodeOutputPort,
            IInsertCustomerOutputPort iInsertCustomerOutputPort,
            ISendCpfForValidationOutputPort iSendCpfForValidationOutputPort) {

        this.iFindAddressByZipCodeOutputPort = iFindAddressByZipCodeOutputPort;
        this.iInsertCustomerOutputPort = iInsertCustomerOutputPort;
        this.iSendCpfForValidationOutputPort = iSendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipcode) {

        var address = iFindAddressByZipCodeOutputPort.find(zipcode);
        customer.setAddress(address);
        iInsertCustomerOutputPort.inset(customer);
    }
}
