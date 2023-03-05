package com.flexpag.paymentscheduler.repository;

import com.flexpag.paymentscheduler.model.PaymentScheduler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

public interface PaymentSchedulerRepository extends JpaRepository<PaymentScheduler, Long> {
    Page<PaymentScheduler> findAll(Pageable pageable);
}
