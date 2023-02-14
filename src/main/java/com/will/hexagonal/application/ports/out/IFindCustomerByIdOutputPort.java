package com.will.hexagonal.application.ports.out;

import com.will.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface IFindCustomerByIdOutputPort {

    Optional<Customer> find(String id);
}
