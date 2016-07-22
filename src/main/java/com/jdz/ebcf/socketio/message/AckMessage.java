package com.jdz.ebcf.socketio.message;


import com.jdz.ebcf.socketio.message.enums.MsgType;

/**
 *
 *  消息体
 * Created by wangkun23 on 2016/7/8.
 */
public class AckMessage extends ChatMessage {

    private String username;

    private String rank;

    public AckMessage() {

    }

    public AckMessage(String username, String rank, MsgType msgType, String msgContent) {
        this.username = username;
        this.rank = rank;
        this.msgType = msgType;
        this.msgContent = msgContent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "AckMessage{" +
                "username='" + username + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }


}
