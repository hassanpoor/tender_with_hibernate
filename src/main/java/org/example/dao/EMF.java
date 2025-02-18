package org.example.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;
import java.util.function.Function;

public final class EMF {
    private static final EntityManagerFactory INSTANCE = Persistence.createEntityManagerFactory("tender_test");

    private EMF() {
    }

    public static EntityManagerFactory getInstance() {
        return INSTANCE;
    }

    public static <T> T runJpaCode(Function<EntityManager, T> codeBlock) {
        return runJpaCode(codeBlock, false);
    }

    public static <T> Optional<T> runJpaCodeOpt(Function<EntityManager, T> codeBlock) {
        return runJpaCodeOpt(codeBlock, false);
    }


    public static <T> T runJpaCode(Function<EntityManager, T> codeBlock, boolean withTx) {

        T ret = null;
        EntityManager em = null;

        try {
            em = EMF.getInstance().createEntityManager();
            if (withTx) {
                em.getTransaction().begin();
            }

            ret = codeBlock.apply(em);

            if (withTx) {
                em.getTransaction().commit();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return ret;
    }

    public static <T> Optional<T> runJpaCodeOpt(Function<EntityManager, T> codeBlock, boolean withTx) {

        Optional<T> ret = Optional.empty();
        EntityManager em = null;

        try {
            em = EMF.getInstance().createEntityManager();
            if (withTx) {
                em.getTransaction().begin();
            }

            ret = Optional.ofNullable(codeBlock.apply(em));

            if (withTx) {
                em.getTransaction().commit();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return ret;
    }
}