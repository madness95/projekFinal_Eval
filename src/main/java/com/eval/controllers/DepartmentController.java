/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.controllers;

import com.eval.entities.Department;
import com.eval.entities.Grade;
import com.eval.entities.Job;
import com.eval.repositories.DepartmentRepositories;
import com.eval.repositories.GradeRepositories;
import com.eval.repositories.JobRepositories;
import com.eval.services.DepartmentServices;
import com.eval.services.GradeServices;
import com.eval.services.JobServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Okala
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentRepositories departmentRepositories;
    @Autowired
    private DepartmentServices departmentServices;

        @GetMapping("/departmentcontroller/all")
    public String index(Model model) {
        model.addAttribute("dataDepart", departmentServices.getAll());
        return "indexDepart";
    }
    
    @PostMapping("/DepartmentController/addData")
    public String addData(Department department) {
        department.setId(0);
        department.setIsdelete("false");
        departmentRepositories.save(department);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/departmentcontroller/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/DepartmentController/update/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Department department) {
        department.setIsdelete("false");
        departmentRepositories.save(department);
        return "redirect:/departmentcontroller/all";
    }

    @GetMapping("/DepartmentController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Department department) {
        department.setIsdelete("true");
        departmentRepositories.save(department);
        return "redirect:/departmentcontroller/all";
    }
}
