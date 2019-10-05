package com.database.Authorization.service.templateMethodSave.operations;

import com.database.Authorization.model.dto.UserAccountDto;
import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.repository.UserAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class AbstractSave implements Save {
    private ModelMapper mapper;
    private UserAccountRepository repo;
    private PasswordEncoder passwordEncoder;

    AbstractSave(ModelMapper mapper, UserAccountRepository repo, PasswordEncoder passwordEncoder) {
        this.mapper = mapper;
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    @Override
    public UserAccount operateMapToUser(UserAccountDto userDTO) {
        return mapper.map(userDTO, UserAccount.class);
    }

    @Override
    abstract public UserAccount operateAddField(UserAccount user);

    @Override
    public UserAccount operateSave(UserAccount user) {
        return repo.save(user);
    }
}

