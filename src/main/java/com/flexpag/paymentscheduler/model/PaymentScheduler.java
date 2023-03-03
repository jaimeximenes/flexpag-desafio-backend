package com.flexpag.paymentscheduler.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.xml.bind.v2.model.core.ID;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@Entity(name = "TB_PAYMENT_SCHEDULER")
public class PaymentScheduler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @Column(nullable = false, columnDefinition = "Date")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate registratioDate;

    @Column(nullable = false, columnDefinition = "Date")
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate paymentSchedullerDate;
    @Enumerated(EnumType.STRING)
    private PaymentStatusEnum status;

}
