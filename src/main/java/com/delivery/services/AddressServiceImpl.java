package com.delivery.services;

import com.delivery.domain.Address;
import com.delivery.respositories.AddressRepository;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class AddressServiceImpl implements AddressService {
    @Resource
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAllAdresses() {
        return addressRepository.findAll();
    }

    @Override
    public Address readById(int id) {
        return addressRepository.getOne(id);
    }

    @Override
    public void deleteById(int id){
        Optional<Address> address = addressRepository.findById(id);
        addressRepository.deleteById(id);
    }

    @Override
    public Address createAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }
}
