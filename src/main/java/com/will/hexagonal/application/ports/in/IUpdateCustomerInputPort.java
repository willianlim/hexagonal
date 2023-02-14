package com.will.hexagonal.application.ports.in;

import com.will.hexagonal.application.core.domain.Customer;

public interface IUpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
