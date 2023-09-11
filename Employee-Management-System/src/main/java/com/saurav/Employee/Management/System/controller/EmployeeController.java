package com.saurav.Employee.Management.System.controller;

import com.saurav.Employee.Management.System.model.Employee;
import com.saurav.Employee.Management.System.model.ReportingModel;
import com.saurav.Employee.Management.System.service.AuthenticateService;
import com.saurav.Employee.Management.System.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AuthenticateService authenticateService;

    @GetMapping("/all")
    public List<Employee>getAllEmployees(@RequestParam String jobRole){
        if(authenticateService.isAuthenticate(jobRole)) {
            return employeeService.getAllEmployees();
        }
        return null;
    }
    @PostMapping("/add/{jobRole}")
    public String addEmployee(@RequestBody Employee employee,@PathVariable String jobRole){
        if(authenticateService.isAuthenticate(jobRole)) {
            return employeeService.addEmployee(employee);
        }
        return "unauthorized activity deducted";
    }
    @GetMapping("/Role/{jobRole}/Employee-Name/{empName}")
    public Employee getEmployeeByID(@RequestParam Integer empID,@PathVariable String jobRole,@PathVariable String empName){
        if(authenticateService.isAuthenticateByNameOrJobRole(jobRole, empName)) {
            return employeeService.getEmployeeByID(empID);
        }
        return null;
    }

    @PutMapping("/{jobRole}")
    public String updateEmployeeByID(@RequestParam Integer empID,@PathVariable String jobRole,@RequestBody Employee emp){
        if(empID != null){
            if(authenticateService.isAuthenticateByNameOrJobRole(jobRole,emp.getFirstName())) {
                return employeeService.updateEmployeeByID(empID,emp);
            }
            return "unauthorized activity deducted";
        }
        return "please Enter Employee ID";
    }
    @DeleteMapping("{jobRole}")
    public String removeEmployeeByID(@RequestParam Integer empID,@PathVariable String jobRole,@PathVariable String empName){
        if(empID != null){
            if(authenticateService.isAuthenticate(jobRole)) {
                return employeeService.removeEmployeeByID(empID);
            }
            return "unauthorized activity deducted";
        }
        return "please Enter Employee ID";
    }
    @GetMapping
    public ResponseEntity<List<ReportingModel>> getAllEmployeePerformance(@RequestParam String jobRole){
        if(authenticateService.isAuthenticate(jobRole)) {
            return employeeService.getAllEmployeePerformance();
        }
        return new ResponseEntity<>(HttpStatusCode.valueOf(500));
    }
}
