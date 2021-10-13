package entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author chrisxu
 * @create 2021-10-07 21:09
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
@Data
public class Account implements Serializable {
    public String username;
    public String password;
    public String money;
    public User user;
    public List<User> list;
    public Map<String,User> map;
    public Date birth;
}
