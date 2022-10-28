package com.company.db;

import com.company.models.Product;

import java.util.List;

public interface DBProduct {

    void insertProduct(Product product);

    List<Product> selectAllProduct();

    void updateProduct(Long id, String name, int price);

    void deleteProduct(Long id);


}
