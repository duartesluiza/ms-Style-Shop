package com.api.msCheckout.services;

import com.api.msCheckout.models.PaymentsModel;
import com.api.msCheckout.repositories.PaymentsRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentsService {

    final PaymentsRepository paymentsRepository;

    public PaymentsService(PaymentsRepository paymentsRepository) {
        this.paymentsRepository = paymentsRepository;
    }

    @Transactional
    public PaymentsModel save(PaymentsModel paymentsModel) {
        return paymentsRepository.save(paymentsModel);
    }

    public List<PaymentsModel> findAll() {
        return paymentsRepository.findAll();
    }

    public Optional<PaymentsModel> findById(UUID id) {
        return paymentsRepository.findById(id);
    }

    @Transactional
    public void delete(PaymentsModel usuarioModel) {
        paymentsRepository.delete(usuarioModel);
    }
}
