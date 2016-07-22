package com.jdz.ebcf.socketio.handler;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 失去连接监听
 * Created by wangkun23 on 2016/7/22.
 */
@Component
public class DisConnectHandler {
    private static final Logger logger = LoggerFactory.getLogger(DisConnectHandler.class);

    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        if (client.get("username") != null) {
            logger.info("{} 失去连接", client.get("username"));
        } else {
            logger.info(client.getSessionId() + "onDisconnect");
        }
    }
}
