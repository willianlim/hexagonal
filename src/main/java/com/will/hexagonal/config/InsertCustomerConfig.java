package com.will.hexagonal.config;

import com.will.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.will.hexagonal.adapters.out.InsertCustomerAdapter;
import com.will.hexagonal.application.core.usecase.InsertCustomerUseCase;
import com.will.hexagonal.application.ports.out.ISendCpfForValidationOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            ISendCpfForValidationOutputPort iSendCpfForValidationOutputPort
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, iSendCpfForValidationOutputPort);
    }
}
