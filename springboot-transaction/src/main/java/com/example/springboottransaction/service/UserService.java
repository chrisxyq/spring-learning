package com.example.springboottransaction.service;

import com.example.springboottransaction.entity.User;

public interface UserService {

    void saveUser(User user);

    void saveUser1(User user) throws Exception;

    void saveUser2(User user) throws Exception;

    void saveUser3(User user);

    void saveUser4(User user);

    void saveUser5(User user);

    void saveUser6(User user);

}
