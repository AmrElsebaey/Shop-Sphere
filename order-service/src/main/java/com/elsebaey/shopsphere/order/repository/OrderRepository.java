package com.elsebaey.shopsphere.order.repository;

import com.elsebaey.shopsphere.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
