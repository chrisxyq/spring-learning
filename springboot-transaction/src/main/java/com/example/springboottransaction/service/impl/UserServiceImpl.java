package com.example.springboottransaction.service.impl;

import com.example.springboottransaction.entity.User;
import com.example.springboottransaction.exception.ParamInvalidException;
import com.example.springboottransaction.mapper.UserMapper;
import com.example.springboottransaction.service.UserService;
import com.example.springboottransaction.util.SpringUtil;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
public class UserServiceImpl implements UserService, ApplicationContextAware {

    private final UserMapper         userMapper;
    private       ApplicationContext context;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    /**
     * 事务生效，这条数据将不会被插入到数据库中
     *
     * @param user
     */
    @Transactional
    @Override
    public void saveUser(User user) {
        userMapper.save(user);
        // 测试事务回滚
        if (!StringUtils.hasText(user.getUsername())) {
            throw new RuntimeException("username不能为空");
        }
    }

    /**
     * 事务不生效场景
     * 场景一
     * Service方法抛出的异常不是RuntimeException或者Error类型，并且@Transactional注解上没有指定回滚异常类型
     */
    @Transactional
    @Override
    public void saveUser1(User user) throws Exception {
        userMapper.save(user);
        // 测试事务回滚
        if (!StringUtils.hasText(user.getUsername())) {
            throw new Exception("username不能为空");
        }
    }

    /**
     * 事务生效
     *
     * @param user
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser2(User user) throws Exception {
        userMapper.save(user);
        // 测试事务回滚
        if (!StringUtils.hasText(user.getUsername())) {
            throw new Exception("username不能为空");
        }
    }

    /**
     * 事务生效
     *
     * @param user
     */
    @Override
    @Transactional
    public void saveUser3(User user) {
        userMapper.save(user);
        // 测试事务回滚
        if (!StringUtils.hasText(user.getUsername())) {
            throw new ParamInvalidException("username不能为空");
        }
    }

    /**
     * 非事务方法直接通过this调用本类事务方法
     * 事务失效
     *
     * @param user
     */
    @Override
    public void saveUser4(User user) {
        this.saveUser3(user);
    }

    /**
     * 事务生效
     *
     * @param user
     */
    @Override
    public void saveUser5(User user) {
        UserService userService = SpringUtil.getBean(UserService.class);
        userService.saveUser3(user);
    }

    /**
     * 事务生效
     *
     * @param user
     */
    @Override
    public void saveUser6(User user) {
        UserService userService = (UserService) AopContext.currentProxy();
        userService.saveUser3(user);
    }
}
