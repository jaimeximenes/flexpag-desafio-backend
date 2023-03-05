package com.flexpag.paymentscheduler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity(name = "TB_PAYMENT_SCHEDULER")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentScheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "Date")
    private LocalDateTime registrationDate;

    @Column(nullable = false, columnDefinition = "Date")
    private LocalDateTime schedulerDate;
    @Column(nullable = false)
    private Double amountToPay;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PaymentStatusEnum status;

}
