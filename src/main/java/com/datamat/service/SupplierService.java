package com.datamat.service;

import com.datamat.controller.SupplierCreationRequest;
import com.datamat.controller.SupplierUpdateRequest;
import com.datamat.exception.ElementNotFoundException;
import com.datamat.persistence.entities.Supplier;
import com.datamat.persistence.repository.SupplierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Transactional
    public Supplier createSupplier(SupplierCreationRequest creationRequest) {
        Supplier supplier = new Supplier();
        supplier.setName(creationRequest.name());
        return this.supplierRepository.save(supplier);
    }

    @Transactional
    public Supplier updateSupplier(int id, SupplierUpdateRequest updateRequest) {
        Supplier supplier = this.supplierRepository.findById(id).orElseThrow(() -> new ElementNotFoundException("Supplier not found"));

        supplier.setName(updateRequest.name());

        return supplier;
    }
}
