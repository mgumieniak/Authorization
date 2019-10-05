package com.database.Authorization.service;

import com.database.Authorization.model.dto.UserAccountDto;
import com.database.Authorization.repository.UserAccountRepository;
import com.database.Authorization.service.templateMethodSave.Operation;
import com.database.Authorization.service.templateMethodSave.SaveOperation;
import com.database.Authorization.service.templateMethodSave.operations.Create;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserAccountService {
    private ModelMapper mapper;
    private UserAccountRepository userAccountRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserAccountService(ModelMapper mapper, UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createAccount(UserAccountDto userToCreate) {
        log.info("Create new user: " + userToCreate.toString());
        Operation createUser = new SaveOperation(new Create(mapper, userAccountRepository, passwordEncoder));
        createUser.save(userToCreate);
    }
}
