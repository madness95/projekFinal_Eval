/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Okala
 */
@Controller
public class MainController {

    @RequestMapping(value = {"", "/", "/home", "/login"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    
    @GetMapping("/about")
    public String about() {
        return "about";
    }
    
    @GetMapping("/custom")
    public String layout() {
        return "layout";
    }
    
    @GetMapping("/layout")
    public String layoutOrigin() {
        return "layout-original";
    }

    @GetMapping("/403")
    public String error403(){
        return "error/403";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET) 
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                return "error/404";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "error/500";
            } else if (statusCode == HttpStatus.BAD_REQUEST.value()){
                return "error/400";
            }
        }
        return "error/error";
    }

    @GetMapping("/user")
    public String user() {
        return "dashboard/user/index";
    }
}
