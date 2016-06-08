package com.expensemanager.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory emf;

    static {
        try {
        	emf = Persistence.createEntityManagerFactory("ExpenseManager");
        } catch (Throwable ex) {
            System.out.println("Initial SessionFactory creation failed" + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static EntityManager getEm() {
		return emf.createEntityManager();
	}
}
