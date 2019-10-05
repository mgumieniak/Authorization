package com.database.Authorization.service.templateMethodSave.operations;

import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.repository.UserAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Create extends AbstractSave {

    public Create(ModelMapper mapper, UserAccountRepository repo, PasswordEncoder passwordEncoder) {
        super(mapper, repo, passwordEncoder);
    }

    // TODO: temporary flags
    @Override
    public UserAccount operateAddField(UserAccount user) {
        return new UserAccount.Builder(user.getUsername(), getPasswordEncoder().encode(user.getPassword()))
                .accountExpire(false)
                .active(true)
                .credentialsExpire(false)
                .locked(false)
                .build();
    }
}
