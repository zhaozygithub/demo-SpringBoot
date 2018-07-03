package com.sprinboot.demo;

import com.sprinboot.demo.dao.DeptDao;
import com.sprinboot.demo.dao.EmpDao;
import com.sprinboot.demo.loadProperties.PersonConf;
import com.sprinboot.demo.model.Department;
import com.sprinboot.demo.model.Employee;
import com.sprinboot.demo.service.EmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private PersonConf personConf;

    @Test
    public void contextLoads() {
        System.out.println(personConf);
    }

    @Autowired
    private EmpDao empDao;

    @Test
    public void testHibernate() {
  /*      List<Employee> all = empDao.findAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }*/
        Optional<Employee> all = empDao.findById(1);
        Employee employee = all.get();
        System.out.println(employee);
    }

    @Autowired
    private EmpService empService;

    @Autowired
    DeptDao deptDao;

    @Test
    public void testDEpt() {
        deptDao.save(new Department("财务部"));

    }


    @Test
    public void testTransaction() {
        empService.save(new Department("销售部01"));

    }

    @Test
    public void testCustomeMethod() {
        Employee employee = empDao.findEmployeeByLastName("zhao");
        System.out.println(employee);

    }

    @Autowired
    private DataSource druid;

    @Test
    public void testDruid() throws SQLException {
        System.out.println(druid.getClass());
        Connection connection = druid.getConnection();
        System.out.println(connection);
        connection.close();
    }



}
