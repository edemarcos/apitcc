package com.edemarcos.tcc.app.order.dataprovider.repository;

import com.edemarcos.tcc.app.order.dataprovider.model.OrderModel;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Long> {

}
