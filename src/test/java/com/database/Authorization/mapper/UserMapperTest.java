package com.database.Authorization.mapper;

import com.database.Authorization.model.decorator.UserPrincipal;
import com.database.Authorization.model.entity.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = UserMapperImpl.class)
class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    void toUserPrincipalDto() {
        UserAccount userAccount = UserAccount.builder()
                .userAccountId(1L)
                .password("$2a$10$4.LohFE4zJecNCbJ69d6N.biTI0PDQRPDFIX6LJspjcr/Ekj5z8Mi")
                .username("admin").roles("ADMIN")
                .permissions("ROLE_USER").build();

        UserPrincipal userPrincipal = UserPrincipal.builder().userAccount(userAccount).build();
        mapper.toUserPrincipalDto(userPrincipal);
    }

}