package com.xyq.factory;

import com.xyq.dao.UserDao;
import com.xyq.dao.impl.UserDaoImpl;

/**
 * @author chrisxu
 * @create 2021-09-14 17:48
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
public class StaticFactory {
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
