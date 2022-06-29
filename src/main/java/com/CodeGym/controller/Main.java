package com.CodeGym.controller;

import com.CodeGym.service.DBHandler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String USER_TABLE = "";
    private static final String BOOK_TABLE = "book";
    private static final String AUTHOR_TABLE = "author";

    public static void main(String[] args) {
//        DBHandler dbHandler = DBHandler.getInstance();
//
//        Connection connection = dbHandler.getConnection();
//        Statement statement;
//        try {
//            statement = connection.createStatement();
//            String sql = "insert into " + AUTHOR_TABLE + "(name,Dob) values('nana','2022-12-12')";
//            int stm = statement.executeUpdate(sql);
//
//            if(stm<1)
//                System.out.println("can not insert!");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("fn");

    }
}
