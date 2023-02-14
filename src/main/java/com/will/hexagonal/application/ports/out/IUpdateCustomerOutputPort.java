package com.will.hexagonal.application.ports.out;

import com.will.hexagonal.application.core.domain.Customer;

public interface IUpdateCustomerOutputPort {

    void update(Customer customer);
}
