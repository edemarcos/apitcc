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
@RequestMapping("/api/v1/supplier")
@Tag(name = "Supplier", description = "Supplier API")
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

    @Operation(summary = "Inserir novo fornecedor", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Fornecedor criado"),
            @ApiResponse(responseCode = "500", description = "Falha ao inserir fornecedor: Existem campos vazios"),
    })
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody SupplierRequest supplierRequest) {
        var supplier = supplierMapperController.toSupplier(supplierRequest);
        Supplier createdSupplier = insertSupplierUseCase.execute(supplier);
        SupplierResponse supplierResponse = supplierMapperController.toSupplierResponse(createdSupplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierResponse);
    }

    @Operation(summary = "Atualizar fornecedor existente", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Fornecedor atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Fornecedor não encontrado"),
            @ApiResponse(responseCode = "500", description = "Falha ao atualizar fornecedor: Existem campos vazios"),
    })
    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse> update(@PathVariable final Long id, @RequestBody SupplierRequest supplierRequest) {
        var supplier = supplierMapperController.toSupplier(supplierRequest);
        updateSupplierUseCase.execute(supplier, id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar fornecedor por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Fornecedor encontrado"),
            @ApiResponse(responseCode = "404", description = "Fornecedor não encontrado"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> findById(@PathVariable final Long id) {
        var supplier = findByIdSupplierUseCase.execute(id);
        var supplierResponse = supplierMapperController.toSupplierResponse(supplier);
        return ResponseEntity.ok().body(supplierResponse);
    }

    @Operation(summary = "Listar todos os fornecedores", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de fornecedores retornada com sucesso"),
    })
    @GetMapping
    public ResponseEntity<List<SupplierResponse>> findAll() {
        var supplierList = findAllSupplierUseCase.execute();
        var supplierResponseList = supplierMapperController.toSupplierResponseList(supplierList);
        return ResponseEntity.ok().body(supplierResponseList);
    }
}