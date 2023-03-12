package com.will.hexagonal.adapters.in.consumer;

import com.will.hexagonal.adapters.in.consumer.mapper.ICustomerMessageMapper;
import com.will.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.will.hexagonal.application.ports.in.IUpdateCustomerInputPort;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private IUpdateCustomerInputPort iUpdateCustomerInputPort;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "arantes")
    public void receive(CustomerMessage customerMessage) {

        ICustomerMessageMapper iCustomerMessageMapper = Mappers.getMapper(ICustomerMessageMapper.class);
        var customer = iCustomerMessageMapper.toCustomer(customerMessage);
        iUpdateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
