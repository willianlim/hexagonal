package com.will.hexagonal.application.core.usecase;

import com.will.hexagonal.application.ports.in.IDeleteCustomerByIdIputPort;
import com.will.hexagonal.application.ports.in.IFindCustomerByIdInputPort;
import com.will.hexagonal.application.ports.out.IDeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements IDeleteCustomerByIdIputPort {

    private final IFindCustomerByIdInputPort iFindCustomerByIdInputPort;

    private final IDeleteCustomerByIdOutputPort iDeleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(
            IFindCustomerByIdInputPort iFindCustomerByIdInputPort,
            IDeleteCustomerByIdOutputPort iDeleteCustomerByIdOutputPort
    ) {
        this.iFindCustomerByIdInputPort = iFindCustomerByIdInputPort;
        this.iDeleteCustomerByIdOutputPort = iDeleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id) {

        iFindCustomerByIdInputPort.find(id);
        iDeleteCustomerByIdOutputPort.delete(id);
    }
}
