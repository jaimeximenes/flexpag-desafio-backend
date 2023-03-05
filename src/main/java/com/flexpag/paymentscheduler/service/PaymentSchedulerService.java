package com.flexpag.paymentscheduler.service;

import com.flexpag.paymentscheduler.model.PaymentStatusEnum;
import com.flexpag.paymentscheduler.model.dto.PaymentSchedulerDTO;

import java.time.LocalDateTime;

public interface PaymentSchedulerService {

    PaymentSchedulerDTO createPaymentScheduler(PaymentSchedulerDTO paymentScheduler);

    PaymentStatusEnum findStatusByPaymentSchedulerId(Long id);

    void deletePaymentSchedulerById(Long id);
    void updatePaymentSchedulerDateById(Long id, LocalDateTime date);

}
