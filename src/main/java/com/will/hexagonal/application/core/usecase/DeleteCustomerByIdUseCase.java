package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.ports.in.IDeleteCustomerByIdIputPort;
import com.will.hexagonal.application.ports.in.IFindCustomerByIdInputPort;
import com.will.hexagonal.application.ports.out.IDeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteCustomerByIdUseCase implements IDeleteCustomerByIdIputPort {

    @Autowired
    private IFindCustomerByIdInputPort iFindCustomerByIdInputPort;

    @Autowired
    private IDeleteCustomerByIdOutputPort iDeleteCustomerByIdOutputPort;

    @Override
    public void delete(String id) {

        iFindCustomerByIdInputPort.find(id);
        iDeleteCustomerByIdOutputPort.delete(id);
    }
}
