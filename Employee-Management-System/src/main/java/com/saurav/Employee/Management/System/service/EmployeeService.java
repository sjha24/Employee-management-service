package com.saurav.Employee.Management.System.service;

import com.saurav.Employee.Management.System.model.Employee;
import com.saurav.Employee.Management.System.model.ReportingModel;
import com.saurav.Employee.Management.System.repository.EmpRepo;
import com.saurav.Employee.Management.System.repository.ReportingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmpRepo empRepo;

    @Autowired
    ReportingService reportingService;

    public List<Employee> getAllEmployees() {
        return empRepo.findAll();
    }

    public String addEmployee(Employee employee) {
        if(employee != null){
            empRepo.save(employee);
            return "Employee Added Successfull";
        }
        return "Please enter valid Detail";
    }

    public Employee getEmployeeByID(Integer empID) {
        boolean isExist = empRepo.existsById(empID);
        if(isExist){
            return empRepo.findById(empID).orElse(null);
        }
        return null;
    }

    public String removeEmployeeByID(Integer empID) {
        boolean isExist = empRepo.existsById(empID);
        if(isExist){
            empRepo.deleteById(empID);
            return "Employee Removed Successfull";
        }
        return "Please enter valid employee Id";
    }

    public String updateEmployeeByID(Integer empID, Employee emp) {
        boolean isExist = empRepo.existsById(empID);
        if(isExist){
            Employee employee = empRepo.findById(empID).orElse(null);
            assert employee != null;
            employee.setFirstName(emp.getFirstName());
            employee.setLastName(emp.getLastName());
            employee.setPhoneNum(emp.getPhoneNum());
            employee.setEmail(emp.getEmail());
            employee.setAddress(emp.getAddress());
            employee.setJobRole(emp.getJobRole());
            employee.setSalary(emp.getSalary());
            empRepo.save(employee);
            return "Employee Update Successfull";
        }
        return "PLease enter Valid Employee ID";
    }

    public ResponseEntity<List<ReportingModel>> getAllEmployeePerformance() {
        return reportingService.getAllEmployeePerformance();
    }
}
