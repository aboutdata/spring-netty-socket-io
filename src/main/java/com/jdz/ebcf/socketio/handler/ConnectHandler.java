package com.jdz.ebcf.socketio.handler;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by wangkun23 on 2016/7/22.
 */
@Component
public class ConnectHandler {
    private static final Logger logger = LoggerFactory.getLogger(ConnectHandler.class);

    @OnConnect
    public void onConnect(SocketIOClient client) {
        logger.info("onConnect");
    }

}
