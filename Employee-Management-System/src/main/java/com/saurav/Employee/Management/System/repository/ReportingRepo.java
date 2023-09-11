package com.saurav.Employee.Management.System.repository;

import com.saurav.Employee.Management.System.model.Authenticate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportingRepo extends JpaRepository<Authenticate,Integer> {
}
