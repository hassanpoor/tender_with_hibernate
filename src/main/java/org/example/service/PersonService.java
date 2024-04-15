package org.example.service;

import org.example.entities.Person;

public class PersonService {

    private static PersonService INSTANCE;

    public static PersonService getINSTANCE() {
        if(INSTANCE==null){
            INSTANCE=new PersonService();
        }
        return INSTANCE;
    }

}
