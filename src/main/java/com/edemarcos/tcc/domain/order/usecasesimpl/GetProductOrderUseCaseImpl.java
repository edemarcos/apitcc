package com.edemarcos.tcc.domain.order.usecasesimpl;

import com.edemarcos.tcc.domain.order.entities.OrderItem;
import com.edemarcos.tcc.domain.order.exceptions.InvalidOperationException;
import com.edemarcos.tcc.domain.order.exceptions.NoItemException;
import com.edemarcos.tcc.domain.order.usecases.GetProductOrderUseCase;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.product.usecases.FindByIdProductUseCase;
import com.edemarcos.tcc.domain.product.usecases.UpdateProductUseCase;

import java.util.List;
import java.util.stream.Collectors;

public class GetProductOrderUseCaseImpl implements GetProductOrderUseCase {

    private FindByIdProductUseCase findByIdProductUseCase;

    private UpdateProductUseCase updateProductUseCase;

    public GetProductOrderUseCaseImpl(FindByIdProductUseCase findByIdProductUseCase, UpdateProductUseCase updateProductUseCase) {
        this.findByIdProductUseCase = findByIdProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }
    @Override
    public List<OrderItem> execute(List<OrderItem> orderItems) {
        if (orderItems.isEmpty()) {
            throw new IllegalArgumentException("Não é possivel inserir produtos vazios em um pedido!");
        }
        orderItems.stream().map(orderItem -> {
            Product product = findByIdProductUseCase.execute(orderItem.getId());

            orderItem.setProduct(product);
            orderItem.setOrder(orderItem.getOrder());
            orderItem.setQuantity(orderItem.getQuantity());
            orderItem.setUnitPrice(product.getUnitPrice());
            orderItem.setTotalItem(orderItem.getQuantity() * product.getUnitPrice());

            if(product.getQuantity() == 0){
                throw new NoItemException("Produto sem estoque.");
            } else if(product.getQuantity() < orderItem.getQuantity()){
                throw new InvalidOperationException(
                        String.format("A quantidade de itens da venda (%s) " +
                                "é maior do que a quantidade disponível no estoque (%s", orderItem.getQuantity(), product.getQuantity()));
            }

            int total = product.getQuantity() - orderItem.getQuantity();
            product.setQuantity(total);
            updateProductUseCase.execute(product, product.getId());
            return orderItem;

        }).collect(Collectors.toList());

        return orderItems;
    }
}
