package com.study.system.server;

import com.study.system.server.domain.User;
import com.study.system.server.domain.UserStatus;
import com.study.system.server.serialization.SerializationProvider;
import org.bson.types.ObjectId;
import org.restexpress.RestExpress;
import org.restexpress.exception.BadRequestException;
import org.restexpress.exception.ConflictException;
import org.restexpress.exception.NotFoundException;
import org.restexpress.pipeline.SimpleConsoleLogMessageObserver;
import org.restexpress.util.Environment;
import sun.awt.ConstrainableGraphics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.bind.ValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by xtreme on 4/18/15.
 */
public class Launcher{
    private RestExpress server;
    private Configuration config;

    public Launcher(RestExpress server, String[] args) throws IOException {
        this.server = server;
        this.config = loadEnvironment(args);
    }

    public void start() {
        RestExpress.setSerializationProvider(new SerializationProvider());
        Routes routes = new Routes();
        server.setName(config.getName())
                .setBaseUrl(config.getBaseUrl())
                .addMessageObserver(new SimpleConsoleLogMessageObserver());
        routes.define(server, config);
        server.bind(config.getPort());
        addShutdownHook();
        server.awaitShutdown();
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(createShutdownThread());
    }

    private static void mapExceptions(RestExpress server)
    {
//    	server
//    	.mapException(ItemNotFoundException.class, NotFoundException.class)
//    	.mapException(DuplicateItemException.class, ConflictException.class)
//    	.mapException(ValidationException.class, BadRequestException.class);
    }

    private static Configuration loadEnvironment(String[] args)
            throws FileNotFoundException, IOException
    {
        if (args.length > 0)
        {
            return Environment.from(args[0], Configuration.class);
        }

        return Environment.fromDefault(Configuration.class);
    }

    protected Thread createShutdownThread() {
        final Launcher manager = this;
        return new Thread() {
            @Override
            public void run() {
                manager.stop();
            }
        };
    }

    public void stop() {
        server.shutdown();
    }

    public RestExpress getManagedObjects() {
        return server;
    }
}
