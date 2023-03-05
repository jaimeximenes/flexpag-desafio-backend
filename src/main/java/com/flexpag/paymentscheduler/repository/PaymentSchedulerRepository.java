package com.flexpag.paymentscheduler.repository;

import com.flexpag.paymentscheduler.model.PaymentScheduler;

import com.flexpag.paymentscheduler.model.PaymentStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PaymentSchedulerRepository extends JpaRepository<PaymentScheduler, Long> {

    Optional<PaymentStatusEnum> findStatusById(Long id);

    @Query("update TB_PAYMENT_SCHEDULER p set p.schedulerDate = :date where p.id= :id")
    void updateSchedulerDateById(@Param("id") Long id, @Param("date") LocalDateTime date);
}
