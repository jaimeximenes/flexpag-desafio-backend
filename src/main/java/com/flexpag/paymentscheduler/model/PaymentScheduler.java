package com.flexpag.paymentscheduler.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity(name = "TB_PAYMENT_SCHEDULER")
@Builder
public class PaymentScheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "Date")
    private LocalDateTime registrationDate;

    @Column(nullable = false, columnDefinition = "Date")
    private LocalDateTime schedulerDate;
    @Column(nullable = false)
    private Double amountToPay;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PaymentStatusEnum status;

}
