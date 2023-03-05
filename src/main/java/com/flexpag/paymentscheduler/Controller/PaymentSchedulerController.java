package com.flexpag.paymentscheduler.Controller;

import com.flexpag.paymentscheduler.model.PaymentScheduler;
import com.flexpag.paymentscheduler.model.PaymentStatusEnum;
import com.flexpag.paymentscheduler.repository.PaymentSchedulerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<Page<PaymentScheduler>> getAllPaymentScheduler(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "5") String size) {
        Pageable paging = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        return ResponseEntity.status(HttpStatus.OK).body(paymentSchedulerRepository.findAll(paging));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<PaymentScheduler>> getPaymentSchedulerById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(paymentSchedulerRepository.findById(id));
    }
}
