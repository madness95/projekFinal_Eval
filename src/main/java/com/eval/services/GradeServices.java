/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.services;

import com.eval.entities.Grade;
import com.eval.repositories.GradeRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class GradeServices {

    @Autowired
    private GradeRepositories gradeRepositories;

    public List<Grade> getAll() {
        return gradeRepositories.getAll();
    }
}
