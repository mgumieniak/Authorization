package com.database.Authorization.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public final class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private final Long userAccountId;

    @Builder.Default
    @Column(unique = true)
    private final String username = "";

    @Builder.Default
    @Column(unique = true)
    private final String password = "";

    @Builder.Default
    private final String permissions = "";

    @Builder.Default
    private final String roles = "";

    @Builder.Default
    private final boolean active = false;

    @Builder.Default
    private final boolean accountExpired = true;

    @Builder.Default
    private final boolean locked = true;

    @Builder.Default
    private final boolean credentialsExpired = true;

    public List<String> getRolesList() {
        return Arrays.asList(this.roles.split(","));
    }

    public List<String> getPermissionsList() {
        return Arrays.asList(this.permissions.split(","));
    }
}


