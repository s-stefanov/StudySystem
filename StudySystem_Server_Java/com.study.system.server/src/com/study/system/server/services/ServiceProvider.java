package com.study.system.server.services;

public class ServiceProvider {
	private UserService userService ;
	private static ServiceProvider INSTANCE;

	private ServiceProvider() {
		userService = new UserService();
	}
	
	public static synchronized ServiceProvider getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new ServiceProvider();
		}
		
		return INSTANCE;
	}
	
	public UserService getUserService() {
		return userService;
	}
}
