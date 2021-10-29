package com.xyq.springboot;

import com.xyq.springboot.dao.EmployeeDao;
import com.xyq.springboot.entities.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
class SpringBoot04WebRestfulcrudApplicationTests {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void contextLoads() {
    }

}
