package com.database.Authorization.model.decorator;

import com.database.Authorization.model.entity.UserAccount;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserPrincipal implements UserDetails {

    @Builder.Default
    private final UserAccount userAccount = UserAccount.builder().build();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.concat(getPermissionsListWithGrantedAuth().stream(),
                getRolesListWithGrantedAuth().stream())
                .collect(Collectors.toList());
    }

    private List<SimpleGrantedAuthority> getPermissionsListWithGrantedAuth() {
        return userAccount.getPermissionsList()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    private List<SimpleGrantedAuthority> getRolesListWithGrantedAuth() {
        return userAccount.getRolesList()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.userAccount.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userAccount.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.userAccount.isAccountExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.userAccount.isLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.userAccount.isAccountExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.userAccount.isActive();
    }
}
