//package com.xyq.springboot.config;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author chrisxu
// * @create 2020-06-18 10:11
// * Ctrl + Alt + L：格式化代码
// * ctrl + Alt + T：代码块包围
// * ctrl + Y：删除行
// * ctrl + D：复制行
// * alt+上/下：移动光标到上/下方法
// * ctrl+shift+/：注释多行
// */
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//    //    return true就是放行，否则不放行
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
////        登陆成功之后session中将存在loginUser
//        Object loginUser = request.getSession().getAttribute("loginUser");
//        if (loginUser==null){
//            request.setAttribute("msg","没有权限，请先登录");
////            把上一句的消息返回到首页
////            请求转发,注意是转发到"/index.html"，而非"/login.html"（参考MyMvcConfig的视图映射）
//            request.getRequestDispatcher("/index.html").forward(request,response);
//            return false;
//        }else{
//            return true;
//        }
//
//    }
//}
