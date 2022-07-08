package com.CodeGym.service;

import java.sql.*;

public class DBHandler<T> {
    final String DB_URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
    final String jdbc_USERNAME = "viet";
    final String jdbc_PASSWORD = "root";

    private static DBHandler instance;

    private DBHandler() {

    }

    public static DBHandler getInstance() {
        if (instance == null) {
            instance = new DBHandler();
            return instance;
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, jdbc_USERNAME, jdbc_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public boolean insertData(String table, T objectToInsert, String inserstColumns) {
        Connection connection = getConnection();
        String sql = "insert into " + table + "(" + inserstColumns + ") values(" + objectToInsert.toString() + ")";
        System.out.println(sql);
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            statement.execute(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            String messenger = new RuntimeException(e).toString();
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
//
//    private String userColumns = "email, password";
//    private String bookColumns = "title, author, position, image, description";
//    private String roleColumns = "name";
//    private String authorColumns = "name, Dob";
//    private String positionColumns = "name, max_position, current_unit, description";
//
//    private String getInsertColumns(String table) {
//        String columns = "";
//        switch (table) {
//            case "user":
//                columns = userColumns;
//                break;
//            case "book":
//                columns = bookColumns;
//                break;
//            case "role":
//                columns = roleColumns;
//                break;
//            case "author":
//                columns = authorColumns;
//                break;
//            case "position":
//                columns = positionColumns;
//                break;
//        }
//        return columns;
//    }

    public ResultSet findAllByCondition(String table, String condition) {
        Connection connection = getConnection();
        String sql = "select  * from " + table +" "+ condition;
        System.out.println(sql);
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public ResultSet findById(String table, String condition){
//
//    }
}
