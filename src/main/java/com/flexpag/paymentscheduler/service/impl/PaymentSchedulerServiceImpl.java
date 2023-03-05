package com.flexpag.paymentscheduler.service.impl;

import com.flexpag.paymentscheduler.builder.PaymentSchedulerBuilder;
import com.flexpag.paymentscheduler.model.PaymentScheduler;
import com.flexpag.paymentscheduler.model.PaymentStatusEnum;
import com.flexpag.paymentscheduler.model.dto.PaymentSchedulerDTO;
import com.flexpag.paymentscheduler.repository.PaymentSchedulerRepository;
import com.flexpag.paymentscheduler.service.PaymentSchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentSchedulerServiceImpl implements PaymentSchedulerService {

    @Autowired
    PaymentSchedulerRepository paymentSchedulerRepository;
    @Autowired
    PaymentSchedulerBuilder paymentSchedulerBuilder;

    @Override
    public PaymentSchedulerDTO createPaymentScheduler(PaymentSchedulerDTO paymentSchedulerDTO) {
        try {
            paymentSchedulerDTO.setStatus(PaymentStatusEnum.pending);
            PaymentScheduler paymentSchedulerSaved =
                    paymentSchedulerRepository.save(paymentSchedulerBuilder.
                            buildPaymentScheduler(paymentSchedulerDTO));
            return paymentSchedulerBuilder.buildPaymentSchedulerCreate(paymentSchedulerSaved);
        } catch (DataIntegrityViolationException d) {
            throw new RuntimeException("Excpetion criada");
        } catch (Exception e) {
            throw new RuntimeException("Excpetion criada");
        }
    }

    public PaymentStatusEnum findStatusByPaymentSchedulerId(Long id) {
        try {
            return paymentSchedulerRepository.findStatusById(id).orElseThrow();
        } catch (DataIntegrityViolationException d) {
            throw new RuntimeException("Excpetion criada");
        } catch (Exception e) {
            throw new RuntimeException("Excpetion criada");
        }
    }

    public void deletePaymentSchedulerById(Long id) {
        var status = findStatusById(id);
        if (status.equals(PaymentStatusEnum.pending)) {
            paymentSchedulerRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }

    public void updatePaymentSchedulerDateById(Long id, LocalDateTime date) {
        var status = findStatusById(id);
        if (status.equals(PaymentStatusEnum.pending)) {
            paymentSchedulerRepository.updateSchedulerDateById(id, date);
        }
    }

    private PaymentStatusEnum findStatusById(Long id) {
        return paymentSchedulerRepository.findStatusById(id).orElseThrow();
    }
}

