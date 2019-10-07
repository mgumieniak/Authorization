package com.database.Authorization.controller;

import com.database.Authorization.model.dto.UserAccountDto;
import com.database.Authorization.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/registry")
@CrossOrigin("*")
@Slf4j
public class RegistryController {
    private UserAccountService userAccountService;

    @Autowired
    public RegistryController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registry(@RequestBody UserAccountDto userAccountDto) {
        userAccountService.createAccount(userAccountDto);
    }
}
