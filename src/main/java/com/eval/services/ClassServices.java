/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.services;

import com.eval.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eval.repositories.ClassRepositories;
import java.util.List;

/**
 *
 * @author sofia
 */
@Service
public class ClassServices {
    @Autowired
    private ClassRepositories classRepositories;
    
      public List<com.eval.entities.Class> getAll() {
        return classRepositories.getAll();
    }
}
