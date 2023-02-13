package com.will.hexagonal.adapters.out;

import com.will.hexagonal.adapters.out.client.IFindAddressByZipCodeClient;
import com.will.hexagonal.adapters.out.client.response.AddressResponse;
import com.will.hexagonal.application.core.domain.Address;
import com.will.hexagonal.application.ports.out.IFindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements IFindAddressByZipCodeOutputPort {

    @Autowired
    private IFindAddressByZipCodeClient iFindAddressByZipCodeClient;

    @Autowired
    private AddressResponse addressResponse;

    @Override
    public Address find(String zipCode) {

        var addressResponse = iFindAddressByZipCodeClient.find(zipCode);
        return null;
    }
}
