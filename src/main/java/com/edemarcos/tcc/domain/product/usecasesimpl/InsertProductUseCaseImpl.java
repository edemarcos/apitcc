package com.edemarcos.tcc.domain.product.usecasesimpl;

import com.edemarcos.tcc.domain.category.entities.Category;
import com.edemarcos.tcc.domain.category.usecases.FindByIdCategoryUseCase;
import com.edemarcos.tcc.domain.product.dataproviders.ProductDataProvider;
import com.edemarcos.tcc.domain.product.entities.Product;
import com.edemarcos.tcc.domain.product.enums.ProductStatus;
import com.edemarcos.tcc.domain.product.exceptions.ProductInsertionException;
import com.edemarcos.tcc.domain.product.usecases.InsertProductUseCase;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import com.edemarcos.tcc.domain.supplier.usecases.FindByIdSupplierUseCase;

import java.lang.reflect.Field;
import java.util.List;


public class InsertProductUseCaseImpl implements InsertProductUseCase {
    private ProductDataProvider productDataProvider;
    private FindByIdCategoryUseCase findByIdCategoryUse;
    private FindByIdSupplierUseCase findSupplierByIdUseCase;
    public InsertProductUseCaseImpl(ProductDataProvider productDataProvider, FindByIdCategoryUseCase findByIdCategoryUse, FindByIdSupplierUseCase findSupplierByIdUseCase) {
        this.productDataProvider = productDataProvider;
        this.findByIdCategoryUse = findByIdCategoryUse;
        this.findSupplierByIdUseCase = findSupplierByIdUseCase;
    }
    @Override
    public Product execute(Product product) {
        Category categoryOfInsert = findByIdCategoryUse.execute(product.getCategory().getId());
        Supplier supplierOfInsert = findSupplierByIdUseCase.execute(product.getSupplier().getId());

        if (categoryOfInsert == null) {
            throw new ProductInsertionException("A categoria informada não existe.");
        }
        if (supplierOfInsert == null) {
            throw new ProductInsertionException("O fornecedor informado não existe.");
        }

        if (product.getStatus() == null) {
            product.setStatus(ProductStatus.ACTIVE);
        }
        Field[] fields = Product.class.getDeclaredFields();
        List<String> fieldsToCheck = List.of("name", "description", "unitPrice", "initialQuantity", "registrationDate", "weight", "dimensions");

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (fieldsToCheck.contains(field.getName()) && field.get(product) == null) {
                    throw new ProductInsertionException("O campo " + field.getName() + " não pode ser nulo.");
                }
                field.set(product, field.get(product));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return productDataProvider.insert(product);
    }
}
