package com.flexpag.paymentscheduler.builder;

import com.flexpag.paymentscheduler.model.PaymentScheduler;
import com.flexpag.paymentscheduler.model.dto.PaymentSchedulerDTO;
import org.springframework.stereotype.Service;

@Service
public class PaymentSchedulerBuilder {
    public PaymentScheduler buildPaymentScheduler(PaymentSchedulerDTO dto) {
        return PaymentScheduler.builder()
                .schedulerDate(dto.getPaymentSchedulerDate())
                .registrationDate(dto.getRegistrationDate())
                .amountToPay(dto.getAmountToPay())
                .status(dto.getStatus())
                .build();
    }

    public PaymentSchedulerDTO buildPaymentSchedulerCreate(PaymentScheduler paymentScheduler) {
        return PaymentSchedulerDTO.builder()
                .id(paymentScheduler.getId())
                .build();
    }
}
