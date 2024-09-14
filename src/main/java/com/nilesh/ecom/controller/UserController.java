package com.nilesh.ecom.controller;

import com.nilesh.ecom.dto.UserDTO;
import com.nilesh.ecom.entity.Users;
import com.nilesh.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO){
     UserDTO user = userService.register(userDTO);
     return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO){
    return userService.verify(userDTO);
    }
}
