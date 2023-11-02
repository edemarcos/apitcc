package com.edemarcos.tcc.app.order.entrypoint;

import com.edemarcos.tcc.app.order.entrypoint.mapper.OrderMapperController;
import com.edemarcos.tcc.app.order.entrypoint.request.OrderRequest;
import com.edemarcos.tcc.domain.order.usecases.InsertOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private OrderMapperController orderMapperController;

    private InsertOrderUseCase insertOrderUseCase;

    public OrderController(OrderMapperController orderMapperController, InsertOrderUseCase insertOrderUseCase) {
        this.orderMapperController = orderMapperController;
        this.insertOrderUseCase = insertOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody OrderRequest orderRequest) {
        var order = orderMapperController.toOrder(orderRequest);
        var createOrder = insertOrderUseCase.execute(order);
        var orderResponse = orderMapperController.toOrderResponse(createOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);

    }
}
