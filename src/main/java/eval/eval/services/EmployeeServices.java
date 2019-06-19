/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.services;

import eval.eval.entities.Employee;
import eval.eval.repositories.EmployeeRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepositories employeeRepositories;
    
    public List<Employee> getAll() {
        return employeeRepositories.getAll();
    }
}
