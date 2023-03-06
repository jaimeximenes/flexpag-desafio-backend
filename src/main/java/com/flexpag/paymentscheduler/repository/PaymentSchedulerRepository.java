package com.flexpag.paymentscheduler.repository;

import com.flexpag.paymentscheduler.model.PaymentScheduler;

import com.flexpag.paymentscheduler.model.PaymentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaymentSchedulerRepository extends JpaRepository<PaymentScheduler, Long> {

    @Query("SELECT p.status FROM TB_PAYMENT_SCHEDULER p where p.id = :id")
    Optional<PaymentStatusEnum> findStatusById(Long id);

}
