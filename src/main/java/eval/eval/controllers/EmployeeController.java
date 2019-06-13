/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.entities.Employee;
import eval.eval.repositories.BatchRepositories;
import eval.eval.repositories.ClassRepositories;
import eval.eval.repositories.EmployeeRepositories;
import eval.eval.services.BatchServices;
import eval.eval.services.ClassServices;
import eval.eval.services.EmployeeServices;
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
public class EmployeeController {

    @Autowired
    private EmployeeRepositories employeeRepositories;
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/employee/all")
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
        return "redirect:/employee/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/EmpController/update/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Employee employee) {
        employee.setIsdelete("false");
        employeeRepositories.save(employee);
        return "redirect:/employee/all";
    }

    @GetMapping("/EmpController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Employee employee) {
        employee.setIsdelete("true");    
        employeeRepositories.save(employee);
        return "redirect:/employee/all";
    }
}
