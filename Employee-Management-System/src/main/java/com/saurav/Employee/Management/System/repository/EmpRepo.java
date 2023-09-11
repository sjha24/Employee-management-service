package com.saurav.Employee.Management.System.repository;

import com.saurav.Employee.Management.System.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepo extends JpaRepository<Employee,Integer> {
    String findByFirstName(String empName);
}
