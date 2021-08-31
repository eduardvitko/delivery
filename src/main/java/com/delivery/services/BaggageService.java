package com.delivery.services;

import com.delivery.domain.Baggage;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public interface BaggageService {
  Set<Baggage> baggageFindAll();
   Baggage createBaggage(Baggage baggage);
    void deleteById(int id);
   Baggage updateBaggage(Baggage baggage);
   Baggage baggageReadById(int id);
}
