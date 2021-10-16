package com.example.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author chrisxu
 * @create 2021-10-16 17:46
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usertbl {
//    @TableId(type = IdType.NONE)//默认
    @TableId(type = IdType.INPUT)//自增适合使用该注解，在数据库上一个最大的id基础上加1
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
