package com.xyq.service;

import com.xyq.dao.UserDao;

/**
 * @author chrisxu
 * @create 2021-09-14 18:06
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
public class UserService {
    private UserDao userDao;

    //有参构造方法注入
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    //set方法注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
