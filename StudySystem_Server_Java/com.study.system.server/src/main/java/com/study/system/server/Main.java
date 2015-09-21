package com.study.system.server;

import com.study.system.server.domain.User;
import org.restexpress.RestExpress;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main( String[] args ) {
        Launcher server = null;
        try {
            server = new Launcher(new RestExpress(), args);
        } catch (IOException e) {
            System.out.println("Requested properties file not found...");
            return;
        }
        server.start();
    }
}
