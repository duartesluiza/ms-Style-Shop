package com.api.msCheckout.repositories;

import com.api.msCheckout.models.PaymentsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentsRepository extends JpaRepository<PaymentsModel, UUID> {
}
