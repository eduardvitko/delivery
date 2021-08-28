package com.delivery.respositories;

import com.delivery.domain.DeliveryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryCardRepository extends JpaRepository<DeliveryCard,Integer> {
}
