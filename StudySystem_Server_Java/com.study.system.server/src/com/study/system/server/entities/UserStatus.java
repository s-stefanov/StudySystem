package com.study.system.server.entities;

/**
 * Created by xtreme on 5/2/15.
 */
public enum UserStatus {
    Student(1), Teacher(2), Admin(3);
	
	private UserStatus(int n) { value = n; }        
    public final int value;
}
