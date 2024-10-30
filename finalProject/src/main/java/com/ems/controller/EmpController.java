package com.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Emp;
import com.ems.service.EmpService;

@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @PostMapping("/saveemp")
    public String saveEmpDetails(@RequestBody Emp emp) {
        return empService.saveEmp(emp);
    }

    @DeleteMapping("/deleteemp")
    public String deleteEmpById(@RequestBody Emp emp) {
        return empService.deleteEmpById(emp.getEid());
    }

    @GetMapping("/getallemp")
    public List<Emp> getAllEmp() {
        return empService.getAllEmp();
    }

    @PutMapping("/updateemp")
    public String updateEmpDetails(@RequestBody Emp emp) {
        return empService.updateEmp(emp);
    }
}
