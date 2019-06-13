package eval.eval;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EvalApplication {
         @PostConstruct
    public void init(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
    public static void main(String[] args) {
                SpringApplication.run(EvalApplication.class, args);
//                        System.out.println(new BCryptPasswordEncoder().encode("admin"));
//                        System.out.println(new BCryptPasswordEncoder().encode("user"));
        
//        int length = 140;
//        String AlpaNumericString = ".0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY";
//        String randomString = "";
//        
//        for (int i = 0; i < length; i++) {
//            randomString += AlpaNumericString.charAt((int) Math.floor(Math.random() * ((AlpaNumericString.length() - 1) - 0)) + 0);
//        }
//        System.out.println(randomString);
    }
}
