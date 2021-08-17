package com.delivery.respositories;

import com.delivery.domain.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaggageRepository extends JpaRepository<Baggage, Integer> {

}
