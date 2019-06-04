/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.controllers;

import com.eval.entities.Grade;
import com.eval.entities.Job;
import com.eval.repositories.GradeRepositories;
import com.eval.repositories.JobRepositories;
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
public class GradeController {

    @Autowired
    private GradeRepositories gradeRepossitories;
    @Autowired
    private GradeServices gradeServices;

    @GetMapping("/gradecontroller/all")
    public String index(Model model) {
        model.addAttribute("dataGrade", gradeServices.getAll());
        return "indexGrade";
    }

//    @PostMapping("/addactor")
//    public String addActor(@Valid Actor actor, Model model) {
////        if (result.hasErrors()) {
////            return "index";
////        }
//        actorRepository.save(actor);
//        model.addAttribute("actor", actorRepository.findAll());
//        return "index";
//    }
//    @RequestMapping(value = "/addData", method = RequestMethod.POST)
//    @GetMapping("/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") Short id, Model model) {
//        Short ida = id;
//        int id_actor= ida.intValue();
//        Actor actor = actorRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid actor Id:" + id));
//
//        model.addAttribute("actor", actor);
//        return "updateActor";
//    }
    @PostMapping("/GradeController/addDataGrade")
    public String addData(Grade grade) {
        grade.setId(0);
        grade.setIsdelete("false");
        gradeRepossitories.save(grade);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/gradecontroller/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/GradeController/updateGrade/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Grade grade) {
        grade.setIsdelete("false");
        gradeRepossitories.save(grade);
        return "redirect:/jobcontroller/all";
    }

    @GetMapping("/GradeController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Grade grade) {
        grade.setIsdelete("true");
        gradeRepossitories.save(grade);
        return "redirect:/gradecontroller/all";
    }
//    @GetMapping("/delete/{id}")
//    public String deleteActor(@PathVariable("id") Short id, Model model) {
//        Short ida = id;
//        int id_actor= ida.intValue();
//        Actor actor = actorRepository.findById(id)
//                .orElseThrow(() -> new IllegalArgumentException("Invalid actor Id:" + id));
//        actorRepository.delete(actor);
//        model.addAttribute("actor", actorRepository.findAll());
//        return "index";
//    }
//    @GetMapping("/signin")
//    public String Login() {
//        return "/signin/index";
//    }
//    @GetMapping("/jsonclient")
//    public String JSONClient(Model model){
//        JSONService jsons = new JSONService();
//        model.addAttribute("dataActor", jsons.getJsonObject("http://localhost:8088/json/actor/all/get"));
//        return "/json/index";
//    }
}
