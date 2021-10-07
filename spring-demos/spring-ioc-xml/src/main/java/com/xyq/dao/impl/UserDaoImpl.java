package com.xyq.dao.impl;

import com.xyq.dao.UserDao;

/**
 * @author chrisxu
 * @create 2021-09-14 11:32
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
public class UserDaoImpl implements UserDao {
    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void save() {
        System.out.println("保存");
    }

    public UserDaoImpl() {
        System.out.println("UserDaoImpl创建");
    }
}
