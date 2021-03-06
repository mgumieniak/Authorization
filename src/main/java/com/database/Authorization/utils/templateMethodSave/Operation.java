package com.database.Authorization.utils.templateMethodSave;

import com.database.Authorization.model.entity.UserAccount;
import com.database.models.UserAccountDto;

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
        UserAccount inactiveUserAccount = mapToUser.apply(userToUpdate);
        UserAccount activeUserAccount = addField.apply(inactiveUserAccount);
        save.apply(activeUserAccount);
    }
}
