package com.flexpag.paymentscheduler.model.dto;

import com.flexpag.paymentscheduler.model.PaymentStatusEnum;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PaymentSchedulerDTO {
    private Long id;

    private LocalDateTime registrationDate;

    @NotNull
    private LocalDateTime paymentSchedulerDate;
    @NotNull
    private Double amountToPay;

    private PaymentStatusEnum status;
}
