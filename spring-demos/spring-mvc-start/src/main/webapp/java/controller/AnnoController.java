package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author chrisxu
 * @create 2021-10-07 22:21
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})
public class AnnoController {
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(value = "name",required = true) String username){
        System.out.println(username);
        return null;
    }
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println(requestBody);
        return null;
    }
    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(name="sid") String id){
        System.out.println(id);
        return "success";
    }
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        //底层存储到request域对象
        model.addAttribute("msg","美美");
        return "success";
    }
    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        //底层存储到request域对象
        System.out.println(modelMap.get("msg"));
        return "success";
    }
    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus sessionStatus){
        sessionStatus.setComplete();
        return "success";
    }
}
