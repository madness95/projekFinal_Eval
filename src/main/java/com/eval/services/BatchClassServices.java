/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.services;

import com.eval.repositories.BatchClassRepositories;
import com.eval.repositories.BatchRepositories;
import com.eval.repositories.ClassRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class BatchClassServices {
    @Autowired
    private BatchRepositories batchRepositories;
    
    @Autowired
    private ClassRepositories classRepositories;
    
    @Autowired
    private BatchClassRepositories batchClassRepositories;
        
}
