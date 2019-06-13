/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.repositories;

import eval.eval.entities.Batch;
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
public interface BatchRepositories extends CrudRepository<Batch, Integer>{
    @Query(value = "SELECT * FROM batch b WHERE b.isdelete = 'false'", nativeQuery = true)
    List<Batch> getAll();
}
