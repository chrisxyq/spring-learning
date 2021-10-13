package controller;

import entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chrisxu
 * @create 2021-10-10 20:55
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @RequestMapping("/testString")
    public String testString(Model model) {
        //把user对象存储到request中，底层存储到request域对象
        model.addAttribute("user", new User("uname", "18"));
        return "responseSuccess";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.getRequestDispatcher("WEB-INF/pages/success.jsp").forward(request, response);
//        response.sendRedirect(request.getContextPath() + "/index.jsp");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("response.getWriter()");
        return;
    }

    @RequestMapping("/testForwardAndRedirect")
    public String testForwardAndRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        return "forward:/WEB-INF/pages/success.jsp";
//        return "redirect:/WEB-INF/pages/success.jsp";
        return "redirect:index.jsp";
    }
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //相当于model.addAttribute("user", new User("uname", "18"));
        //把user对象存储到request中，底层存储到request域对象
        modelAndView.addObject("user", new User("modelAndView", "18"));
        modelAndView.setViewName("responseSuccess");
        return modelAndView;
    }
    @RequestMapping(value = "/testAjax", consumes = "application/json")
    public @ResponseBody User testAjax(@RequestBody User user) {
        user.setAge("40");
        user.setUname("tom");
        System.out.println(user);
        return user;
    }

}
