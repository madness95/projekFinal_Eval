/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.entities.Job;
import eval.eval.repositories.JobRepositories;
import eval.eval.services.JobServices;
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
@RequestMapping("/admin")
public class JobController {

    @Autowired
    private JobRepositories jobRepositories;
    @Autowired
    private JobServices jobServices;

    @GetMapping("/job/all")
    public String index(Model model) {
        model.addAttribute("dataJob", jobServices.getAll());
        return "indexJob";
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
    @PostMapping("/JobController/addDataJob")
    public String addData(Job job) {        
        job.setIsdelete("false");
        jobRepositories.save(job);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/job/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/JobController/updateJob/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Job job) {
        job.setIsdelete("false");
        jobRepositories.save(job);
        return "redirect:/job/all";
    }

    @GetMapping("/JobController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Job job) {
        job.setIsdelete("true");
        jobRepositories.save(job);
        return "redirect:/job/all";
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
