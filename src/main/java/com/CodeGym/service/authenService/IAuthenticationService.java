package com.CodeGym.service.authenService;

import com.CodeGym.service.IService;
import com.CodeGym.model.AppUser;

public interface IAuthenticationService extends IService<AppUser> {
    String login(String username, String password);
    void logout();
}
