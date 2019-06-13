/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.repositories;

import eval.eval.entities.Department;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sofia
 */
@Repository
public interface DepartmentRepositories extends CrudRepository<Department, Integer> {

    @Query(value = "SELECT * FROM `department` WHERE `isdelete` = 'false'", nativeQuery = true)
    List<Department> getAll();
}
