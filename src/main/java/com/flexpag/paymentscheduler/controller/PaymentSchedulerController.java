package com.flexpag.paymentscheduler.controller;

import com.flexpag.paymentscheduler.model.PaymentStatusEnum;
import com.flexpag.paymentscheduler.model.dto.PaymentSchedulerDTO;
import com.flexpag.paymentscheduler.model.dto.PaymentSchedulerUpdateDTO;
import com.flexpag.paymentscheduler.service.PaymentSchedulerService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/payment-scheduler")
public class PaymentSchedulerController {
    @Autowired
    PaymentSchedulerService paymentSchedulerService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody PaymentSchedulerDTO paymentSchedulerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentSchedulerService.createPaymentScheduler(paymentSchedulerDTO));
    }

    @GetMapping(value = "/status/{id}")
    public ResponseEntity<PaymentStatusEnum> findById(
            @NotNull
            @PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentSchedulerService
                .findStatusByPaymentSchedulerId(id));
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<Object> updateSchedulerDateById(
            @RequestBody PaymentSchedulerUpdateDTO dto,
            @PathVariable("id") Long id) {

        paymentSchedulerService.updatePaymentSchedulerDateById(id, dto.getPaymentSchedulerDate());
        return ResponseEntity.status(HttpStatus.OK).body("Agendamento atualizado com sucesso!");

    }

    @DeleteMapping(value = {"/{id}"})
    public ResponseEntity<String> deletePaymentSchedulerById(
            @PathVariable("id") Long id) {
        paymentSchedulerService.deletePaymentSchedulerById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Excluido com sucesso!");
    }

}