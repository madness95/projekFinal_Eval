/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.services;

import eval.eval.entities.Department;
import eval.eval.entities.Grade;
import eval.eval.repositories.DepartmentRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class DepartmentServices {
    @Autowired
    private DepartmentRepositories departmentRepositories;
    
    public List<Department> getAll() {
        return departmentRepositories.getAll();
    }
}
