package org.example.dao;


import org.example.entities.Person;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import java.util.List;

import static org.example.dao.EMF.runJpaCode;

public class GeneralDao<Id> {

    private static GeneralDao instance;

    public GeneralDao() {

    }

    public static GeneralDao getInstance() {
        if (instance == null) {
            instance = new GeneralDao();
        }
        return instance;
    }

    public Object persist(Object object) {
        return runJpaCode(em -> {
            em.persist(object);
            return object;
        }, true);
    }

    public Object find(Class aClass, Id id) {
        return runJpaCode(entityManager -> entityManager.find(aClass, id));
    }

    public List<Object> findAll(Object o) {
        return null;
    }


}
