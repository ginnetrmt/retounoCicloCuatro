/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.retoUno.retoUno.service;

import com.retoUno.retoUno.Model.User;
import com.retoUno.retoUno.crud.UserCrud;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro
 */
@Service
public class UserService {

    @Autowired

    private UserCrud userCrud;

    public List<User> getUsers() {
        return (List<User>) userCrud.findAll();
    }

    public Optional<User> getUserByEmail(String email) {
        return userCrud.findByEmail(email);

    }

    public boolean getEmail(String email) {
        Boolean aBoolean = getUserByEmail(email).map(user -> {
            userCrud.findByEmail(email);
            return true;
        }).orElse(false);

        return aBoolean;
    }

    public User getEmailPassword(String email, String password) {
        User u = userCrud.findByEmailPassword(email, password);
        try {
            u.getId();
            return u;

        } catch (NullPointerException e) {
            User u2 = new User();
            u2.setId(null);
            u2.setEmail(email);
            u2.setPassword(password);
            u2.setName("NO DEFINIDO");
            return u2; 
            
        }
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            return userCrud.save(user);
        } else {
            Optional<User> tpmUser = userCrud.findById(user.getId());
            if (tpmUser.isEmpty()) {
                return userCrud.save(user);

            } else {
                return user;
            }

        }
    }

}
