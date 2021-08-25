package com.delivery.services;

import com.delivery.domain.Routes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoutesService {
    Routes createRoutes(Routes routes);
    Routes updateRoutes(Routes routes);
    List<Routes> getAllRoutes();
    void deleteById(int id);
    Routes readById(int id);
}
