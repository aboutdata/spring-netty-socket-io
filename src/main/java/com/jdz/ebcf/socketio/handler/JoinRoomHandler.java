package com.jdz.ebcf.socketio.handler;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.jdz.ebcf.socketio.message.Room;
import com.jdz.ebcf.socketio.message.User;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by wangkun23 on 2016/7/22.
 */
@Component
public class JoinRoomHandler {

    private static final Logger logger = LoggerFactory.getLogger(ChatMessageHandler.class);

    @Autowired
    private SocketIOServer server;

    public static final ConcurrentHashMap<String, Room> rooms = new ConcurrentHashMap<String, Room>();

    @OnEvent(value = "joinRoom")
    public void joinRoom(SocketIOClient client, User user, AckRequest ackRequest) {
        if (user == null) {
            logger.warn("joinRoom user {}", user);
            return;
        }
        //判断传入的用户名和房间号是否有效
        if (StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getRoomId())) {
            logger.info("joinRoom user isEmpty, username {},roomId {},rank {}", user.getUsername(), user.getRank(), user.getRank());
            return;
        } else {
            client.set("username", user.getUsername());
            client.set("roomId", user.getRoomId());
            client.set("rank", user.getRank());

            logger.debug("{}(rank:{}) joinRoom {}", user.getUsername(), user.getRank(), user.getRoomId());

            if (rooms.get(user.getRoomId()) == null) {
                Room room = new Room(user.getRoomId());
                room.getUsers().add(user);
                rooms.put(user.getRoomId(), room);
            } else {
                //如果没有加入 新加入到房间里
                rooms.get(user.getRoomId()).getUsers().add(user);
            }
            logger.debug("rooms size {}", rooms.size());

            client.joinRoom(user.getRoomId());
            server.getRoomOperations(user.getRoomId()).sendEvent("sys", client.get("username") + "JION ROOM" + user.getRoomId());
        }
    }

}
