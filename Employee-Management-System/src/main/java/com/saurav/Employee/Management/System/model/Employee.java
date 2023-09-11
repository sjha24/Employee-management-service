package com.saurav.Employee.Management.System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer emp_ID;
    @NotEmpty
    @Column(name = "First_Name")
    private String firstName;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Phone_Number")
    @Length(min = 10,max = 13)
    private String phoneNum;
    @Email
    private String email;
    @NotNull
    private String address;
    @Column(name = "Job_Role")
    @NotEmpty
    private String jobRole;
    private Integer salary;

    @OneToOne
    ReportingModel reportingModel;
}
