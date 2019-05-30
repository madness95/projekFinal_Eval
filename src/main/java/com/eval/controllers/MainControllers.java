/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.controllers;

import com.eval.entities.Role;
import com.eval.repositories.RoleRepositories;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sofia
 */
@Controller
public class MainControllers {
    @Autowired
    private RoleRepositories roleRepositories;
    
    @GetMapping("/role/all")
    public String index(Model model) {
        model.addAttribute("dataRole", roleRepositories.findAll());
        return "roleIndex";
    }
    
//    @PostMapping("/addDataRole")
//    public String addData (@Valid Role role){
//        roleRepositories.save(role);
////        model.addAttribute("dataActor", filmActorService.findAllActor());
////        return "index";
//        return "redirect:/indexRole";
//    }
}
