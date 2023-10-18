package com.edemarcos.tcc.app.product.dataproviders.repository;

import com.edemarcos.tcc.app.product.dataproviders.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
