package com.will.hexagonal.adapters.in.consumer.message;

import lombok.Data;

@Data
public class CustomerMessage {

    private String id;

    private String name;

    private String zipCode;

    private String cpf;

    private Boolean isValidCpf;
}
