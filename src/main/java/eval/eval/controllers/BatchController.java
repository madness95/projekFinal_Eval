/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.entities.Batch;
import eval.eval.repositories.BatchRepositories;
import eval.eval.repositories.ClassRepositories;
import eval.eval.services.BatchServices;
import eval.eval.services.ClassServices;
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
public class BatchController    {

    @Autowired
    private BatchRepositories batchRepositories;
    @Autowired
    private BatchServices batchServices;
    @Autowired
    private ClassRepositories classRepositories;
    @Autowired
    private ClassServices classServices;
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Date.class,
//                new CustomDateEditor(new SimpleDateFormat("yyyy-dd-mm"), true));
//    }

    @GetMapping("/batch/all")
    public String index(Model model) {
        model.addAttribute("dataBatch", batchServices.getAll());
        model.addAttribute("dataClass", classServices.getAll());
        return "indexBatch";
    }

    @PostMapping("/BatchController/addData")
    public String addData(Batch batch) {
        batch.setId(0);
        batch.setIsdelete("false");
        batchRepositories.save(batch);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/class/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/BatchController/update/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Batch batch) {
        batch.setIsdelete("false");
        batchRepositories.save(batch);
        return "redirect:/class/all";
    }

    @GetMapping("/BatchController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Batch batch) {
        batch.setIsdelete("true");
        batchRepositories.save(batch);
        return "redirect:/class/all";
    }
}
