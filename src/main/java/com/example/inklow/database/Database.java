package com.example.inklow.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    public Database() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/app", "postgres", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
