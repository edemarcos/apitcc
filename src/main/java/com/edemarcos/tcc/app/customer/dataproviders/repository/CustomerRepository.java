package com.edemarcos.tcc.app.customer.dataproviders.repository;

import com.edemarcos.tcc.app.customer.dataproviders.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {
}
