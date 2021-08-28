package com.xyq.springboot.controller;

import com.xyq.springboot.dao.DepartmentDao;
import com.xyq.springboot.dao.EmployeeDao;
import com.xyq.springboot.entities.Department;
import com.xyq.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/**
 * @author chrisxu
 * @create 2020-06-18 18:01
 * Ctrl + Alt + L：格式化代码
 * ctrl + Alt + T：代码块包围
 * ctrl + Y：删除行
 * ctrl + D：复制行
 * alt+上/下：移动光标到上/下方法
 * ctrl+shift+/：注释多行
 */
@Controller
public class EmoloyeeController {
    //    没写service层，直接调dao层
//    @Autowired让 spring 完成 bean 自动装配的工作
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    //    1226antTest
    @RequestMapping("/emps")
    public String list(Model model) {
        return "emp/antTest2";
    }


//    //    将请求设为"/emps"，只要请求"/emps"就会到EmoloyeeController里面
//    @RequestMapping("/emps")
////    传入model参数负责将所有员工返回给前端
//    public String list(Model model) {
////        获取所有的员工
//        Collection<Employee> employees = employeeDao.getAll();
//        model.addAttribute("emps", employees);
//        return "emp/list";
//    }

    //    只能接受get请求，添加员工对应的controller,跳转到添加员工页面
    @GetMapping("/emp")
    public String toAddpage(Model model) {
//        跳转页面之前需要查出部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    //
    @PostMapping("/emp")
//    方法中接收前端传过来的员工
    public String addEmp(Employee employee) {
        System.out.println("save=>" + employee);
        employeeDao.save(employee);

        return "redirect:emps";
    }

    @GetMapping("/emp/{id}")
//    注解有id，那么传入参数也要有@PathVariable("id")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model) {
//      根据id查出员工
        Employee employee = employeeDao.get(id);
//      将员工的数据通过model传给前端页面
        model.addAttribute("emp",employee);
//      查出部门的信息提供给下拉框
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/update";
    }

    @PostMapping("/updateEmp")
//    方法中接收前端传过来的员工
    public String updateEmp(Employee employee) {
        System.out.println("update=>" + employee);
        employeeDao.save(employee);

        return "redirect:emps";
    }

//    删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        System.out.println(id.getClass());
        System.out.println("delete=>" + id);
        employeeDao.delete(id);
//        删除之后重定向到首页
//        return "redirect:emps";
        return "emp/list";

    }

}
