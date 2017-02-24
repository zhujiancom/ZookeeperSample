package com.zj.zookeeper.sample;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * Created by Jian Zhu on 2-10-17.
 */
public class Master implements Watcher {
    ZooKeeper zk;
    String hostPort;

    Master(String hostPort){
        this.hostPort = hostPort;
    }

    void startZK(){
        try {
            zk = new ZooKeeper(hostPort,15000,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process(WatchedEvent event) {
        System.out.println(event);
    }

    public static void main(String[] args) throws Exception{
        Master m = new Master("172.20.30.151");
        m.startZK();
        Thread.sleep(60000);
    }
}
