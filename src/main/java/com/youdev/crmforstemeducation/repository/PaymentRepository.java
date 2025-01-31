package com.youdev.crmforstemeducation.repository;

import com.youdev.crmforstemeducation.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
