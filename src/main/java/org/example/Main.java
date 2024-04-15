package org.example;

import org.example.dao.GeneralDao;
import org.example.entities.Person;

public class Main {
    public static void main(String[] args) {


        Person person = Person.builder().name("hossein").family("hassanpour").build();
        GeneralDao.getInstance().persist(person);
    }
}