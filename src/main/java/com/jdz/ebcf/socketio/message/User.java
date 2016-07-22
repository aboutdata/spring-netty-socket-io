package com.jdz.ebcf.socketio.message;

import java.io.Serializable;

/**
 * 聊天用户信息
 * Created by wangkun23 on 2016/7/8.
 */
public class User implements Serializable {

    private String username;
    private String rank;//表示是否是房主
    private String roomId;//项目id


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

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
