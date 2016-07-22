package com.jdz.ebcf.socketio.utils;

/**
 * Created by wangkun23 on 2016/7/8.
 */
public class MsgIdUtils {

    public static synchronized Long getMsgId() {
        return System.nanoTime();
    }
}
