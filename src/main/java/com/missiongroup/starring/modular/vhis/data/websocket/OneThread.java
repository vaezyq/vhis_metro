package com.missiongroup.starring.modular.vhis.data.websocket;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.websocket.Session;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;


public class OneThread extends Thread {
    private Session session;
    private DBUtil dbUtil;
    String tid;

    @Resource
    private KafkaConsumer kafkaConsumer;


//    public static void GetTid(String tid){
//        tid = tid;
//    }

    public OneThread(Session session) {
        this.session = session;
        dbUtil = new DBUtil();
    }

    @Override
    public void run() {
        while (true) {

//            List<TrainInfo> list = null;
//            try {
//                try {
//                    list = dbUtil.getFromDB(tid);
//                    if (session.isOpen()) {
//                        String dataText = "";
//                        for (int i = 0; i < 6; i++) {
//                            dataText = dataText + list.get(i).getData();
//                        }
//                        System.out.println(tid);
//                        System.out.println("datatext:" + dataText.substring(1, 5));
//                        session.getBasicRemote().sendText(dataText);
//                    }
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                } catch (InstantiationException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            ThreadSleep(DDUDataSocket.getOnlineCount());

            System.out.println("=============");
            try {
                if (session.isOpen()) {
//                    System.out.println("" + tid);
                    String tid = "7002";

                    System.out.println(KafkaConsumer.resDdu.size());
//                    System.out.println(kafkaConsumer.getResDdu("7002"));
//                    String s = kafkaConsumer.getResDdu("7002");
//                    System.out.println("datatext:" + s.length());
                    session.getBasicRemote().sendText(KafkaConsumer.resDdu.get("7002"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void ThreadSleep(int threadCount) {
        double sleepTime;
        sleepTime = -(1.0 / 2000) * threadCount * threadCount * threadCount
                + 0.175 * threadCount * threadCount + 2.5 * threadCount + 500;
        try {
            Thread.sleep((long) sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}