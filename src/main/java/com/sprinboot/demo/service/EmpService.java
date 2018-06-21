package com.sprinboot.demo.service;

import com.sprinboot.demo.dao.DeptDao;
import com.sprinboot.demo.dao.EmpDao;
import com.sprinboot.demo.model.Department;
import com.sprinboot.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpDao empDao;

    public List<Employee> getAll(){
        return  empDao.findAll();
    }

    @Autowired
    private DeptDao deptDao;

    @Transactional
    public boolean save(Department department){
        deptDao.save(department);
        int i=10/0;
        return true;
    }
}
