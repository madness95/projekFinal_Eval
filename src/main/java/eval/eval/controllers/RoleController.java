/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.entities.Role;
import eval.eval.repositories.RoleRepositories;
import eval.eval.services.RoleServices;
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
public class RoleController {

    @Autowired
    private RoleRepositories roleRepositories;
    @Autowired
    private RoleServices roleServices;

    @GetMapping("/role/all")
    public String index(Model model) {
        model.addAttribute("dataRole", roleRepositories.getAll());
        return "indexrole";
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
    @PostMapping("/RoleController/addDataRole")
    public String addData(Role role) {
        role.setId(0);
        role.setIsdelete("false");
        roleRepositories.save(role);
//        model.addAttribute("dataActor", filmActorService.findAllActor());
//        return "index";
        return "redirect:/role/all";
    }

//    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @PostMapping("/RoleController/updateRole/{id}")
    public String upadateData(@PathVariable("id") String id, @Valid Role role) {
        role.setIsdelete("false");
        roleRepositories.save(role);
        return "redirect:/role/all";
    }

    @GetMapping("/RoleController/softdelete/{id}")
    public String softDelete(@PathVariable("id") String id, Role role) {
        role.setIsdelete("true");
        roleRepositories.save(role);
        return "redirect:/role/all";
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
