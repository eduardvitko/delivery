package com.delivery.services;

import com.delivery.domain.Baggage;
import com.delivery.respositories.BaggageRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class BaggageServiceImp implements BaggageService {


    @Resource
    private BaggageRepository baggageRepository;


    @Override
    public Baggage createBaggage(Baggage baggage) {
        return baggageRepository.save(baggage);
    }

    @Override
    public Baggage updateBaggage(Baggage baggage) {
        return baggageRepository.save(baggage);
    }

    @Override
    public void deleteById(int id) {
Optional<Baggage> baggage =baggageRepository.findById(id);
baggageRepository.deleteById(id);
    }

    @Override
    public List<Baggage> baggageFindAll() {
        return baggageRepository.findAll();
    }

    @Override
    public Baggage baggageReadById(int id) {
        Optional<Baggage> baggage =baggageRepository.findById(id);
        return baggage.get();
    }
}
