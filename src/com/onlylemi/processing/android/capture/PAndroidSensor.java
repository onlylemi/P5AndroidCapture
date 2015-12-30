package com.onlylemi.processing.android.capture;

import sun.misc.IOUtils;
import sun.rmi.runtime.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * processing android sensor
 *
 * @author onlylemi
 */
public class PAndroidSensor implements Runnable {

    private byte[] byteBuffer = new byte[1024];
    private ServerSocket ss = null;
    private InputStream ins;
    private String data = "";

    private long start, end;
    private boolean flag;

    private long rate;

    private Thread thread;


    public PAndroidSensor(long rate) {
        this.rate = rate;

        flag = true;
        start = System.currentTimeMillis();
        try {
            ss = new ServerSocket(6000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        thread = new Thread(this);
    }

    @Override
    public void run() {
        while (flag) {
            Socket s;
            try {
                s = ss.accept();
                if (s == null) {
                    System.out.println("connect fail!!! ");
                    flag = false;
                }
                // System.out.println("connect success. ");
                ins = s.getInputStream();

                StringBuffer sb = new StringBuffer();
                int amount;
                while ((amount = ins.read(byteBuffer)) != -1) {
                    sb.append(new String(byteBuffer, 0, amount));
                }
                data = sb.toString();

                System.out.println("data:" + data);

                //start = end;
                end = System.currentTimeMillis();
                if (end - start < rate) {
                    Thread.sleep(rate - (end - start));
                    start = end;
                }
                ins.close();
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public void start() {
        thread.start();
    }


    public void restart() {
        thread.resume();
    }

    public void pause() {
        thread.suspend();
    }

    public String getData() {
        return data;
    }
}
