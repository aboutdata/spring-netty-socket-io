package com.jdz.ebcf.socketio.server;

import com.corundumstudio.socketio.SocketIOServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bootstrap {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    @Autowired
    private SocketIOServer server;

    @PostConstruct
    public void start() {
        logger.info("starting server");
        server.start();
    }

    @PreDestroy
    public void stop() {
        logger.info("stop server");
        server.stop();
    }

}
