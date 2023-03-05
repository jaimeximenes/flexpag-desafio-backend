package com.flexpag.paymentscheduler.repository;

import com.flexpag.paymentscheduler.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

public interface UserRepository extends JpaRepository<User, Long> {
}
