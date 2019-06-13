/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.services;

import eval.eval.entities.Assignment;
import eval.eval.repositories.AssignmentRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class AssignmentServices {
    @Autowired
    private AssignmentRepositories assignmentRepositories;
    
    public List<Assignment> getAll() {
        return assignmentRepositories.getAll();
    }
}
