/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.entities.Authuser;
import eval.eval.repositories.AuthUserRepositories;
import eval.eval.repositories.EmployeeRepositories;
import eval.eval.repositories.RoleRepositories;
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
public class AuthUserController    {  
    
    @Autowired
    private AuthUserRepositories authUserRepositories;
    @Autowired
    private AuthUserServices authUserServices;    
    @Autowired
    private EmployeeRepositories employeeRepositories;
    @Autowired
    private RoleRepositories roleRepositories;    
    @Autowired
    private EmployeeServices employeeServices;
    @Autowired
    private RoleServices roleServices;
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class,
//                new CustomDateEditor(new SimpleDateFormat("yyy-MM-dd"), true, 1));
//    }

    @GetMapping("/auth/all")
    public String index(Model model) {
        model.addAttribute("dataEmp", employeeServices.getAll());
        model.addAttribute("dataRole", roleServices.getAll());
        model.addAttribute("dataAuth", authUserServices.getAll());
        return "indexAuthority";
    }

    @PostMapping("/AuthUserController/addData")
    public String addData(Authuser authuser ) {
        authuser.setIsdelete("false");
        authUserRepositories.save(authuser);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/admin/auth/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/AuthUserController/update/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Authuser authuser) {
        authuser.setIsdelete("false");
        authUserRepositories.save(authuser);
        return "redirect:/admin/auth/all";
    }

    @GetMapping("/AuthUserController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, @Valid Authuser authuser) {
        authuser.setIsdelete("true");
        authUserRepositories.save(authuser);
        return "redirect:/admin/auth/all";
    }
}
