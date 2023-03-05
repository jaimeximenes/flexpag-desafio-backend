package com.flexpag.paymentscheduler.model;

import lombok.Data;
import org.yaml.snakeyaml.events.Event;

import javax.persistence.*;

@Data
@Entity(name = "TB_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String name;
    @Column(nullable = false, unique = true, length = 60)
    private String email;
    @ManyToOne
    @JoinColumn(name = "PAYMENT_SCHEDULER_ID")
    private PaymentScheduler paymentScheduler;

}
