/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.repositories;

import com.eval.entities.Job;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sofia
 */
@Repository
public interface JobRepositories extends CrudRepository<Job, String>{
     @Query(value = "SELECT * FROM `job` WHERE `isdelete` = 'false'", nativeQuery = true)
        List<Job> getAll (); 
}
