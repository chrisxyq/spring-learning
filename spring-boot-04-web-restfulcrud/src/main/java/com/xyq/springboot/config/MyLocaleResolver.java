package com.xyq.springboot.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author chrisxu
 * @create 2020-06-17 18:18
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */

/*
可以在链接上携带区域信息
 */
public class MyLocaleResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        从request中获取参数L的值，如果这个参数有值，就用该参数
        String l = httpServletRequest.getParameter("l");
//        为区域信息l构造一个locale对象，并将该对象返回
//        将locale对象初始化为操作系统默认的
        Locale locale = Locale.getDefault();
//        用framework的stringutils工具检查l的值是否为空
        if (!StringUtils.isEmpty(l)) {
//            若不为空，则截串，使用下划线将其分割，得到string数组
            String[] split = l.split("_");
//            使用带有两个参数的构造器创建一个locale对象
//            其中split[0]是语言代码，split[1]是国家代码
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
