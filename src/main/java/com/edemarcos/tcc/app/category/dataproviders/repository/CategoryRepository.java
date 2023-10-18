package com.edemarcos.tcc.app.category.dataproviders.repository;

import com.edemarcos.tcc.app.category.dataproviders.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
