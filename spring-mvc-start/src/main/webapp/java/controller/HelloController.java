package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chrisxu
 * @create 2021-10-07 20:44
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println("hello spring mvc");
        return "success";
    }
}
