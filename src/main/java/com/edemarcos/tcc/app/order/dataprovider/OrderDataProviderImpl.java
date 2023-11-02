package com.edemarcos.tcc.app.order.dataprovider;

import com.edemarcos.tcc.app.order.dataprovider.mapper.OrderMapper;
import com.edemarcos.tcc.app.order.dataprovider.model.OrderModel;
import com.edemarcos.tcc.app.order.dataprovider.repository.OrderRepository;
import com.edemarcos.tcc.app.product.dataproviders.model.ProductModel;
import com.edemarcos.tcc.domain.order.dataproviders.OrderDataProvider;
import com.edemarcos.tcc.domain.order.entities.Order;
import com.edemarcos.tcc.domain.order.exceptions.OrderNotFoundException;
import com.edemarcos.tcc.domain.product.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDataProviderImpl implements OrderDataProvider {

    private final OrderRepository orderRepository;

    private final OrderMapper orderMapper = new OrderMapper();

    public OrderDataProviderImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @Override
    public Order insert(Order order) {
        OrderModel orderModel = orderMapper.toOrderModel(order);

        return orderMapper.toOrder(orderRepository.save(orderModel));
    }

    @Override
    public Order findById(Long id) {
        OrderModel orderModel = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        return orderMapper.toOrder(orderModel);
    }

    @Override
    public List<Order> findAll() {
        List<OrderModel> orderModelList = orderRepository.findAll();

        return orderMapper.toOrderList(orderModelList);
    }

    @Override
    public void update(Order order) {
        OrderModel orderModel = orderMapper.toOrderModel(order);

        orderRepository.save(orderModel);
    }

    @Override
    public void delete(Long id) {

    }
}
