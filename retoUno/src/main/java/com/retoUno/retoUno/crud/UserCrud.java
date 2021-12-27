/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.retoUno.retoUno.crud;

import com.retoUno.retoUno.Model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Alejandro
 */
public interface UserCrud extends CrudRepository<User, Integer>{
    
    @Query(value = "SELECT*FROM user WHERE user_email = ? ",nativeQuery = true)
    public Optional<User> findByEmail(String email);
   
    @Query(value = "SELECT*FROM user WHERE user_email = ?1 AND user_password =?2 ",nativeQuery = true)
    public User findByEmailPassword (String email, String password);
    
}
