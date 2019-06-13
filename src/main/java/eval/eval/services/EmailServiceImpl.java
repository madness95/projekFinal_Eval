/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.services;

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
import org.springframework.stereotype.Service;

/**
 *
 * @author galan
 */
@Service
public class EmailServiceImpl {

    public void sendTextMail(String emailTo, String subjectMessage, String message) throws AddressException, MessagingException, IOException {

        Message msg = new MimeMessage(this.session());
        msg.setFrom(new InternetAddress("okalanang13@gmail.com", "EVAL"));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
        msg.setSubject(subjectMessage);
        msg.setContent(message, "text/html");
        msg.setSentDate(new Date());

        Transport.send(msg);
    }

    public boolean sendTextMailBoolean(String emailTo, String subjectMessage, String message) throws AddressException, MessagingException, IOException {
        try {
            Message msg = new MimeMessage(this.session());
            msg.setFrom(new InternetAddress("okalanang13@gmail.com", "EVAL"));

            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            msg.setSubject(subjectMessage);
            msg.setContent(message, "text/html");
            msg.setSentDate(new Date());

            Transport.send(msg);
            return true;
        } catch (Exception ex) {
            
        }
        return false;
    }

    private Session session() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("okalanang.project@gmail.com", "z50Mkk0P");
            }
        });

        return session;
    }

//    EMAIL SOURCE       
//    public void sendmail() throws AddressException, MessagingException, IOException {
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("okalanang.project@gmail.com", "z50Mkk0P");
//            }
//        });
//        Message msg = new MimeMessage(session);
//        msg.setFrom(new InternetAddress("okalanang.project@gmail.com", false));
//
//        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("okalanang13@gmail.com"));
//        msg.setSubject("Tutorials point email");
//        msg.setContent("Tutorials point email", "text/html");
//        msg.setSentDate(new Date());
//
//        MimeBodyPart messageBodyPart = new MimeBodyPart();
//        messageBodyPart.setContent("Tutorials point email", "text/html");
//
//        Multipart multipart = new MimeMultipart();
//        multipart.addBodyPart(messageBodyPart);
//        MimeBodyPart attachPart = new MimeBodyPart();
//
//        attachPart.attachFile("");
//        multipart.addBodyPart(attachPart);
//        msg.setContent(multipart);
//        Transport.send(msg);
//    }
}
