package com.database.Authorization.ModelMapper;

import com.database.Authorization.model.UserPrincipal;
import com.database.Authorization.model.dto.UserAccountDto;
import com.database.Authorization.model.entity.UserAccount;
import com.database.common.model.UserPrincipalDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Mapper {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        applyOwnMapRules(mapper);
        return mapper;
    }

    private void applyOwnMapRules(ModelMapper mapper) {

        // UserDto  --> User
        mapper.createTypeMap(UserAccountDto.class, UserAccount.class).setProvider(
                request -> {
                    UserAccountDto u = (UserAccountDto) request.getSource();
                    return new UserAccount.Builder(u.getUsername(), u.getPassword())
                            .build();
                }
        );

        // User  --> UserDto
        mapper.createTypeMap(UserAccount.class, UserAccountDto.class).setProvider(
                request -> {
                    UserAccount u = (UserAccount) request.getSource();
                    return UserAccountDto.createUserAccount(u.getUsername(), u.getPassword());
                }

        );

        mapper.createTypeMap(UserPrincipal.class, UserPrincipalDto.class).setProvider(
                request -> {
                    UserPrincipal u = (UserPrincipal) request.getSource();
                    return new UserPrincipalDto(u.getAuthorities(),u.getPassword(),
                            u.getUsername(),u.isEnabled(),
                            u.isAccountNonExpired(),u.isAccountNonLocked(),
                            u.isCredentialsNonExpired());
                }
        );
    }
}
