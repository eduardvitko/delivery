package com.delivery.services;

import com.delivery.domain.DeliveryCard;
import org.springframework.stereotype.Service;

@Service
public interface DeliveryCardService {
    DeliveryCard createDeliveryCard(DeliveryCard deliveryCard);
    DeliveryCard updateDeliveryCard(DeliveryCard deliveryCard);
    DeliveryCard readById(int id);
    void deleteById(int id);
}
