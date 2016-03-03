package com.study.system.server.entities;

//import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;

//@DataSourceDefinition(name = "java:app/myAppDS",
//	minPoolSize = 0,
//	initialPoolSize = 0,
//	className = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
//	serverName = "localhost",
//	portNumber = 3037,
//	user = "root",
//	password = "mokanin4o",
//	databaseName = "StudySystem",
//	properties = {"connectionAttributes=;create=true"}
//)

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudySystem");
		EntityManager em = emf.createEntityManager();
		em.setFlushMode(FlushModeType.AUTO);

		User user = new User();
		user.setUserName("gosho");
		user.setPassword("pass");
		user.setStatus(UserStatus.Student.value);
		
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		
		System.out.println(user.getUserId());
		
	}
}
