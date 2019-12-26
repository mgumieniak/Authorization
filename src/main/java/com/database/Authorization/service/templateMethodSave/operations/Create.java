package com.database.Authorization.service.templateMethodSave.operations;

import com.database.Authorization.mapper.UserMapper;
import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Create extends AbstractSave {

    public Create(UserMapper mapper, UserAccountRepository repo, PasswordEncoder passwordEncoder) {
        super(mapper, repo, passwordEncoder);
    }

    @Override
    public UserAccount operateAddField(UserAccount user) {
        return UserAccount.builder().username(user.getUsername())
                .password(getPasswordEncoder().encode(user.getPassword()))
                .accountExpired(false)
                .active(true)
                .credentialsExpired(false)
                .locked(false)
                .build();
    }
}
