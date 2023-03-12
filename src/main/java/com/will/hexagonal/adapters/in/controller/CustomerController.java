package com.will.hexagonal.adapters.in.controller;

import com.will.hexagonal.adapters.in.controller.mapper.ICustomerMapper;
import com.will.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.will.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.will.hexagonal.application.core.domain.Customer;
import com.will.hexagonal.application.ports.in.IDeleteCustomerByIdIputPort;
import com.will.hexagonal.application.ports.in.IFindCustomerByIdInputPort;
import com.will.hexagonal.application.ports.in.IInsertCustomerInputPort;
import com.will.hexagonal.application.ports.in.IUpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private IInsertCustomerInputPort iInsertCustomerInputPort;

    @Autowired
    private IFindCustomerByIdInputPort iFindCustomerByIdInputPort;

    @Autowired
    private IUpdateCustomerInputPort iUpdateCustomerInputPort;

    @Autowired
    private IDeleteCustomerByIdIputPort iDeleteCustomerByIdIputPort;

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {

        ICustomerMapper iCustomerMapper = Mappers.getMapper(ICustomerMapper.class);
        var customer = iCustomerMapper.toCustomer(customerRequest);
        iInsertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id) {

        var customer = iFindCustomerByIdInputPort.find(id);
        ICustomerMapper iCustomerMapper = Mappers.getMapper(ICustomerMapper.class);
        var customerResponse = iCustomerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable final String id,
                                       @Valid @RequestBody CustomerRequest customerRequest) {

        ICustomerMapper iCustomerMapper = Mappers.getMapper(ICustomerMapper.class);
        Customer customer = iCustomerMapper.toCustomer(customerRequest);
        customer.setId(id);
        iUpdateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) {

        iDeleteCustomerByIdIputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
