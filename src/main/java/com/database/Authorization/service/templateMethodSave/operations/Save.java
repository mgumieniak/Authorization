package com.database.Authorization.service.templateMethodSave.operations;

import com.database.Authorization.model.dto.UserAccountDto;
import com.database.Authorization.model.entity.UserAccount;

public interface Save {

    UserAccount operateMapToUser(UserAccountDto userDTO);

    UserAccount operateAddField(UserAccount user);

    UserAccount operateSave(UserAccount user);
}
