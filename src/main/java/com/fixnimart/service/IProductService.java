package com.fixnimart.service;

import com.fixnimart.model.Product;
import java.util.List;
import java.util.UUID;

public interface IProductService {

    public List<Product> getAll();

    public Product getById(UUID id);

    public int create(Product product);

    public int update(Product product);

    public int delete(UUID id);
}
