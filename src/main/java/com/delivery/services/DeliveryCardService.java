package com.delivery.services;

import com.delivery.domain.DeliveryCard;
import org.springframework.stereotype.Service;

@Service
public interface DeliveryCardService {
    DeliveryCard createDeliveryCard(DeliveryCard deliveryCard);
}
