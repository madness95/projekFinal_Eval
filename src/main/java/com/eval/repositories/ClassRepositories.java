/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.repositories;

import com.eval.entities.Department;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sofia
 */
@Repository
public interface ClassRepositories extends CrudRepository<com.eval.entities.Class, Integer>{
    @Query(value = "SELECT * FROM `class` WHERE `isdelete` = 'false'", nativeQuery = true)
    List<com.eval.entities.Class> getAll();
}
