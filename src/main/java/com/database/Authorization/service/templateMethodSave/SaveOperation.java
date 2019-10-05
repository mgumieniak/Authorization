package com.database.Authorization.service.templateMethodSave;


import com.database.Authorization.service.templateMethodSave.operations.Save;

public class SaveOperation extends Operation {
    public SaveOperation(Save save) {
        super(save::operateMapToUser,
                save::operateAddField,
                save::operateSave);
    }
}


