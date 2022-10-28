package com.company.db.impl;

import com.company.db.DBGetConnection;
import com.company.db.DBProduct;
import com.company.models.Product;
import com.company.models.Shop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBProductImpl implements DBProduct {

    DBGetConnection dbGetConnection = new DBGetConnectionImpl();
    @Override
    public void insertProduct(Product product) {
        try {
            PreparedStatement ps = dbGetConnection.getConnection("Insert into tb_product(name,price) Values (?,?)");
            ps.setString(1, product.getName());
            ps.setInt(2, product.getPrice());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throw  new RuntimeException("Произошла ошибка при сохранении преподавателя");
        }
    }

    @Override
    public List<Product> selectAllProduct() {

        try {
            PreparedStatement ps = dbGetConnection.getConnection("select * from tb_product");
            ResultSet resultSet = ps.executeQuery();
            List<Product> products=new ArrayList<>();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getInt("price"));
                products.add(product);
            }
            return products;

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка");
        }
    }

    @Override
    public void updateProduct(Long id, String name, int price) {
        try {
            PreparedStatement ps = dbGetConnection.getConnection("Update tb_product set name =?, price = ? where id =?");
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, Math.toIntExact(id));
            ps.executeUpdate();

        }  catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при изменения данных преподавателя");
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            PreparedStatement ps = dbGetConnection.getConnection("Delete from tb_product where id = ?");
            ps.setInt(1, Math.toIntExact(id));
            int result = ps.executeUpdate();
            System.out.println(result);

            if(result==1){
                System.out.println("Объект успешно удален");
            }else if(result==0){
                System.out.println(" Запрос успешно выполнен. Заняло 0мс, 0 строк изменено");
            }

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при удалении ");
        }
    }
}
