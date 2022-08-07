package com.missiongroup.starring.modular.vhis.data.websocket;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class KafkaConsumer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    //  ddu信息
    public final  static HashMap<String, String> resDdu = new HashMap<>();

    // 车辆卡片
    public final static HashMap<String, String> resTrainCard = new HashMap<>();

    // 车辆故障
    public final  static HashMap<String, String> resTrainFault = new HashMap<>();

    public String getResDdu(String s) {
        if (resDdu.containsKey(s)) {
            return resDdu.get(s);
        } else {
            return "";
        }
    }

    public HashMap<String, String> getResTrainCard() {
        return resTrainCard;
    }

    public HashMap<String, String> getResTrainFault() {
        return resTrainFault;
    }

    //主题
    private static final String topic_ddu = "ddu";

    private static final String topic_train_card = "traincard";

    private static final String topic_fault = "fault";

    // ddu页面
    @KafkaListener(id = "", topics = topic_ddu)
//    @RequestMapping("/index")
    public void listenerDdu(ConsumerRecord<?, ?> record) {
//        System.out.println("+++++++++++");
//        String resold=new String(res);

        if (resDdu.containsKey("" + record.key())) {
            resDdu.replace("" + record.key(), "" + record.value());
        } else {
            resDdu.put("" + record.key(), "" + record.value());
        }
//        System.out.println(resDdu.size());

    }

    // train_card页面
    @KafkaListener(id = "", topics = topic_train_card)
    public void listenerCard(ConsumerRecord<?, ?> record) {
//        System.out.println("+++++++++++");
        if (resTrainCard.containsKey("" + record.key())) {
            resTrainCard.replace("" + record.key(), "" + record.value());
//            System.out.println(resTrainCard);
        } else {
            resTrainCard.put("" + record.key(), "" + record.value());
//            System.out.println(resTrainCard);
        }
//        System.out.println(resTrainCard);
    }

    // train_fault页面
    @KafkaListener(id = "", topics = topic_fault)
    public void listenerFault(ConsumerRecord<?, ?> record) {
        if (resTrainFault.containsKey("" + record.key())) {
            resTrainFault.replace("" + record.key(), "" + record.value());
//            System.out.println(resTrainFault);
        } else {
            resTrainFault.put("" + record.key(), "" + record.value());
//            System.out.println(resTrainFault);
        }
    }
}
