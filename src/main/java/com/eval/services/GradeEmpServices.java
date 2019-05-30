/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.services;

import com.eval.repositories.EmployeeRepositories;
import com.eval.repositories.GradeEmpRepositories;
import com.eval.repositories.GradeRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class GradeEmpServices {
    @Autowired
    private GradeEmpRepositories gradeEmpRepositories;
    
    @Autowired
    private GradeRepositories gradeRepositories;
    
    @Autowired
    private EmployeeRepositories employeeRepositories;
    
}
