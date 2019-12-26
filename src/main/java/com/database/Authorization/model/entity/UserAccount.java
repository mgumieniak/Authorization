package com.database.Authorization.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.Collections;
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
    private final String username = "";
    @Builder.Default
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

//    public static class UserAccountBuilder {
//        private final String username = "";
//        private final String password = "";
//        private final String permissions = "";
//        private final String roles = "";
//        private final boolean active = false;
//        private final boolean accountExpired = true;
//        private final boolean locked = true;
//        private final boolean credentialsExpired = true;
//    }
}

//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
//@Entity
//public class UserAccount {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private String userAccountId;
//
//    private final String username;
//    private final String password;
//    private final String permissions;
//    private final String roles;
//    private final boolean active;
//    private final boolean accountExpire;
//    private final boolean locked;
//    private final boolean credentialsExpire;
//
//    private UserAccount(Builder builder) {
//        userAccountId = builder.userAccountId;
//        username = builder.username;
//        password = builder.password;
//        permissions = builder.permissions;
//        roles = builder.roles;
//        active = builder.active;
//        accountExpire = builder.accountExpire;
//        locked = builder.locked;
//        credentialsExpire = builder.credentialsExpire;
//    }
//
//    public List<String> getRolesList() {
//        List<String> rolesList = Collections.emptyList();
//        if (this.roles.length() > 0) {
//            rolesList = Arrays.asList(this.roles.split(","));
//        }
//        return rolesList;
//    }
//
//    public List<String> getPermissionsList() {
//        List<String> permissionsList = Collections.emptyList();
//        if (this.permissions.length() > 0) {
//            permissionsList = Arrays.asList(this.permissions.split(","));
//        }
//        return permissionsList;
//    }
//
//    public static class Builder {
//        private final String username;
//        private final String password;
//
//        private String permissions = "";
//        private String roles = "";
//        private String userAccountId = null;
//        private boolean accountExpire = true;
//        private boolean locked = true;
//        private boolean credentialsExpire = true;
//        private boolean active = false;
//
//        public Builder(String username, String password) {
//            this.username = username;
//            this.password = password;
//        }
//
//        public Builder permissions(String permissions) {
//            this.permissions = permissions;
//            return this;
//        }
//
//        public Builder roles(String roles) {
//            this.roles = roles;
//            return this;
//        }
//
//        public Builder active(boolean active) {
//            this.active = active;
//            return this;
//        }
//
//        public Builder accountExpire(boolean accountExpire) {
//            this.accountExpire = accountExpire;
//            return this;
//        }
//
//        public Builder locked(boolean locked) {
//            this.locked = locked;
//            return this;
//        }
//
//        public Builder credentialsExpire(boolean credentialsExpire) {
//            this.credentialsExpire = credentialsExpire;
//            return this;
//        }
//
//        public Builder userAccountId(String userAccountId) {
//            this.userAccountId = userAccountId;
//            return this;
//        }
//
//        public UserAccount build() {
//            return new UserAccount(this);
//        }
//    }
//}
