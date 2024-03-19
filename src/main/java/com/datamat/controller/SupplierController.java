package com.datamat.controller;

import com.datamat.persistence.entities.Supplier;
import com.datamat.service.SupplierService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping
    public Supplier createSupplier(@RequestBody SupplierCreationRequest creationRequest) {
        return supplierService.createSupplier(creationRequest);
    }

    @PutMapping("/{id}")
    public Supplier updateSupplier(@PathVariable("id") int id, @RequestBody SupplierUpdateRequest updateRequest) {
        return supplierService.updateSupplier(id, updateRequest);
    }
}
