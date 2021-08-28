package com.delivery.services;

import com.delivery.domain.DeliveryCard;
import com.delivery.respositories.DeliveryCardRepository;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DeliveryCardServiceImplements implements DeliveryCardService {
    @Resource
    private DeliveryCardRepository deliveryCardRepository;

    @Override
    public DeliveryCard createDeliveryCard(DeliveryCard deliveryCard) {
        return deliveryCardRepository.save(deliveryCard);

    }
}
