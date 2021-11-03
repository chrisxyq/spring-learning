package com.example.springboottransaction;

import com.example.springboottransaction.entity.User;
import com.example.springboottransaction.service.UserService;
import com.example.springboottransaction.util.SpringUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootTest
@EnableAspectJAutoProxy(exposeProxy = true)
class SpringbootTransactionApplicationTests {
    /**
     * 事务成功
     */
    @Test
    void test() {
        UserService userService = SpringUtil.getBean(UserService.class);
        User user = new User("1", null, "18");
        userService.saveUser(user);
    }

    /**
     * 默认情况下，Spring事务只对RuntimeException或者Error类型异常（错误）进行回滚，
     * 检查异常（通常为业务类异常）不会导致事务回滚
     * 事务失败
     * @throws Exception
     */
    @Test
    void test1() throws Exception {
        UserService userService = SpringUtil.getBean(UserService.class);
        User user = new User("1", null, "18");
        userService.saveUser1(user);
    }

    /**
     * 手动在@Transactional注解上声明回滚的异常类型（方法抛出该异常及其所有子类型异常都能触发事务回滚）
     * 事务成功
     * @throws Exception
     */
    @Test
    void test2() throws Exception {
        UserService userService = SpringUtil.getBean(UserService.class);
        User user = new User("1", null, "18");
        userService.saveUser2(user);
    }

    /**
     * 方法内手动抛出的检查异常类型改为RuntimeException子类型
     * 事务成功
     */
    @Test
    void test3()  {
        UserService userService = SpringUtil.getBean(UserService.class);
        User user = new User("1", null, "18");
        userService.saveUser3(user);
    }
    /**
     * 非事务方法直接通过this调用本类事务方法
     * 事务失败
     */
    @Test
    void test4()  {
        UserService userService = SpringUtil.getBean(UserService.class);
        User user = new User("2", null, "18");
        userService.saveUser4(user);
    }
    /**
     * 要让事务生效主要有如下两种解决方式（原理都是使用代理对象来替代this
     * 从IOC容器中获取UserService Bean，然后调用它的saveUser方法
     * 事务成功
     */
    @Test
    void test5()  {
        UserService userService = SpringUtil.getBean(UserService.class);
        User user = new User("4", null, "18");
        userService.saveUser5(user);
    }
    /**
     * 要让事务生效主要有如下两种解决方式（原理都是使用代理对象来替代this
     * 从AOP上下文中取出当前代理对象
     * 然后在SpringBoot入口类中通过注解@EnableAspectJAutoProxy(exposeProxy = true)
     * 将当前代理对象暴露到AOP上下文中（通过AopContext的ThreadLocal实现）
     * 事务成功
     */
    @Test
    void test6()  {
        UserService userService = SpringUtil.getBean(UserService.class);
        User user = new User("5", null, "18");
        userService.saveUser6(user);
    }

}
