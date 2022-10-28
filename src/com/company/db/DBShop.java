package com.company.db;

import com.company.models.Shop;

import java.util.List;

public interface DBShop {

    void insertShop(Shop shop);

    List<Shop> selectAll();

    void updateShop (Long id, String name);

    void deleteShop(Long id);


}
