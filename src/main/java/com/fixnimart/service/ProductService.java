package com.fixnimart.service;

import com.fixnimart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.fixnimart.repository.IProductRepository;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository _productRepository;

    @Override
    public List<Product> getAll() {
        List<Product> products;
        try {
            products = _productRepository.getAll();
        } catch (Exception ex) {
            throw ex;
        }
        return products;
    }

    @Override
    public int create(Product card) {
        int row;
        try {
            row = _productRepository.create(card);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Product product) {
        int row;
        try {
            row = _productRepository.update(product);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public int delete(UUID id) {
        int row;
        try {
            row = _productRepository.delete(id);
        } catch (Exception ex) {
            throw ex;
        }
        return row;
    }

    @Override
    public Product getById(UUID id) {
        Product product;
        try {
            product = _productRepository.getById(id);
        } catch (Exception ex) {
            throw ex;
        }
        return product;
    }
}
