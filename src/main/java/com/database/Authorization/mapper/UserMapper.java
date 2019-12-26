package com.database.Authorization.mapper;

import com.database.Authorization.controller.internal.UserAccountController;
import com.database.Authorization.model.UserPrincipal;
import com.database.Authorization.model.entity.UserAccount;
import com.database.Authorization.service.UserAccountService;
import com.database.models.UserAccountDto;
import com.database.models.UserPrincipalDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", uses = {UserAccountService.class, UserAccountController.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserAccount toUserAccount(UserAccountDto userAccountDto);
//    UserAccountDto toUserAccountDto(UserAccount userAccount);

    //    UserPrincipal toUserPrincipal(UserPrincipalDto userPrincipalDto);
    UserPrincipalDto toUserPrincipalDto(UserPrincipal userPrincipal);
}
