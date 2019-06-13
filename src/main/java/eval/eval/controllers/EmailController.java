/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.controllers;

import eval.eval.services.EmailServiceImpl;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.EmitUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Okala
 */
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @RequestMapping(value = "/send/{emailTo}")
    public String sendEmail(@PathVariable String emailTo) throws MessagingException, AddressException, IOException {
        String sm = "Forget Password";
        String m = "Please Contact Our Admin";
        emailServiceImpl.sendTextMail(emailTo, sm, m);
        return "Email sent successfully";
    }

}
