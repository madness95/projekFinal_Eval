/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.repositories;

import eval.eval.entities.Employee;
import eval.eval.entities.ForgetPassword;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Okala
 */
public interface ForgetPasswordRepositories extends CrudRepository<ForgetPassword, Integer>{
    
    @Query(value = "SELECT e.email FROM forget_password fp INNER JOIN employees e ON fp.emp_id=e.id WHERE isactive='false' AND fp.token= :token", nativeQuery = true)
    List getEmailByToken(@Param("token") String token);
    
    @Query(value = "SELECT * FROM employees WHERE isdelete='false' AND email= :email", nativeQuery = true)
    Employee getIdByEmail(@Param("email") String email);
}
