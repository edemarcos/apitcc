package com.edemarcos.tcc.app.customer.dataproviders;

import com.edemarcos.tcc.app.customer.dataproviders.mapper.CustomerMapper;
import com.edemarcos.tcc.app.customer.dataproviders.repository.CustomerRepository;
import com.edemarcos.tcc.domain.customer.dataproviders.CustomerDataProvider;
import com.edemarcos.tcc.domain.customer.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerDataProviderImpl implements CustomerDataProvider {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Customer insert(Customer customer) {
        var customerModel = customerMapper.toCustomerModel(customer);
        var customerSaved = customerRepository.save(customerModel);
        return customerMapper.toCustomer(customerSaved);
    }

    @Override
    public void update(Customer customer) {
        var customerModel = customerMapper.toCustomerModel(customer);
        customerRepository.save(customerModel);
    }

    @Override
    public Customer findById(Long id) {
        var customerModel = customerRepository.findById(id).get();
        return customerMapper.toCustomer(customerModel);
    }

    @Override
    public List<Customer> findAll() {
        var customerModelList = customerRepository.findAll();
        return customerMapper.toCustomerList(customerModelList);
    }

    @Override
    public void delete(Long id) {

    }
}
