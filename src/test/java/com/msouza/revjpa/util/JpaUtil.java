package com.msouza.revjpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private EntityManagerFactory factory;
	private static JpaUtil instance;

	private JpaUtil() {
		this.factory = Persistence.createEntityManagerFactory("RAVJPA");
	}

	public static synchronized JpaUtil getInstance() {
		if (instance == null) {
			instance = new JpaUtil();
		}
		return instance;
	}

	public EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
