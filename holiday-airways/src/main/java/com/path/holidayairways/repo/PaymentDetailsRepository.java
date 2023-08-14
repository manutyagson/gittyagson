package com.path.holidayairways.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.path.holidayairways.entity.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails,Integer> {

}
