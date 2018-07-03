package com.sprinboot.demo.dao;

import com.sprinboot.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpDao extends JpaRepository<Employee,Integer> {
public Employee findEmployeeByLastName(String lastName);

}
