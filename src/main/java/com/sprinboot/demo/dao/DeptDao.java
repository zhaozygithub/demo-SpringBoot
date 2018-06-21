package com.sprinboot.demo.dao;

import com.sprinboot.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptDao extends JpaRepository<Department,Integer>{
}
