package com.example.mybatisplusdemo;

import com.example.mybatisplusdemo.entity.Usertbl;
import com.example.mybatisplusdemo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        List<Usertbl> users = userMapper.selectList(null);
        //forEach参数是consumer类型的
        users.forEach(System.out::println);
    }

    /**
     * 默认主键生成策略为雪花算法
     * 即使表配置了自增
     */
    @Test
    void test() {
        Usertbl user = new Usertbl();
        user.setAge(1);
        user.setEmail("183@qq.com");
        user.setName("zhangsan");
        userMapper.insert(user);
    }
    /**
     */
    @Test
    void test1() {

    }


}
