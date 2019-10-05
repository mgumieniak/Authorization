package com.database.Authorization.service.templateMethodSave;

import com.database.Authorization.model.dto.UserAccountDto;
import com.database.Authorization.model.entity.UserAccount;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Operation {
    private final Function<UserAccountDto, UserAccount> mapToUser;
    private final UnaryOperator<UserAccount> addField;
    private final UnaryOperator<UserAccount> save;


    Operation(Function<UserAccountDto, UserAccount> mapToUser, UnaryOperator<UserAccount> addField,
              UnaryOperator<UserAccount> save) {
        this.mapToUser = mapToUser;
        this.addField = addField;
        this.save = save;
    }

    public void save(UserAccountDto userToUpdate) {
        UserAccount user = mapToUser.apply(userToUpdate);
        user = addField.apply(user);
        save.apply(user);
    }
}
