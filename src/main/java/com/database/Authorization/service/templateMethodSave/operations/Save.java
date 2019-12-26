package com.database.Authorization.service.templateMethodSave.operations;

import com.database.Authorization.model.entity.UserAccount;
import com.database.models.UserAccountDto;

public interface Save {

    UserAccount operateMapToUser(UserAccountDto userDTO);

    UserAccount operateAddField(UserAccount user);

    UserAccount operateSave(UserAccount user);
}
