package com.database.Authorization.service.templateMethodSave.operations;

import com.database.Authorization.mapper.UserMapper;
import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.repository.UserAccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Update extends AbstractSave {

    private String userAccountId;

    public Update(UserMapper mapper, UserAccountRepository repo,
                  PasswordEncoder passwordEncoder, String userAccountId) {
        super(mapper, repo, passwordEncoder);
        this.userAccountId = userAccountId;
    }

    private String getUserAccountId() {
        return userAccountId;
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
