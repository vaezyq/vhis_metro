package com.missiongroup.starring.modular.vhis.monitoring;

import com.missiongroup.starring.modular.vhis.monitoring.Clickhouse;

import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class test {

    public static void main(String[] args) throws InterruptedException {
        while(true){
            sleep(1000);
            Clickhouse object = new Clickhouse();
            object.handle02();
        }

//        String sql = "select * from line_content";
//        String sql = "select * from Content_02 where lineNum='line01'";
//          String sql = "select * from line_content where lineNum='12'";
//        String sql = "select top 13 * from train12_content order by insert_time desc";

//        String sql = "select train_num from line_content where lineNum='12'";
//          List<Map<String,String>> result = Clickhouse.exeSql(sql);
//        String ans = "lineNum :" + result.get(0).get("lineNum");
        //System.out.println(result.get(0));
//          System.out.println(result);
    }

}
