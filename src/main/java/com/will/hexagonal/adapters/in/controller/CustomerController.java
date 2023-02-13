package com.will.hexagonal.adapters.in.controller;

import com.will.hexagonal.adapters.in.controller.mapper.ICustomerMapper;
import com.will.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.will.hexagonal.application.ports.in.IInsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private IInsertCustomerInputPort iInsertCustomerInputPort;

    @Autowired
    private ICustomerMapper iCustomerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

        var customer = iCustomerMapper.toCustomer(customerRequest);
        iInsertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }
}
