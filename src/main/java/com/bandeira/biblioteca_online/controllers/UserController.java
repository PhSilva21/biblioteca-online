package com.bandeira.biblioteca_online.controllers;

import com.bandeira.biblioteca_online.dtos.UserRequest;
import com.bandeira.biblioteca_online.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UserRequest> registerUser(@RequestBody @Valid UserRequest userRequest) throws JsonProcessingException {
        var response = userService.createUser(userRequest);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("deleteById")
    public ResponseEntity<Void> deleteById(@RequestParam @Param("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
