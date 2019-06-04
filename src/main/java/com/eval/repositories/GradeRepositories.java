/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.repositories;

import com.eval.entities.Grade;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sofia
 */
@Repository
public interface GradeRepositories extends CrudRepository<Grade, Integer> {

    @Query(value = "SELECT * FROM `grade` WHERE `isdelete` = 'false'", nativeQuery = true)
    List<Grade> getAll();
}
