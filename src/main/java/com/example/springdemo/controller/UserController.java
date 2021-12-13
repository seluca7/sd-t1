package com.example.springdemo.controller;

import com.example.springdemo.dto.LoginCredentialsDTO;
import com.example.springdemo.dto.UserDTO;
import com.example.springdemo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/all")
    public List<UserDTO> getAll()
    {
        return userService.getAll();
    }

    @GetMapping(value = "/{id}")
    public UserDTO getUserById(@PathVariable("id") Integer id)
    {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/login")
    public Boolean login(@RequestBody LoginCredentialsDTO loginCredentialsDTO){return userService.login(
            loginCredentialsDTO.getUsername(),
            loginCredentialsDTO.getPassword());
    }

    @PostMapping(path = "/create")
    public void create(@RequestBody UserDTO userDTO){
        userService.create(userDTO);
    }
}
