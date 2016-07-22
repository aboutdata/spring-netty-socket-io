package com.jdz.ebcf.socketio.message;

import com.jdz.ebcf.socketio.message.enums.MsgType;
import com.jdz.ebcf.socketio.utils.MsgIdUtils;

import java.io.Serializable;
import java.util.Date;

public abstract class ChatMessage implements Serializable{

     String MsgId= MsgIdUtils.getMsgId().toString();

     MsgType msgType;
     String msgContent;

    Date CreateTime=new Date();

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public MsgType getMsgType() {
        return msgType;
    }

    public void setMsgType(MsgType msgType) {
        this.msgType = msgType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Date getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Date createTime) {
        CreateTime = createTime;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "MsgId='" + MsgId + '\'' +
                ", msgType=" + msgType +
                ", msgContent='" + msgContent + '\'' +
                ", CreateTime=" + CreateTime +
                '}';
    }
}
