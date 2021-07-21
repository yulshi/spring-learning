package com.example.cache.controller;

import com.example.cache.bean.Employee;
import com.example.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yulshi
 * @create 2020/06/06 14:56
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id) {
        Employee emp = employeeService.getEmp2(id);
        return emp;
    }

    @GetMapping("/emp/update")
    public Employee updateEmployee(Employee employee) {
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id) {
        return employeeService.deleteEmp(id);
    }

}
