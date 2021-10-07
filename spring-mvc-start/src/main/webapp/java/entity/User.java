package entity;

import lombok.Data;

import java.io.Serializable;

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
public class User implements Serializable {
    public String uname;
    public String age;

}
