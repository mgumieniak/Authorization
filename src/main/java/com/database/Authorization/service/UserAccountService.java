package com.database.Authorization.service;

import com.database.Authorization.mapper.UserMapper;
import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.repository.UserAccountRepository;
import com.database.Authorization.utils.templateMethodSave.Operation;
import com.database.Authorization.utils.templateMethodSave.SaveOperation;
import com.database.Authorization.utils.templateMethodSave.operations.Create;
import com.database.models.UserAccountDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAccountService {
    private UserMapper mapper;
    private UserAccountRepository userAccountRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserAccountService(UserMapper mapper, UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createAccount(UserAccountDto userToCreate) {
        log.info("Create new user: " + userToCreate.toString());
        Operation createUser = new SaveOperation(new Create(mapper, userAccountRepository, passwordEncoder));
        createUser.save(userToCreate);
    }

    public UserAccount getUserAccount(String username) {
        return userAccountRepository.findByUsername(username);
    }
}
