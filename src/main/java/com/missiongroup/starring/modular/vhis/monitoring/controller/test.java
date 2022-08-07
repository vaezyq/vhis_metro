package com.missiongroup.starring.modular.vhis.monitoring.controller;

import com.missiongroup.starring.modular.vhis.data.websocket.KafkaConsumer;
import com.missiongroup.starring.modular.vhis.monitoring.Clickhouse;
import com.missiongroup.starring.modular.vhis.monitoring.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class test {

    @Autowired
    KafkaConsumer kafkaConsumer;

    public static void main(String[] args) throws InterruptedException, SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {


//        String sql = "select distinct trainNum from traincard where lineNum='da-lian-jin-pu-xian' order by collect_time asc";
//        select distinct project from
//        String sql = "select * from Content_02 where lineNum='line01'";
//          String sql = "select * from line_content where lineNum='12'";
//        String sql = "select top 13 * from train12_content order by insert_time desc";

//        String sql = "select train_num from line_content where lineNum='12'";
//          List<Map<String,String>> result = Clickhouse.exeSql(sql);
//        String ans = "lineNum :" + result.get(0).get("lineNum");
        //System.out.println(result.get(0));
//          System.out.println(result);



//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

}
