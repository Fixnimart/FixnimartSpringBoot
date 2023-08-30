package com.fixnimart.controller;

import com.fixnimart.model.Product;
import com.fixnimart.model.ServiceResponse;
import com.fixnimart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private IProductService _productService;

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = _productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable UUID id) {
        Product product = _productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResponse> create(@RequestBody Product product) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = _productService.create(product);
        if (result == 1) {
            serviceResponse.setMessage("Successful creation");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Product product) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = _productService.update(product);
        if (result == 1) {
            serviceResponse.setMessage("Successful update");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> update(@PathVariable UUID id) {
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = _productService.delete(id);
        if (result == 1) {
            serviceResponse.setMessage("Successful delete");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
