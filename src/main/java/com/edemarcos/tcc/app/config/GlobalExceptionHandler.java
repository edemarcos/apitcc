package com.edemarcos.tcc.app.config;

import com.edemarcos.tcc.app.config.exception.ErrorResponse;
import com.edemarcos.tcc.domain.category.exceptions.CategoryInsertionException;
import com.edemarcos.tcc.domain.category.exceptions.CategoryNotFoundException;
import com.edemarcos.tcc.domain.category.exceptions.CategoryUpdateException;
import com.edemarcos.tcc.domain.customer.exceptions.CustomerInsertionException;
import com.edemarcos.tcc.domain.customer.exceptions.CustomerNotFoundException;
import com.edemarcos.tcc.domain.customer.exceptions.CustomerUpdateException;
import com.edemarcos.tcc.domain.order.exceptions.NoItemException;
import com.edemarcos.tcc.domain.order.exceptions.OrderInsertionException;
import com.edemarcos.tcc.domain.supplier.exceptions.SupplierInsertionException;
import com.edemarcos.tcc.domain.supplier.exceptions.SupplierNotFoundException;
import com.edemarcos.tcc.domain.supplier.exceptions.SupplierUpdateException;
import com.edemarcos.tcc.domain.user.exceptions.UserAlredyExistsException;
import com.edemarcos.tcc.domain.user.exceptions.UserInsertionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CategoryUpdateException.class)
    public ResponseEntity<?> handleCategoryUpdateException(CategoryUpdateException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> handleCategoryNotFoundException(CategoryNotFoundException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(CategoryInsertionException.class)
    public ResponseEntity<?> handleCategoryInsertionException(CategoryInsertionException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR .value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body(errorResponse);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
public ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
    @ExceptionHandler(CustomerUpdateException.class)
    public ResponseEntity<?> handleCustomerUpdateException(CustomerUpdateException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(CustomerInsertionException.class)
    public ResponseEntity<?> handleCustomerInsertionException(CustomerInsertionException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR .value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body(errorResponse);
    }

    @ExceptionHandler(SupplierNotFoundException.class)
    public ResponseEntity<?> handleSupplierNotFoundException(SupplierNotFoundException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(SupplierInsertionException.class)
    public ResponseEntity<?> handleSupplierInsertionException(SupplierInsertionException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR .value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR ).body(errorResponse);
    }

    @ExceptionHandler(SupplierUpdateException.class)
    public ResponseEntity<?> handleSupplierUpdateException(SupplierUpdateException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(UserAlredyExistsException.class)
    public ResponseEntity<?> handleUserAlredyExistsException(UserAlredyExistsException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.CONFLICT.value());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }
    @ExceptionHandler(UserInsertionException.class)
    public ResponseEntity<?> handleUserInsertionException(UserInsertionException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(NoItemException.class)
    public ResponseEntity<?> handleNoItemException(NoItemException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(OrderInsertionException.class)
    public ResponseEntity<?> handleOrderInsertionException(OrderInsertionException exception) {
        var errorResponse = new ErrorResponse(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }


}
