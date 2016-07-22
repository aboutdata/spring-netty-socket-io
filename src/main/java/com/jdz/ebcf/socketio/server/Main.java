package com.jdz.ebcf.socketio.server;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext  cxt= new FileSystemXmlApplicationContext("src/main/resources/spring-config.xml");
        cxt.registerShutdownHook();
    }
}
