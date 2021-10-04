package com.entrevistas.transports.orderTracking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entrevistas.transports.orderTracking.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

	Optional<Order> findById(Long id);

}
