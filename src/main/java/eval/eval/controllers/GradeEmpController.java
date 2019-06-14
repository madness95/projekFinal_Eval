/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.entities.GradeEmp;
import eval.eval.repositories.EmployeeRepositories;
import eval.eval.repositories.GradeEmpRepositories;
import eval.eval.repositories.GradeRepositories;
import eval.eval.services.EmployeeServices;
import eval.eval.services.GradeEmpServices;
import eval.eval.services.GradeServices;
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
 * @author Okala
 */
@Controller
@RequestMapping("/admin")
public class GradeEmpController {

    @Autowired
    private GradeEmpRepositories gradeEmpRepositories;
    @Autowired
    private GradeEmpServices gradeEmpServices;
    @Autowired
    private GradeRepositories gradeRepositories;
    @Autowired
    private GradeServices gradeServices;
    @Autowired
    private EmployeeRepositories employeeRepositories;
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/gradeEmp/all")
    public String index(Model model) {
        model.addAttribute("dataGradeEmp", gradeEmpServices.getAll());
        model.addAttribute("dataEmp", employeeServices.getAll());
        model.addAttribute("dataGrade", gradeServices.getAll());
        return "indexGradeEmp";
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
    @PostMapping("/GradeEmpController/addData")
    public String addData(GradeEmp gradeEmp) {
        gradeEmp.setId(0);
        gradeEmp.setIsdelete("false");
        gradeEmpRepositories.save(gradeEmp);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/admin/gradeEmp/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/GradeEmpController/updateGrade/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid GradeEmp gradeEmp) {
        gradeEmp.setIsdelete("false");
        gradeEmpRepositories.save(gradeEmp);
        return "redirect:/admin/gradeEmp/all";
    }

    @GetMapping("/GradeEmpController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, GradeEmp gradeEmp) {
        gradeEmp.setIsdelete("true");
        gradeEmpRepositories.save(gradeEmp);
        return "redirect:/admin/gradeEmp/all";
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
