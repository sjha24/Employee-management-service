package com.saurav.Employee.Management.System.service;

import com.saurav.Employee.Management.System.model.Authenticate;
import com.saurav.Employee.Management.System.model.ReportingModel;
import com.saurav.Employee.Management.System.repository.ReportingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingService {
    @Autowired
    ReportingRepo reportingRepo;
    public ResponseEntity<List<ReportingModel>> getAllEmployeePerformance() {
        return (ResponseEntity<List<ReportingModel>>) reportingRepo.findAll();
    }
}
