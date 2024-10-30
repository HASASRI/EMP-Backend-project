package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ems.entity.Emp;
import com.ems.repository.EmpRepo;

@Service
public class EmpService {

    @Autowired
    private EmpRepo empRepo;

    public String saveEmp(Emp emp) {
        empRepo.save(emp);
        return "Emp record inserted successfully";
    }

    public String deleteEmpById(long eid) {
        empRepo.deleteById(eid);
        return "Emp record deleted successfully";
    }

    public List<Emp> getAllEmp() {
        return empRepo.findAll();
    }

    public String updateEmp(Emp emp) {
        Optional<Emp> empOptional = empRepo.findById(emp.getEid());
        if (empOptional.isPresent()) {
            Emp empToUpdate = empOptional.get();
            empToUpdate.setCompanyName(emp.getCompanyName());
            empToUpdate.setEmail(emp.getEmail());
            empToUpdate.setFirstName(emp.getFirstName()); // Set first name
            empToUpdate.setLastName(emp.getLastName());   // Set last name
            empToUpdate.setGender(emp.getGender());
            empRepo.save(empToUpdate);
            return "Emp record updated successfully";
        } else {
            return "Emp record not found";
        }
    }
}
