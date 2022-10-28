package com.company;

import com.company.db.DBProduct;
import com.company.db.DBShop;
import com.company.db.impl.DBProductImpl;
import com.company.db.impl.DBShopImpl;
import com.company.models.Product;
import com.company.models.Shop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DBShop dbShop = new DBShopImpl();
        DBProduct dbProduct = new DBProductImpl();

        while(true) {
            System.out.println("Выберите таблицу из БД для изменения");
            System.out.println("Shop 1, Product 2");
            boolean flag1 = true;
            boolean flag2 = true;
            switch (sc.nextInt()) {
                case 1:
                    while (flag1) {
                        System.out.println("Какую операцию вы желаете провести?");
                        System.out.println("Добавить 1,Изменить 2, Получить 3, Удалить 4, Выход 5");
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Введите названия магазина: ");
                                dbShop.insertShop(new Shop(sc.next()));
                                break;
                            case 2:
                                System.out.println("Введите id магазина, для изменения");
                                long id = sc.nextInt();
                                System.out.println("Введите новое название");
                                String newName = sc.next();
                                dbShop.updateShop(id, newName);
                                break;
                            case 3:
                                System.out.println("Список магазинов");
                                System.out.println(dbShop.selectAll());
                                break;
                            case 4:
                                System.out.println("Введите id магазина для удаления");
                                dbShop.deleteShop(sc.nextLong());
                                break;
                            case 5:
                                flag1 = false;
                                break;
                        }
                    }
                case 2:
                    while (flag2) {
                        System.out.println("Какую операцию вы желаете провести?");
                        System.out.println("Добавить 1,Изменить 2, Получить 3, Удалить 4, Выход 5");
                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Введите названия продукта: ");
                                String name = sc.next();
                                System.out.println("Введите стоимость продукта: ");
                                int price = sc.nextInt();
                                dbProduct.insertProduct(new Product(name, price));
                                break;
                            case 2:
                                System.out.println("Введите id продукта, для изменения");
                                long id = sc.nextInt();
                                System.out.println("Введите новое название продукты");
                                name = sc.next();
                                System.out.println("Введите стоимость продукта");
                                price = sc.nextInt();
                                dbProduct.updateProduct(id, name, price);
                                break;
                            case 3:
                                System.out.println("Список продуктов");
                                System.out.println(dbProduct.selectAllProduct());
                                break;
                            case 4:
                                System.out.println("Введите id продукта для удаления");
                                dbProduct.deleteProduct(sc.nextLong());
                                break;
                            case 5:
                                flag2 = false;
                                break;
                        }
                    }
            }
        }
    }
}