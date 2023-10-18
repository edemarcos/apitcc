package com.edemarcos.tcc.domain.customer.dataproviders;

import com.edemarcos.tcc.domain.customer.entities.Customer;

import java.util.List;

public interface CustomerDataProvider {
    Customer insert(Customer customer);
    void update(Customer customer);
    Customer findById(Long id);
    void delete(Long id);
    List<Customer> findAll();
}
