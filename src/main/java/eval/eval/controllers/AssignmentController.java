/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.entities.Assignment;
import eval.eval.entities.Authuser;
import eval.eval.repositories.AssignmentRepositories;
import eval.eval.repositories.AuthUserRepositories;
import eval.eval.repositories.EmployeeRepositories;
import eval.eval.repositories.RoleRepositories;
import eval.eval.services.AssignmentServices;
import eval.eval.services.AuthUserServices;
import eval.eval.services.EmployeeServices;
import eval.eval.services.RoleServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Sofia
 */ 
@Controller
@RequestMapping("/admin")
public class AssignmentController    {  
          
   @Autowired
    private AssignmentRepositories assignmentRepositories;
    @Autowired
    private AssignmentServices assignmentServices;
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/assign/all")
    public String index(Model model) {
        model.addAttribute("dataAssign", assignmentServices.getAll());
        model.addAttribute("dataEmp", employeeServices.getAll());
        return "indexAssign";
    }

    @PostMapping("/AssignController/addData")
    public String addData(Assignment assignment) {
        assignment.setId(0);
        assignment.setIsdelete("false");
        assignmentRepositories.save(assignment);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/admin/assign/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/AssignController/update/{id}")
    public String upadateData(@PathVariable("id") String id, Assignment assignment) {
        assignment.setIsdelete("false");
        assignmentRepositories.save(assignment);
        return "redirect:/admin/assign/all";
    }

    @GetMapping("/AssignController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Assignment assignment) {
        assignment.setIsdelete("true");
        assignmentRepositories.save(assignment);
        return "redirect:/admin/assign/all";
    }
}
