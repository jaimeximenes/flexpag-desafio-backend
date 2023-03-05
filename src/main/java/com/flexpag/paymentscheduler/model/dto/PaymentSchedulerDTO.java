package com.flexpag.paymentscheduler.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.flexpag.paymentscheduler.model.PaymentStatusEnum;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class PaymentSchedulerDTO {
    private Long id;
    @JsonFormat(pattern = "dd/mm/yyyy")
    @NotNull
    private LocalDateTime registrationDate;

    @JsonFormat(pattern = "dd/mm/yyyy")
    @NotNull
    private LocalDateTime paymentSchedulerDate;
    @NotNull
    private Double amountToPay;

    private PaymentStatusEnum status;
}
