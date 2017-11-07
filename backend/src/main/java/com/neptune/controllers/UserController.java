/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neptune.controllers;

import com.neptune.entities.User;

import com.neptune.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Neptune
 */
@Controller
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("get")
    public ResponseEntity get(@RequestParam("id") String id) {
        User user = userService.get(Integer.parseInt(id));
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity getAll() {
        List<User> list = userService.getAll();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
