package com.api.msCheckout.controllers;

import com.api.msCheckout.controllers.dto.PaymentsDto;
import com.api.msCheckout.models.PaymentsModel;
import com.api.msCheckout.services.PaymentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/payments")
public class PaymentsController {

    // ponto de injeção
    final PaymentsService paymentsService;

    public PaymentsController(PaymentsService paymentsService) {
        this.paymentsService = paymentsService;
    }

    @Transactional
    @RequestMapping(value = "create",
            method = RequestMethod.POST)
    public ResponseEntity<Object> create(@RequestBody @Valid PaymentsDto paymentsDto) {
        var paymentsModel = new PaymentsModel();
        BeanUtils.copyProperties(paymentsDto, paymentsModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(paymentsService.save(paymentsModel));
    }

    @RequestMapping(value = "findall",
            method = RequestMethod.GET)
    public ResponseEntity<List<PaymentsModel>> getAllUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(paymentsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePayments(@PathVariable(value = "id") UUID id) {
        Optional<PaymentsModel> usuarioModelOptional = paymentsService.findById(id);
        if (!usuarioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePayments(@PathVariable(value = "id") UUID id) {
        Optional<PaymentsModel> paymentsModelOptional = paymentsService.findById(id);
        if (!paymentsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payments not found.");
        }
        paymentsService.delete(paymentsModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Payments deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePayments(@PathVariable(value = "id") UUID id, @RequestBody @Valid PaymentsDto paymentsDto){
        Optional<PaymentsModel> paymentsModelOptional = paymentsService.findById(id);
        if (!paymentsModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payments not found.");
        }
//
        var paymentsModel = new PaymentsModel();
        BeanUtils.copyProperties(paymentsDto, paymentsModel);
        paymentsModel.setId(paymentsModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(paymentsService.save(paymentsModel));

    }
}
