package com.enigmacamp.utility;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Helper {


    public static EntityManager EM() {
        EntityManagerFactory enf = Persistence.createEntityManagerFactory("todo-persistence");
        EntityManager em = enf.createEntityManager();
        return em;
    }

}
