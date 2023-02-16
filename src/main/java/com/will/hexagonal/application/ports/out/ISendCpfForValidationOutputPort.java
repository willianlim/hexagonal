package com.will.hexagonal.application.ports.out;

public interface ISendCpfForValidationOutputPort {

    void send(String cpf);
}
