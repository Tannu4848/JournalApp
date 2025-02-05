package com.journalproject.journalApp.controller;


import com.journalproject.journalApp.Entity.User;
import com.journalproject.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
    private UserService userService;


   @GetMapping
    public List<User> getAllUser(){

       return userService.getAll();

    }

    @PostMapping
    public void createUser(@RequestBody User user){

        userService.save(user);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> upadateUser(@RequestBody User user ,@PathVariable String userName )
    {
        User  userInDb  = userService.findByUserName(userName);

        if(userInDb != null)
        {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.save(userInDb);
        }
return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
