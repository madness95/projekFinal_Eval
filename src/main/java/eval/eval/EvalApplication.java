package eval.eval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Okala
 */
@SpringBootApplication
public class EvalApplication {
    public static void main(String[] args) {
        SpringApplication.run(EvalApplication.class, args);
//          System.out.println(new BCryptPasswordEncoder().encode("user"));
    }
}
