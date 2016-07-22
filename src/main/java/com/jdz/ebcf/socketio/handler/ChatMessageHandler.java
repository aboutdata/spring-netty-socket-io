package com.jdz.ebcf.socketio.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.jdz.ebcf.socketio.message.AckMessage;
import com.jdz.ebcf.socketio.message.RequestMessage;
import com.jdz.ebcf.socketio.message.enums.MsgType;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wangkun23 on 2016/7/22.
 */
@Component
public class ChatMessageHandler {

    private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandler.class);


    @Autowired
    private SocketIOServer server;


    @OnEvent(value = "message")
    public void message(SocketIOClient client, RequestMessage chatMessage, AckRequest ackRequest) {

        if (chatMessage == null) {
            logger.debug("chatMessage {}", chatMessage);
            return;
        }
        String username = client.get("username");
        String roomId = client.get("roomId");
        String rank = client.get("rank");
        logger.debug("{}(rank {}) send message {}", username, rank, roomId);
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(roomId)) {
            logger.debug("{} send {}", username, chatMessage.getMsgContent());
            //如果没有内容则不转发
            if (StringUtils.isEmpty(chatMessage.getMsgContent())) {
                logger.info("username {} Message is empty", username);
                return;
            }
            AckMessage ackMessage = new AckMessage(username, rank, MsgType.TEXT, chatMessage.getMsgContent());
            logger.debug("ack Message {}", ackMessage);
            server.getRoomOperations(roomId).sendEvent("message", ackMessage);
        } else {
            logger.info("'{}' send message reject  '{}'", client.getSessionId(), client.getRemoteAddress());
        }

    }


}
