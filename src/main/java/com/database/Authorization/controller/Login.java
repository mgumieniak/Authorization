package com.database.Authorization.controller;

import com.database.Authorization.model.UserAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/login")
@CrossOrigin("*")
@Slf4j
public class Login {

    @PostMapping(consumes = "application/json")
    @ResponseStatus
    public void login(@RequestBody UserAccount userAccount){

    }
}
