package com.edemarcos.tcc.app.order.dataprovider.repository;

import com.edemarcos.tcc.app.order.dataprovider.model.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemModel, Long> {
    List<OrderItemModel> findByOrderId(Long orderId);
}
