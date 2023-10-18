package com.edemarcos.tcc.app.customer.entrypoint.controller;

import com.edemarcos.tcc.app.customer.dataproviders.mapper.CustomerMapper;
import com.edemarcos.tcc.app.customer.entrypoint.controller.mapper.CustomerMapperController;
import com.edemarcos.tcc.app.customer.entrypoint.controller.request.CustomerRequest;
import com.edemarcos.tcc.app.customer.entrypoint.controller.response.CustomerResponse;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import com.edemarcos.tcc.domain.customer.usecases.FindAllCustomerUseCase;
import com.edemarcos.tcc.domain.customer.usecases.FindByIdCustomerUseCase;
import com.edemarcos.tcc.domain.customer.usecases.InsertCustomerUseCase;
import com.edemarcos.tcc.domain.customer.usecases.UpdateCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
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

    @PostMapping
    public ResponseEntity<CustomerResponse> insert(@RequestBody CustomerRequest customerRequest){
        var customer = customerMapperController.toCustomer(customerRequest) ;
        Customer createdCustomer = insertCustomerUseCase.execute(customer);
        CustomerResponse customerResponse = customerMapperController.toCustomerResponse(createdCustomer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable final Long id, @RequestBody CustomerRequest customerRequest){
        var customer = customerMapperController.toCustomer(customerRequest);
        updateCustomerUseCase.execute(customer, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final Long id){
        var customer = findByIdCustomerUseCase.findById(id);
        var customerResponse = customerMapperController.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll(){
        var customerList = findAllCustomerUseCase.execute();
        var customerResponseList = customerMapperController.toCustomerResponseList(customerList) ;
        return ResponseEntity.ok().body(customerResponseList);
    }
}
