package com.delivery.services;

import com.delivery.domain.Baggage;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface BaggageService {
  List<Baggage> baggageFindAll();
   Baggage createBaggage(Baggage baggage);
    void deleteById(int id);
   Baggage updateBaggage(Baggage baggage);
   Baggage baggageReadById(int id);
}
