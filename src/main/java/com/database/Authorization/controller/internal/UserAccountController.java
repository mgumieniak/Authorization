package com.database.Authorization.controller.internal;

import com.database.Authorization.mapper.UserMapper;
import com.database.Authorization.model.decorator.UserPrincipal;
import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.service.UserAccountService;
import com.database.models.UserPrincipalDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/usersAccounts")
@CrossOrigin("*")
@Slf4j
public class UserAccountController {

    private UserAccountService userAccountService;
    private UserMapper mapper;

    @Autowired
    public UserAccountController(UserAccountService userAccountService, UserMapper mapper) {
        this.userAccountService = userAccountService;
        this.mapper = mapper;
    }

    @GetMapping("/{username}")
    public UserPrincipalDto getUser(@PathVariable String username) {
        log.info("LOg!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        UserAccount userAccount = userAccountService.getUserAccount(username);
        UserPrincipal userPrincipal = UserPrincipal.builder()
                .userAccount(userAccount)
                .build();
        return mapper.toUserPrincipalDto(userPrincipal);
    }
}
