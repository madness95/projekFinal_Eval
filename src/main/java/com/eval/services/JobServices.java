/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.services;

import com.eval.entities.Job;
import com.eval.repositories.JobRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class JobServices {

    @Autowired
    private JobRepositories jobRepositories;

    public List<Job> getAll() {
        return jobRepositories.getAll();
    }
}
