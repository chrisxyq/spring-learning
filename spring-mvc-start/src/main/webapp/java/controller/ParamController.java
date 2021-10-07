package controller;

import entity.Account;
import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author chrisxu
 * @create 2021-10-07 21:15
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
@RequestMapping("/param")
@Controller
public class ParamController {
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account) {
        System.out.println("执行了");
        System.out.println(account);
        return "success";
    }
    @RequestMapping("/saveAccount2")
    public String saveAccount2(Account account) {
        System.out.println("执行了");
        System.out.println(account);
        return "success";
    }
    @RequestMapping("/saveAccount3")
    public String saveAccount3(String username, String password, String money, User user){
        System.out.println("执行了");
        System.out.println(username);
        System.out.println(password);
        System.out.println(money);
        System.out.println(user);
        return "success";
    }
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        HttpSession session = request.getSession();
        session.getServletContext()
        return "success";
    }

}
