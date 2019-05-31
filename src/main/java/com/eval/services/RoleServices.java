/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.services;

import com.eval.entities.Role;
import com.eval.repositories.RoleRepositories;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class RoleServices {
    @Autowired
    private RoleRepositories roleRepositories;
    
    public List<Role> getAll (){
        return roleRepositories.getAll();
    }
}
