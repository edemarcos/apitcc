package com.edemarcos.tcc.app.supplier.entrypoint.controller;

import com.edemarcos.tcc.app.category.entrypoint.controller.request.CategoryRequest;
import com.edemarcos.tcc.app.category.entrypoint.controller.response.CategoryResponse;
import com.edemarcos.tcc.app.supplier.entrypoint.controller.mapper.SupplierMapperController;
import com.edemarcos.tcc.app.supplier.entrypoint.controller.request.SupplierRequest;
import com.edemarcos.tcc.app.supplier.entrypoint.controller.response.SupplierResponse;
import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import com.edemarcos.tcc.domain.supplier.usecases.FindAllSupplierUseCase;
import com.edemarcos.tcc.domain.supplier.usecases.FindByIdSupplierUseCase;
import com.edemarcos.tcc.domain.supplier.usecases.InsertSupplierUseCase;
import com.edemarcos.tcc.domain.supplier.usecases.UpdateSupplierUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {

    @Autowired
    private InsertSupplierUseCase insertSupplierUseCase;
    @Autowired
    private UpdateSupplierUseCase updateSupplierUseCase;
    @Autowired
    private FindByIdSupplierUseCase findByIdSupplierUseCase;
    @Autowired
    private FindAllSupplierUseCase findAllSupplierUseCase;
    @Autowired
    private SupplierMapperController supplierMapperController;

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody SupplierRequest supplierRequest ) {
        var supplier = supplierMapperController.toSupplier(supplierRequest) ;
        Supplier createdSupplier = insertSupplierUseCase.execute(supplier);
        SupplierResponse supplierResponse = supplierMapperController.toSupplierResponse(createdSupplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse>  update(@PathVariable final Long id, @RequestBody SupplierRequest supplierRequest){
        var supplier = supplierMapperController.toSupplier(supplierRequest);
        updateSupplierUseCase.execute(supplier, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> findById(@PathVariable final Long id){
        var supplier = findByIdSupplierUseCase.execute(id);
        var supplierResponse = supplierMapperController.toSupplierResponse(supplier);
        return ResponseEntity.ok().body(supplierResponse);
    }
    @GetMapping
    public ResponseEntity<List<SupplierResponse>> findAll(){
        var supplierList = findAllSupplierUseCase.execute();
        var supplierResponseList = supplierMapperController.toSupplierResponseList(supplierList) ;
        return ResponseEntity.ok().body(supplierResponseList);
    }
}
