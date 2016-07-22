package com.jdz.ebcf.socketio.utils;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 普通工具
 *  Created by wangkun23 on 2016/7/11
 */
public class Utils {

    private Utils() {

    }
    private static final String COPYRIGHT_NOTICE ="jd.com";

    //发送关闭信号
    public static void sendStopSignal(int port) {
        try {
            Socket s = new Socket(InetAddress.getByName("127.0.0.1"), port);
            OutputStream out = s.getOutputStream();
            System.err.println("sending server stop request");
            out.write(("\r\n").getBytes());
            out.flush();
            s.close();
        } catch(Exception e) {
            // can happen when called twice by jvm shutdown hook
            System.err.println("stop monitor thread has terminated");
        }
    }

}
