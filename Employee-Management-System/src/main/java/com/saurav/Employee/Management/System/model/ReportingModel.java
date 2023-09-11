package com.saurav.Employee.Management.System.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ReportingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportID;
    private String employeePerformance;
    private Integer employeeAttendance;
}
