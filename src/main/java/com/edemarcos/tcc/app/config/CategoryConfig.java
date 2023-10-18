package com.edemarcos.tcc.app.config;

import com.edemarcos.tcc.app.category.entrypoint.controller.mapper.CategoryMapperController;
import com.edemarcos.tcc.domain.category.dataproviders.CategoryDataProvider;
import com.edemarcos.tcc.domain.category.usecases.FindByIdCategoryUseCase;
import com.edemarcos.tcc.domain.category.usecasesimpl.FindAllCategoryUseCaseImpl;
import com.edemarcos.tcc.domain.category.usecasesimpl.FindByIdCategoryUseCaseImpl;
import com.edemarcos.tcc.domain.category.usecasesimpl.InsertCategoryUseCaseImpl;
import com.edemarcos.tcc.domain.category.usecasesimpl.UpdateCategoryUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {
    @Bean
    public InsertCategoryUseCaseImpl insertCategoryUseCase(
            CategoryDataProvider categoryDataProvider
    ){
        return new InsertCategoryUseCaseImpl(categoryDataProvider);
    }
    @Bean
    public UpdateCategoryUseCaseImpl updateCategoryUseCase(
            CategoryDataProvider categoryDataProvider,
            FindByIdCategoryUseCase findByIdCategoryUseCase
    ){
        return new UpdateCategoryUseCaseImpl(categoryDataProvider, findByIdCategoryUseCase);
    }
    @Bean
    public FindByIdCategoryUseCaseImpl findByIdCategoryUseCase(
            CategoryDataProvider categoryDataProvider
    ){
        return new FindByIdCategoryUseCaseImpl(categoryDataProvider);
    }
    @Bean
    public FindAllCategoryUseCaseImpl findAllCategoryUseCase(
            CategoryDataProvider categoryDataProvider
    ){
        return new FindAllCategoryUseCaseImpl(categoryDataProvider);
    }

}
