/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eval.eval.repositories;

import eval.eval.entities.Employee;
import eval.eval.entities.Validation;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Okala
 */
public interface ValidationRepositories extends CrudRepository<Validation, Integer>{
    
    @Query(value = "SELECT e.email FROM validation v INNER JOIN employees e ON v.emp_id=e.id WHERE isactive='false' AND v.token= :token", nativeQuery = true)
    List getEmailByToken(@Param("token") String token);
    
    @Query(value = "SELECT * FROM employees WHERE isdelete='false' AND email= :email", nativeQuery = true)
    Employee getIdByEmail(@Param("email") String email);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE employees SET `password` = :password WHERE email= :email", nativeQuery = true)
    void updatePassword(@Param("email") String email,@Param("password") String password);
}
