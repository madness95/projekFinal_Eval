/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eval.controllers;

import com.eval.entities.Batch;
import com.eval.entities.Department;
import com.eval.entities.Grade;
import com.eval.entities.Job;
import com.eval.repositories.BatchRepositories;
import com.eval.repositories.DepartmentRepositories;
import com.eval.repositories.GradeRepositories;
import com.eval.repositories.JobRepositories;
import com.eval.services.BatchServices;
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
 * @author Sofia
 */
@Controller
public class BatchController {

    @Autowired
    private BatchRepositories batchRepositories;
    @Autowired
    private BatchServices batchServices;

    @GetMapping("/batchcontroller/all")
    public String index(Model model) {
        model.addAttribute("dataBatch", batchServices.getAll());
        return "indexBatch";
    }

    @PostMapping("/BatchController/addData")
    public String addData(Batch batch) {
        batch.setId(0);
        batch.setIsdelete("false");
        batchRepositories.save(batch);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/batchcontroller/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/BatchController/update/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Batch batch) {
        batch.setIsdelete("false");
        batchRepositories.save(batch);
        return "redirect:/batchcontroller/all";
    }

    @GetMapping("/BatchController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Batch batch) {
        batch.setIsdelete("true");
        batchRepositories.save(batch);
        return "redirect:/batchcontroller/all";
    }
}
