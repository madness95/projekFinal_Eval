/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.services;

import eval.eval.repositories.AuthUserRepositories;
import eval.eval.repositories.EmployeeRepositories;
import eval.eval.repositories.RoleRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sofia
 */
@Service
public class AuthUserServices {

    @Autowired
    private RoleRepositories roleRepositories;

    @Autowired
    private EmployeeRepositories employeeRepositories;

    @Autowired
    private AuthUserRepositories authUserRepositories;

}
