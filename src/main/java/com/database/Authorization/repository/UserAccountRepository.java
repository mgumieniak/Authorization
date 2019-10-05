package com.database.Authorization.repository;

import com.database.Authorization.model.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount,String> {
    UserAccount findByUsername(String username);
}
