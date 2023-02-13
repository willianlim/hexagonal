package com.will.hexagonal.application.core.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer {

    public Customer() {
        this.isValidCpf = false;
    }

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private Boolean isValidCpf;
}
