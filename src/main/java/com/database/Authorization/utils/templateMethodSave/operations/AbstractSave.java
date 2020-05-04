package com.database.Authorization.utils.templateMethodSave.operations;

import com.database.Authorization.mapper.UserMapper;
import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.repository.UserAccountRepository;
import com.database.models.UserAccountDto;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class AbstractSave implements Save {
    private UserMapper mapper;
    private UserAccountRepository repo;
    private PasswordEncoder passwordEncoder;

    AbstractSave(UserMapper mapper, UserAccountRepository repo, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    @Override
    public UserAccount operateMapToUser(UserAccountDto userAccountDto) {
        return mapper.toUserAccount(userAccountDto);
    }

    @Override
    abstract public UserAccount operateModify(UserAccount user);

    @Override
    public UserAccount operateSave(UserAccount user) {
        return repo.save(user);
    }
}

