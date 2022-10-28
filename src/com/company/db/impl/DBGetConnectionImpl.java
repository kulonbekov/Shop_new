package com.company.db.impl;

import com.company.db.DBGetConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBGetConnectionImpl implements DBGetConnection {
    @Override
    public PreparedStatement getConnection(String sql) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:D:\\IdeaProjects\\SQL\\shop.db");
            PreparedStatement ps=connection.prepareStatement(sql);
            return ps;

        } catch (SQLException throwables) {
            throw new RuntimeException("Ошибка при подключении к базе данных");
        }
    }
}
