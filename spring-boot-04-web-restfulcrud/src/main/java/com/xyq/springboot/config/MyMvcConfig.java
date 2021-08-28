package com.xyq.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author chrisxu
 * @create 2020-06-17 14:58
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加视图控制
        registry.addViewController("qi").setViewName("404");
        //首页视图控制
        //status=500说明不存在该网页
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

//    在容器中注入写的区域信息解析器，使得区域信息解析器生效
    @Bean
    public LocaleResolver localeResolver(){
//        返回一个在MyMvcConfig.java下面写的MyLocaleResolver类的对象
        return new MyLocaleResolver();
    }
    //将拦截器配置到bean里面，添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加一个拦截器，并且指定拦截哪些请求，过滤哪些请求
        //首页和登陆请求/user/login不能被拦截
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**").excludePathPatterns
//                ("/index.html","/","/user/login","/css/**","/js/**","/img/**");


    }
}
