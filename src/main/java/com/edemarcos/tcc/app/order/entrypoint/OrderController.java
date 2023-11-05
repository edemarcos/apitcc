package com.edemarcos.tcc.app.order.entrypoint;

import com.edemarcos.tcc.app.category.entrypoint.controller.response.CategoryResponse;
import com.edemarcos.tcc.app.order.entrypoint.mapper.OrderMapperController;
import com.edemarcos.tcc.app.order.entrypoint.request.OrderRequest;
import com.edemarcos.tcc.app.order.entrypoint.response.OrderResponse;
import com.edemarcos.tcc.domain.order.usecases.FindByIdOrderUseCase;
import com.edemarcos.tcc.domain.order.usecases.InsertOrderUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private OrderMapperController orderMapperController;

    private InsertOrderUseCase insertOrderUseCase;

    private FindByIdOrderUseCase findByIdOrderUseCase;

    public OrderController(OrderMapperController orderMapperController, InsertOrderUseCase insertOrderUseCase, FindByIdOrderUseCase findByIdOrderUseCase) {
        this.orderMapperController = orderMapperController;
        this.insertOrderUseCase = insertOrderUseCase;
        this.findByIdOrderUseCase = findByIdOrderUseCase;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody OrderRequest orderRequest) {
        var order = orderMapperController.toOrder(orderRequest);
        var createOrder = insertOrderUseCase.execute(order);
        var orderResponse = orderMapperController.toOrderResponse(createOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);

    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        var order = findByIdOrderUseCase.execute(id);
        var orderResponse = orderMapperController.toOrderResponse(order);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

}
