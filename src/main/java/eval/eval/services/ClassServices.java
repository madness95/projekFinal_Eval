/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.services;

import eval.eval.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eval.eval.repositories.ClassRepositories;
import java.util.List;

/**
 *
 * @author sofia
 */
@Service
public class ClassServices {
    @Autowired
    private ClassRepositories classRepositories;
    
      public List<eval.eval.entities.Class> getAll() {
        return classRepositories.getAll();
    }
}
