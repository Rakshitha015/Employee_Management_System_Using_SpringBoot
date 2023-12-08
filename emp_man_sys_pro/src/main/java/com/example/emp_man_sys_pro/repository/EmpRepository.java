package com.example.emp_man_sys_pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emp_man_sys_pro.entity.Employee;


@Repository
public interface EmpRepository extends JpaRepository<Employee,Integer>{

    
}
