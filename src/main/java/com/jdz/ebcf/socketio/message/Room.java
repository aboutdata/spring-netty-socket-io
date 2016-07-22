package com.jdz.ebcf.socketio.message;

import java.util.ArrayList;
import java.util.List;

/**
 * 群聊中房间名称
 * Created by wangkun23 on 2016/7/8.
 */
public class Room {

    private String id;
    private List<User> users=new ArrayList<User>();


    public Room(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
