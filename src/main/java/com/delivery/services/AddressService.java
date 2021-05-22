package com.delivery.services;

import com.delivery.domain.Address;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
    Address createAddress(Address address);
   List<Address> getAllAdresses ();
   Address readById(int id);
  void deleteById(int id);


}
