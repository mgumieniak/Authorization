package com.database.Authorization.controller.internal;

import com.database.Authorization.model.UserPrincipal;
import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.service.UserAccountService;
import com.database.common.model.UserPrincipalDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/userAccounts")
@CrossOrigin("*")
@Slf4j
public class UserAccountController {

    private UserAccountService userAccountService;
    private ModelMapper mapper;

    @Autowired
    public UserAccountController(UserAccountService userAccountService, ModelMapper mapper) {
        this.userAccountService = userAccountService;
        this.mapper = mapper;
    }

    @GetMapping("/{username}")
    public UserPrincipalDto getUserByUsername(@PathVariable String username) {
        UserAccount userAccount =  userAccountService.getUserAccountByUsername(username);
        UserPrincipal userPrincipal = new UserPrincipal(userAccount);
        return mapper.map(userPrincipal, UserPrincipalDto.class);
    }

}
