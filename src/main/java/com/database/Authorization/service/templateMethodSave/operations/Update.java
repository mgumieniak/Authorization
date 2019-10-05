package com.database.Authorization.service.templateMethodSave.operations;

import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.repository.UserAccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Update extends AbstractSave {

    private String userAccountId;

    public Update(ModelMapper mapper, UserAccountRepository repo,
                  PasswordEncoder passwordEncoder, String userAccountId) {
        super(mapper, repo, passwordEncoder);
        this.userAccountId = userAccountId;
    }

    private String getUserAccountId() {
        return userAccountId;
    }

    @Override
    public UserAccount operateAddField(UserAccount user) {
        return new UserAccount.Builder(user.getUsername(), getPasswordEncoder().encode(user.getPassword()))
                .userAccountId(this.getUserAccountId())
                .accountExpire(false)
                .active(true)
                .credentialsExpire(false)
                .locked(false)
                .build();
    }

}
