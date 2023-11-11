package com.edemarcos.tcc.app.order.dataprovider.repository;

import com.edemarcos.tcc.app.order.dataprovider.model.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemModel, Long> {

    //@Query("SELECT oi FROM OrderItemModel oi WHERE oi.order.id = :orderId")
//    List<OrderItemModel> findByOrderId(@Param("orderId") Long orderId);

    List<OrderItemModel> findByOrderId(Long orderId);

}
