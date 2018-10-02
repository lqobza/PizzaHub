package com.example.PizzaHub.controllers;

import com.example.PizzaHub.entities.Pizza;
import com.example.PizzaHub.entities.User;
import com.example.PizzaHub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/users")
@RestController
public class UserController extends BaseController<User> {

    @Autowired
    private UserService userService;

//    @RequestMapping(method = RequestMethod.GET)
//    public List<User> getAll() { return userService.getAll(); }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    public ResponseEntity<User> getUser(@PathVariable Long id) { return userService.getUser(id); }

    @RequestMapping(value = "/{id}/pizzak", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pizza>> getPizzak(@PathVariable Long id) {return userService.getPizzak(id); }

}
