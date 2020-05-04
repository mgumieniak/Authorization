package com.database.Authorization.utils.templateMethodSave;


import com.database.Authorization.utils.templateMethodSave.operations.Save;

public class SaveOperation extends Operation {
    public SaveOperation(Save save) {
        super(save::operateMapToUser,
                save::operateModify,
                save::operateSave);
    }
}


