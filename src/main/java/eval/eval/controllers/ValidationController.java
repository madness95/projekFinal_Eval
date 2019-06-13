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
    private ValidationRepositories forgetPasswordRepositories;

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

        Employee e = forgetPasswordRepositories.getIdByEmail(email);

        Validation validation = new Validation(0, token, "false", new Date(), e);
        forgetPasswordRepositories.save(validation);
        return result;
    }

    @GetMapping("/password/reset")
    public String sendResetPassword(@RequestParam("token") String token, Model model) {
        model.addAttribute("email", forgetPasswordRepositories.getEmailByToken(token).get(0).toString());
        return "forget/password/reset-password";
    }

    @PostMapping("/password/reset/send")
    public String sendResetPassword(String email, String newpass, String repass) {
        String result = "redirect:/forget/password/reset?error";
        Employee e = forgetPasswordRepositories.getIdByEmail(email);
        if (newpass.equals(repass)) {
            e.setPassword(new BCryptPasswordEncoder().encode(newpass));
            employeeRepositories.save(e);
            result = "forget/password/reset-success";
        } else {
            result = "redirect:/forget/password/reset?errpass";
        }
        return result;
    }
}
