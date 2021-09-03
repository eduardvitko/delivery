package com.delivery.services;

import com.delivery.domain.DeliveryCard;
import com.delivery.respositories.DeliveryCardRepository;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class DeliveryCardServiceImplements implements DeliveryCardService {
    @Resource
    private DeliveryCardRepository deliveryCardRepository;

    @Override
    public DeliveryCard updateDeliveryCard(DeliveryCard deliveryCard) {
        return deliveryCardRepository.save(deliveryCard);
    }

    @Override
    public DeliveryCard readById(int id) {
        Optional<DeliveryCard>deliveryCard = deliveryCardRepository.findById(id);
        return deliveryCardRepository.getOne(id);
    }

    @Override
    public void deleteById(int id) {
        Optional<DeliveryCard>deliveryCard = deliveryCardRepository.findById(id);
        deliveryCardRepository.deleteById(id);
    }

    @Override
    public DeliveryCard createDeliveryCard(DeliveryCard deliveryCard) {
        return deliveryCardRepository.save(deliveryCard);

    }
}
