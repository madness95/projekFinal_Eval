/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.controllers;

import com.eval.entities.Employee;
import com.eval.repositories.BatchRepositories;
import com.eval.repositories.ClassRepositories;
import com.eval.repositories.EmployeeRepositories;
import com.eval.services.BatchServices;
import com.eval.services.ClassServices;
import com.eval.services.EmployeeServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


/**
 *
 * @author Sofia
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepositories employeeRepositories;
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/empcontroller/all")
    public String index(Model model) {
        model.addAttribute("dataEmp", employeeServices.getAll());
        return "indexEmp";
    }

    @PostMapping("/EmpController/addData")
    public String addData(Employee employee) {
        employee.setId(0);
        employee.setIsdelete("false");
        employeeRepositories.save(employee);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/empcontroller/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/EmpController/update/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Employee employee) {
        employee.setIsdelete("false");
        employeeRepositories.save(employee);
        return "redirect:/empcontroller/all";
    }

    @GetMapping("/EmpController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Employee employee) {
        employee.setIsdelete("true");    
        employeeRepositories.save(employee);
        return "redirect:/empcontroller/all";
    }
}
