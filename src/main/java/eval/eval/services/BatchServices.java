/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.services;

import eval.eval.entities.Batch;
import eval.eval.entities.Department;
import eval.eval.repositories.BatchRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class BatchServices {
    @Autowired
    private BatchRepositories batchRepositories;
    
     public List<Batch> getAll() {
        return batchRepositories.getAll();
    }
}
