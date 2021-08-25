package com.delivery.services;

import com.delivery.domain.Routes;
import com.delivery.respositories.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Component
public class RoutesServiceImplements implements RoutesService {

    @Autowired
   private RoutesRepository routesRepository;
    @Override
    public Routes createRoutes(Routes routes) {
        return routesRepository.save(routes);
    }

    @Override
    public Routes updateRoutes(Routes routes) {
        return routesRepository.save(routes);
    }

    @Override
    public List<Routes> getAllRoutes() {
        return routesRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        Optional<Routes> routes= routesRepository.findById(id);
        routesRepository.deleteById(id);
    }

    @Override
    public Routes readById(int id) {
        return routesRepository.getOne(id);
    }
}
