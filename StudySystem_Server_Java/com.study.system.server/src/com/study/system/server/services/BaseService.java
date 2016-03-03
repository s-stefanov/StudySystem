package com.study.system.server.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class BaseService {
	//protected EntityManager em;
	private EntityManagerFactory emf;
	
	protected BaseService() {
		emf = Persistence.createEntityManagerFactory("StudySystem");
	}
	
	protected EntityManager createEntityMenager() {
		return emf.createEntityManager();
	}
}
