package com.example.springboottransaction;

import com.example.springboottransaction.entity.User;
import com.example.springboottransaction.service.UserService;
import com.example.springboottransaction.util.SpringUtil;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 在SpringBoot入口类中通过注解@EnableAspectJAutoProxy(exposeProxy = true)
 * 将当前代理对象暴露到AOP上下文中（通过AopContext的ThreadLocal实现）
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
public class SpringbootTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTransactionApplication.class, args);
    }

}
