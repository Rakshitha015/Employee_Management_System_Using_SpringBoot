package com.example.emp_man_sys_pro.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.emp_man_sys_pro.entity.Employee;
import com.example.emp_man_sys_pro.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
    
    @Autowired
    private EmpService empService;

    @GetMapping("/")
    public String index(Model m)
    {
        List<Employee> list = empService.getAllEmp();
        m.addAttribute("empList", list);
        return "index";
    }

    @GetMapping("/loadEmpSave")
    public String loadEmpSave()
    {
        return "emp_save";
    }

    @GetMapping("/EditEmp/{id}")
    public String EditEmp(@PathVariable int id,Model m)
    {
        //System.out.println(id);
        Employee emp = empService.getEmpById(id);
        m.addAttribute("emp", emp);
        return "edit_emp";
    }

    @PostMapping("/saveEmp")
    public String saveEmp(@ModelAttribute Employee emp,HttpSession session)
    {
        //System.out.println(emp);
        Employee newEmp = empService.saveEmp(emp);
        if(newEmp!=null)
        {
            //System.out.println("save success");
            session.setAttribute("msg", "Added successfully");
        }
        else
        {
            //System.out.println("no");
           session.setAttribute("msg","something wrong on server");
        }
        return "redirect:/loadEmpSave";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(@ModelAttribute Employee emp,HttpSession session)
    {
        Employee upEmp = empService.saveEmp(emp);
        if(upEmp!=null)
        {
            session.setAttribute("msg", "updated successfully");
        }
        else
        {
            session.setAttribute("msg", "error");
        }
        return "redirect:/";
    }

    @GetMapping("/deleteEmp/{id}")
    public String EmpSave(@PathVariable int id,HttpSession session)
    {
        boolean emp = empService.deleteById(id);
        if(emp)
        {
            session.setAttribute("msg", "delete successfully");
        }
        else
        {
            session.setAttribute("msg", "error");
        }
        return "redirect:/";
    }

}
