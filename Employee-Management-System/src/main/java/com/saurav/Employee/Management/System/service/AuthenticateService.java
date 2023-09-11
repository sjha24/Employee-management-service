package com.saurav.Employee.Management.System.service;
import com.saurav.Employee.Management.System.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class AuthenticateService {
    @Autowired
    EmpRepo empRepo;
    public boolean isAuthenticate(String jobRole){

        return (jobRole.equals("HR"));
    }
    public boolean isAuthenticateByNameOrJobRole(String jobRole, String empName){
        String employeeName = empRepo.findByFirstName(empName);

        return (jobRole.equals("HR")||employeeName.equals(empName));
    }
}
