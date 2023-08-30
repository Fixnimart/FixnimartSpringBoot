package com.fixnimart.repository;

import com.fixnimart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAll() {
        String SQL = "SELECT * FROM Products";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public int create(Product product) {
        String SQL = "INSERT INTO Products(ProductImage,Name,Description,Price,Stock, BarCode) VALUES(?,?,?,?,?,?)";
        return jdbcTemplate.update(SQL, new Object[]{
            product.getProductImage(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock(),
            product.getBarCode()
        });

    }

    @Override
    public int update(Product product) {
        String SQL = "UPDATE Products SET ProductImage =?, Name = ?, Description=?, Price=?, Stock=?, BarCode=? WHERE productId = ?";
        return jdbcTemplate.update(SQL, new Object[]{
            product.getProductImage(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStock(),
            product.getBarCode(),
            product.getProductId()
        });
    }

    @Override
    public int delete(UUID id) {
        String SQL = "DELETE FROM Products WHERE ProductId=?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }

    @Override
    public Product getById(UUID id) {
        String SQL = "SELECT * FROM Products WHERE ProductId = ?";
        return jdbcTemplate.queryForObject(SQL, new Object[]{id}, BeanPropertyRowMapper.newInstance(Product.class));
    }

}
