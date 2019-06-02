/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.controllers;

import com.eval.entities.Role;
import com.eval.repositories.RoleRepositories;
import com.eval.services.RoleServices;
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
 * @author sofia
 */
@Controller
public class MainControllers {
    @Autowired
    private RoleRepositories roleRepositories;
    @Autowired
    private RoleServices roleServices;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("dataRole", roleServices.getAll());
//        model.addAttribute("dataRole", roleRepositories.findAll());    
        return "index";
    }
    
//    @GetMapping("/*")
//    public String handleerror (){
//        return "error";        
//    }
    
    @PostMapping("/addDataRole")
    public String addData (@Valid Role role){       
        roleRepositories.save(role);
//        roleServices.insertRole(role.getName());
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/";
    }
    
    @GetMapping("/update")
    public String updateActor(@Valid Role role) {
//        if (result.hasErrors()) {
//            actor.setActorId(id);
//            return "updateActor";
//        }
        roleRepositories.save(role);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteActor(@PathVariable("id") Integer id, Model model) {
//        Short ida = id;
//        int id_actor= ida.intValue();
        Role role = roleRepositories.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid role Id:" + id));
        roleRepositories.delete(role);
        model.addAttribute("role", roleRepositories.findAll());
        return "index";
    }
}
