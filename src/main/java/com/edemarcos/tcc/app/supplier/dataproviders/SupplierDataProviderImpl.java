package com.edemarcos.tcc.app.supplier.dataproviders;

import com.edemarcos.tcc.app.supplier.dataproviders.mapper.SupplierMapper;
import com.edemarcos.tcc.app.supplier.dataproviders.model.SupplierModel;
import com.edemarcos.tcc.app.supplier.dataproviders.repository.SupplierRepository;
import com.edemarcos.tcc.domain.supplier.dataproviders.SupplierDataProvider;
import com.edemarcos.tcc.domain.supplier.entities.Supplier;
import com.edemarcos.tcc.domain.supplier.exceptions.SupplierNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SupplierDataProviderImpl implements SupplierDataProvider {
    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private SupplierMapper supplierMapper;
    @Override
    public Supplier insert(Supplier supplier) {
        var supplierEntity = supplierMapper.toSupplierModel(supplier);
        var supplierSaved = supplierRepository.save(supplierEntity);
        return supplierMapper.toSupplier(supplierSaved);
    }
    @Override
    public void update(Supplier supplier) {
        var supplierEntity = supplierMapper.toSupplierModel(supplier);
        supplierRepository.save(supplierEntity);

    }
    @Override
    public Supplier findById(Long id) {
       var supplierModel = supplierRepository.findById(id).orElseThrow(
                () -> new SupplierNotFoundException(id));;
        return supplierMapper.toSupplier(supplierModel);
    }
    @Override
    public void delete(Long id) {

    }
    @Override
    public List<Supplier> findAll() {
        List<SupplierModel> supplierList = supplierRepository.findAll();
        return supplierMapper.toSupplierList(supplierList);
    }
}
