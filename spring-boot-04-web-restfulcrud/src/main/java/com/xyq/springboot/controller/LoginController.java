package com.xyq.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author chrisxu
 * @create 2020-06-17 22:26
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
@Controller
public class LoginController {
    @RequestMapping("user/login")
//    要把@ResponseBody注释掉，不然无法跳到templates下的视图
//    @ResponseBody
//    传入model是为了反馈登录失败信息、传入session是为了实现登陆拦截功能
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
//      具体的业务
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //sessionName是名称，object是你要保存的对象
            session.setAttribute("loginUser",username);
//            重定向
            return "redirect:/main.html";
        }else{
//          告诉用户登陆失败
            model.addAttribute("msg","用户名或密码错误！");
            return "login";
        }

    }
}
