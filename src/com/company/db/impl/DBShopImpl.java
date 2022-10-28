package com.company.db.impl;

import com.company.db.DBGetConnection;
import com.company.db.DBShop;
import com.company.models.Shop;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBShopImpl implements DBShop {

    DBGetConnection dbGetConnection = new DBGetConnectionImpl();
    @Override
    public void insertShop(Shop shop) {
        try {
            PreparedStatement ps = dbGetConnection.getConnection("Insert into tb_shop(name) Values (?)");
            ps.setString(1, shop.getName());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throw  new RuntimeException("Произошла ошибка при сохранении преподавателя");
        }
    }

    @Override
    public List<Shop> selectAll() {

        try {
            PreparedStatement ps = dbGetConnection.getConnection("select * from tb_shop");
            ResultSet resultSet = ps.executeQuery();
            List<Shop> shops=new ArrayList<>();
            while (resultSet.next()){
                Shop shop = new Shop();
                shop.setId(resultSet.getLong("id"));
                shop.setName(resultSet.getString("name"));
                shops.add(shop);
            }
            return shops;

        } catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при выводе списка");
        }
    }

    @Override
    public void updateShop(Long id, String name) {
        try {
            PreparedStatement ps = dbGetConnection.getConnection("Update tb_shop set name =? where id =?");
            ps.setString(1, name);
            ps.setInt(2, Math.toIntExact(id));
            ps.executeUpdate();

        }  catch (SQLException throwables) {
            throw new RuntimeException("Произошла ошибка при изменения данных преподавателя");
        }

    }

    @Override
    public void deleteShop(Long id) {

        try {
            PreparedStatement ps = dbGetConnection.getConnection("Delete from tb_shop where id = ?");
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
