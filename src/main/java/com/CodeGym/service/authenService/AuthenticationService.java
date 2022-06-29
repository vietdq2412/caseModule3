package com.CodeGym.service.authenService;

import com.CodeGym.service.DBHandler;
import com.CodeGym.model.AppUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AuthenticationService implements IAuthenticationService{
    private final String USER_TABLE = "user";
    private DBHandler<AppUser> dbHandler = DBHandler.getInstance();

    private static AuthenticationService instance;

    private AuthenticationService() {

    }

    public static AuthenticationService getInstance() {
        if (instance == null) {
            instance = new AuthenticationService();
            return instance;
        }
        return instance;
    }
    @Override
    public Boolean create(AppUser user) {
        return dbHandler.insertData(USER_TABLE, user, user.getInsertColumns());
    }

    @Override
    public HashMap<Integer, AppUser> find(String condition) {
        return null;
    }

    @Override
    public AppUser findById(int id) {
        return null;
    }

    @Override
    public AppUser update(int id) {
        return null;
    }

    @Override
    public AppUser delete(int id) {
        return null;
    }


    @Override
    public String login(String username, String password) {
        ResultSet rs = dbHandler.findAllByCondition(USER_TABLE, "");
        try {
            while (rs.next()){
                String e = rs.getString("email");
                if (rs.getString("email").equals(username)){
                    if (rs.getString("password").equals(password)){
                        return "success";
                    }else {
                        return "invalid password";
                    }
                }
            }
            return "email not found";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void logout() {

    }
}
