package com.edemarcos.tcc.app.customer.entrypoint.controller;

import com.edemarcos.tcc.app.customer.entrypoint.controller.mapper.CustomerMapperController;
import com.edemarcos.tcc.app.customer.entrypoint.controller.request.CustomerRequest;
import com.edemarcos.tcc.app.customer.entrypoint.controller.response.CustomerResponse;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.usecases.FindAllCustomerUseCase;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.customer.usecases.InsertCustomerUseCase;
import com.edemarcos.tcc.domain.customer.usecases.UpdateCustomerUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@Tag(name = "Customer", description = "Customer API")
public class CustomerController {
    @Autowired
    InsertCustomerUseCase insertCustomerUseCase;
    @Autowired
    UpdateCustomerUseCase updateCustomerUseCase;
    @Autowired
    FindByIdCustomerUseCase findByIdCustomerUseCase;

    @Autowired
    FindAllCustomerUseCase findAllCustomerUseCase;

    @Autowired
    private CustomerMapperController customerMapperController;

    @Operation(summary = "Inserir novo cliente", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cliente criado"),
            @ApiResponse(responseCode = "500", description = "Falha ao inserir cliente: Existem campos vazios"),
    })
    @PostMapping
    public ResponseEntity<CustomerResponse> insert(@RequestBody CustomerRequest customerRequest) {
        var customer = customerMapperController.toCustomer(customerRequest);
        Customer createdCustomer = insertCustomerUseCase.execute(customer);
        CustomerResponse customerResponse = customerMapperController.toCustomerResponse(createdCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
    }

    @Operation(summary = "Atualizar cliente existente", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Cliente atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
            @ApiResponse(responseCode = "500", description = "Falha ao atualizar cliente: Existem campos vazios"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable final Long id, @RequestBody CustomerRequest customerRequest) {
        var customer = customerMapperController.toCustomer(customerRequest);
        updateCustomerUseCase.execute(customer, id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar cliente por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente encontrado"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final Long id) {
        var customer = findByIdCustomerUseCase.execute(id);
        var customerResponse = customerMapperController.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @Operation(summary = "Listar todos os clientes", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes retornada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        var customerList = findAllCustomerUseCase.execute();
        var customerResponseList = customerMapperController.toCustomerResponseList(customerList);
        return ResponseEntity.ok().body(customerResponseList);
    }
}
