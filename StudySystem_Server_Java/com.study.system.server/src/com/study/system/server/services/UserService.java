package com.study.system.server.services;

import java.util.List;

import javax.persistence.EntityManager;

import com.study.system.server.entities.User;



public class UserService extends BaseService {
	
	UserService() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public User getUserById(int userId) {
		EntityManager em = createEntityMenager();
		
		List<User> users = em.createNamedQuery("User.findById")
							.setParameter("userId", userId).getResultList();
		
		if(users.size() > 0) return users.get(0);
		
		return null;
	}
}
