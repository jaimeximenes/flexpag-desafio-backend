package com.flexpag.paymentscheduler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSchedulerUpdateDTO {

    private LocalDateTime paymentSchedulerDate;


}
