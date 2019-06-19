/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Okala
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @RequestMapping(value = {"","/", "/dashboard"}, method = RequestMethod.GET)
    public String index(){
        return "dashboard/admin/index";
    }
    
    @RequestMapping(value = {"/settings"}, method = RequestMethod.GET)
    public String settings(){
        return "dashboard/admin/settings";
    }
    
    
//    
//    @GetMapping("/admin/layout")
//    public String layout(){
//        return "dashboard/admin/layout";
//    }
    
}
