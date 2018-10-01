package com.example.PizzaHub.controllers;

import com.example.PizzaHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/login")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/{id}/{username}/{password}",method = RequestMethod.POST)
//    public ResponseEntity<Boolean> logIn(@PathVariable Long id, @PathVariable String username, @PathVariable String password) {
//        return userService.logIn(id,username,password);
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<Boolean> logOut() {
//
//    }


}
