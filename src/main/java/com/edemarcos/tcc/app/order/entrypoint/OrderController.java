package com.edemarcos.tcc.app.order.entrypoint;

import com.edemarcos.tcc.app.category.entrypoint.controller.response.CategoryResponse;
import com.edemarcos.tcc.app.order.entrypoint.mapper.OrderMapperController;
import com.edemarcos.tcc.app.order.entrypoint.request.OrderRequest;
import com.edemarcos.tcc.app.order.entrypoint.request.OrderRequestUpdate;
import com.edemarcos.tcc.app.order.entrypoint.response.OrderResponse;
import com.edemarcos.tcc.domain.order.usecases.FindAllOrderUseCase;
import com.edemarcos.tcc.domain.order.usecases.FindByIdOrderUseCase;
import com.edemarcos.tcc.domain.order.usecases.InsertOrderUseCase;
import com.edemarcos.tcc.domain.order.usecases.UpdateOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@Tag(name = "Order", description = "Order API")
public class OrderController {

    private OrderMapperController orderMapperController;

    private InsertOrderUseCase insertOrderUseCase;

    private FindByIdOrderUseCase findByIdOrderUseCase;

    private FindAllOrderUseCase findAllOrderUseCase;

    private UpdateOrderUseCase updateOrderUseCase;

    public OrderController(OrderMapperController orderMapperController,
                           InsertOrderUseCase insertOrderUseCase,
                           FindByIdOrderUseCase findByIdOrderUseCase,
                           FindAllOrderUseCase findAllOrderUseCase,
                           UpdateOrderUseCase updateOrderUseCase) {
        this.orderMapperController = orderMapperController;
        this.insertOrderUseCase = insertOrderUseCase;
        this.findByIdOrderUseCase = findByIdOrderUseCase;
        this.findAllOrderUseCase = findAllOrderUseCase;
        this.updateOrderUseCase = updateOrderUseCase;
    }

    @Operation(summary = "Inserir novo pedido", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido criado"),
            @ApiResponse(responseCode = "500", description = "Falha ao inserir pedido: Existem campos vazios"),
    })
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody OrderRequest orderRequest) {
        var order = orderMapperController.toOrder(orderRequest);
        var createOrder = insertOrderUseCase.execute(order);
        var orderResponse = orderMapperController.toOrderResponse(createOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(orderResponse);
    }

    @Operation(summary = "Buscar pedido por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido encontrado"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
        var order = findByIdOrderUseCase.execute(id);
        var orderResponse = orderMapperController.toOrderResponse(order);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

    @Operation(summary = "Listar todos os pedidos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de pedidos retornada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll() {
        var orderList = findAllOrderUseCase.execute();
        var orderResponseList = orderMapperController.toOrderResponseList(orderList);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseList);
    }

    @Operation(summary = "Atualizar pedido existente", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pedido atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Pedido não encontrado"),
            @ApiResponse(responseCode = "500", description = "Falha ao atualizar pedido: Existem campos vazios"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody OrderRequestUpdate orderRequestUpdate) {
        var order = orderMapperController.toOrderUpdate(orderRequestUpdate);
        order.setId(id);
        updateOrderUseCase.execute(order, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}