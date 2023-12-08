package com.example.emp_man_sys_pro.service;

import java.util.List;

import com.example.emp_man_sys_pro.entity.Employee;

public interface EmpService {

    
    public Employee saveEmp(Employee emp);

    public List<Employee> getAllEmp();

    public Employee getEmpById(int id);

    public boolean deleteById(int id);

   

}  

