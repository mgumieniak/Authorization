package com.database.Authorization.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document
public class UserAccount {
    @Id
    private String id;

    private String username;
    private String password;
    private String permissions;
    private String roles;
    private boolean active;
    private boolean accountExpire;
    private boolean locked;
    private boolean credentialsExpire;

    private UserAccount(Builder builder) {
        username = builder.username;
        password = builder.password;
        permissions = builder.permissions;
        roles = builder.roles;
        active = builder.active;
        accountExpire = builder.accountExpire;
        locked = builder.locked;
        credentialsExpire = builder.credentialsExpire;
    }

    public List<String> getRolesList() {
        List<String> rolesList = Collections.emptyList();
        if (this.roles.length() > 0) {
            rolesList = Arrays.asList(this.roles.split(","));
        }
        return rolesList;
    }

    public List<String> getPermissionsList() {
        List<String> permissionsList = Collections.emptyList();
        if (this.permissions.length() > 0) {
            permissionsList = Arrays.asList(this.permissions.split(","));
        }
        return permissionsList;
    }

    public static class Builder {
        private final String username;
        private final String password;
        private final String permissions;
        private final String roles;

        private boolean accountExpire = true;
        private boolean locked = true;
        private boolean credentialsExpire = true;
        private boolean active = false;

        public Builder(String username, String password, String permissions, String roles) {
            this.username = username;
            this.password = password;
            this.permissions = permissions;
            this.roles = roles;
        }

        public Builder active(boolean active) {
            this.active = active;
            return this;
        }

        public Builder accountExpire(boolean accountExpire) {
            this.accountExpire = accountExpire;
            return this;
        }

        public Builder locked(boolean locked) {
            this.locked = locked;
            return this;
        }

        public Builder credentialsExpire(boolean credentialsExpire) {
            this.credentialsExpire = credentialsExpire;
            return this;
        }

        public UserAccount build() {
            return new UserAccount(this);
        }
    }
}
