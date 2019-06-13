/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.entities.Employee;
import eval.eval.repositories.EmployeeRepositories;
import eval.eval.services.BatchServices;
import eval.eval.services.DepartmentServices;
import eval.eval.services.EmployeeServices;
import eval.eval.services.JobServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
    @Autowired
    private JobServices jobServices;
    @Autowired
    private DepartmentServices departmentServices;
    @Autowired
    private BatchServices batchServices;

    @GetMapping("/employee/all")
    public String index(Model model) {        
        model.addAttribute("dataEmp", employeeServices.getAll());
        model.addAttribute("dataJob", jobServices.getAll());
        model.addAttribute("dataDept", departmentServices.getAll());
        model.addAttribute("dataBatch", batchServices.getAll());
        return "indexEmp";
    }

    @GetMapping("/EmpController/addData")
    public String addData(Employee employee) {
        employee.setId(0);
        employee.setIsdelete("false");
        employeeRepositories.save(employee);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/admin/employee/all";
    }

//    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @PostMapping("/EmpController/update/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Employee employee) {
        employee.setIsdelete("false");
        employeeRepositories.save(employee);
        return "redirect:/admin/employee/all";
    }

    @GetMapping("/EmpController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Employee employee) {
        employee.setIsdelete("true");    
        employeeRepositories.save(employee);
      return "redirect:/admin/employee/all";
    }
}
