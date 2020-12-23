/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arka.infosysUser.controller;

import com.arka.infosysUser.NotFound;
import com.arka.infosysUser.model.Message;
import com.arka.infosysUser.model.User;
import com.arka.infosysUser.repository.UserRepository;
import com.arka.infosysUser.service.MessageService;
import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author arkaf
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    MessageService messageService;
    
    @Autowired
    UserRepository userRepository;
    
    @RequestMapping("/welcome")
    public Message getMessage(){
        return messageService.getMessage();
    }
    
    @GetMapping("/alluser")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User registerUser(@Valid @RequestBody User user){
        String ePassword = Hashing
                .sha256()
                .hashString(user.getPassword(), StandardCharsets.UTF_8)
                .toString();
        user.setPassword(ePassword);
        return userRepository.save(user);
    }
    
    @PostMapping("/login")
    public List<User> loginUser(@Valid @RequestBody User login){
        String ePassword = Hashing
                .sha256()
                .hashString(login.getPassword(), StandardCharsets.UTF_8)
                .toString();
        List<User> responseUser = userRepository.findByEmailAndPassword(login.getEmail(), ePassword);
//        if(responseUser.size() == 0){
//            throw new NotFound("User", "Email", login.getEmail());
//        }
        return responseUser;
    }
}
