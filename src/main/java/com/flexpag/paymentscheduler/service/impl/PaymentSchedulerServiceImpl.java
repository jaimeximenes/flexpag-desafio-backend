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
    public Long createPaymentScheduler(PaymentSchedulerDTO paymentSchedulerDTO) {
        try {
            paymentSchedulerDTO.setStatus(PaymentStatusEnum.pending);
            paymentSchedulerDTO.setRegistrationDate(LocalDateTime.now());
            PaymentScheduler paymentSchedulerSaved =
                    paymentSchedulerRepository.save(paymentSchedulerBuilder.
                            buildPaymentScheduler(paymentSchedulerDTO));
            return paymentSchedulerSaved.getId();
        } catch (DataIntegrityViolationException d) {
            throw new RuntimeException("Verifique as informações do agendamento.");
        } catch (Exception e) {
            throw new RuntimeException("Excpetion");
        }
    }

    public PaymentStatusEnum findStatusByPaymentSchedulerId(Long id) {
        try {
            return paymentSchedulerRepository.findStatusById(id).orElseThrow();
        } catch (DataIntegrityViolationException d) {
            throw new RuntimeException("status não encontrado.");
        } catch (Exception e) {
            throw new RuntimeException("Excpetion");
        }
    }

    public void deletePaymentSchedulerById(Long id) {
        var status = findStatusById(id);
        if (status.equals(PaymentStatusEnum.pending)) {
            paymentSchedulerRepository.deleteById(id);
        } else {
            throw new RuntimeException("Esse id não existe");
        }
    }

    public void updatePaymentSchedulerDateById(Long id, LocalDateTime date) {
        var paymentScheduler = paymentSchedulerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado!"));
        if (PaymentStatusEnum.pending.equals(paymentScheduler.getStatus())) {
            paymentScheduler.setSchedulerDate(date);
            paymentSchedulerRepository.save(paymentScheduler);
        }

    }

    private PaymentStatusEnum findStatusById(Long id) {
        return paymentSchedulerRepository.findStatusById(id).orElseThrow();
    }
}

