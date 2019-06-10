/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.controllers;

import com.eval.repositories.ClassRepositories;
import com.eval.services.ClassServices;
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
public class ClassController {

    @Autowired
    private ClassRepositories clasRepositories;
    @Autowired
    private ClassServices clasServices;

    @GetMapping("/classcontroller/all")
    public String index(Model model) {
        model.addAttribute("dataClass", clasServices.getAll());
        return "indexClass";
    }

    @PostMapping("/ClassController/addData")
    public String addData(com.eval.entities.Class classes) {
        classes.setId(0);
        classes.setIsdelete("false");
        clasRepositories.save(classes);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/classcontroller/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/ClassController/update/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid com.eval.entities.Class classes) {
        classes.setIsdelete("false");
        clasRepositories.save(classes);
        return "redirect:/classcontroller/all";
    }

    @GetMapping("/ClassController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, com.eval.entities.Class classes) {
        classes.setIsdelete("true");    
        clasRepositories.save(classes);
        return "redirect:/classcontroller/all";
    }
}
