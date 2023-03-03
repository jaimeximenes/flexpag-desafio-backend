package com.flexpag.paymentscheduler.Controller;

import com.flexpag.paymentscheduler.model.PaymentScheduler;
import com.flexpag.paymentscheduler.model.PaymentStatusEnum;
import com.flexpag.paymentscheduler.repository.PaymentSchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payment-scheduler")
public class PaymentSchedulerController {
    @Autowired
    PaymentSchedulerRepository paymentSchedulerRepository;

    @PostMapping
    public ResponseEntity<Object> createNewPaymentScheduler(@RequestBody PaymentScheduler paymentScheduler) {
        try {
            paymentScheduler.setStatus(PaymentStatusEnum.pending);
            paymentSchedulerRepository.save(paymentScheduler);
            return ResponseEntity.status(HttpStatus.CREATED).body("O Id é: " + paymentScheduler.getId());
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O agendamento já foi realizado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro desconhecido!");
        }
    }
}
