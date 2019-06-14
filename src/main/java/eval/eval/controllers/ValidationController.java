/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.config.EmailConfig;
import eval.eval.entities.Employee;
import eval.eval.entities.Validation;
import eval.eval.repositories.EmployeeRepositories;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import eval.eval.repositories.ValidationRepositories;

/**
 *
 * @author Okala
 */
@Controller
@RequestMapping("/forget")
public class ValidationController {

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private ValidationRepositories validationRepositories;

    @Autowired
    private EmployeeRepositories employeeRepositories;

    @GetMapping("/password")
    public String index() {
        return "forget/password/index";
    }

    @GetMapping("/password/send")
    public String sendForgetPassword(String email) {
        String result = "redirect:/forget/password?error";
        String token = emailConfig.createToken(emailConfig.randomBetweenTwoNumber(150, 210));

        String subject = "Forget Password";
        String message = "Please click <a href='http://localhost:8082/forget/password/reset?token=" + token + "'>here</a>";

        if (emailConfig.sendEmail(email, subject, message)) {
            result = "forget/password/success";
        }

        Employee e = validationRepositories.getIdByEmail(email);

        Validation validation = new Validation(0, token, e.getId(),"false", new Date());
        validationRepositories.save(validation);
        return result;
    }

    @GetMapping("/password/reset")
    public String sendResetPassword(@RequestParam("token") String token, Model model) {
        String result = "forget/password/reset-password";
        model.addAttribute("email", validationRepositories.getEmailByToken(token).get(0).toString());
        return result;
    }

    @PostMapping("/password/reset/send")
    public String sendResetPassword(String email, String newpass, String repass) {
        String result = "redirect:/forget/password/reset?error";
        if (newpass.equals(repass)) {
            validationRepositories.updatePassword(email, new BCryptPasswordEncoder().encode(newpass));
            result = "forget/password/reset-success";
        } else {
            result = "redirect:/forget/password/reset?errpass";
        }
        return result;
    }
}
