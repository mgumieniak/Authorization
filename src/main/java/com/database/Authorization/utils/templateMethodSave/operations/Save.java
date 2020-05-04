package com.database.Authorization.utils.templateMethodSave.operations;

import com.database.Authorization.model.entity.UserAccount;
import com.database.models.UserAccountDto;

public interface Save {

    UserAccount operateMapToUser(UserAccountDto userDTO);

    UserAccount operateModify(UserAccount user);

    UserAccount operateSave(UserAccount user);
}
