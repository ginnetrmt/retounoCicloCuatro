/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.retoUno.retoUno.controller;

import com.retoUno.retoUno.Model.User;
import com.retoUno.retoUno.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro
 */

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getUsers();
    }
      @GetMapping("/{email}")
    public boolean getUserByEmail(@PathVariable("email")String email){
        return userService.getEmail(email);
    }
    
        
   @GetMapping("/{email}/{password}")
    public User getEmailPassword(@PathVariable("email")String email, @PathVariable("password") String password){
        return userService.getEmailPassword (email, password);

    }
    

    
    @PostMapping("/new")
    @ResponseStatus (HttpStatus.CREATED)
    public User registar(@RequestBody User user){
        return userService.saveUser(user);
    }
    
   
   
}
