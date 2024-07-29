package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String>{
	public OrderEntity findByUserId(String userId);

	

}
