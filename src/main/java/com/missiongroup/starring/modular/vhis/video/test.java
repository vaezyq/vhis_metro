package com.missiongroup.starring.modular.vhis.video;

import com.missiongroup.starring.modular.vhis.monitoring.Clickhouse;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import static java.lang.Thread.sleep;

public class test {

    public static void main(String[] args) throws InterruptedException, SQLException {
//        while(true){
//            sleep(1000);
//            Clickhouse object = new Clickhouse();
//            object.handle02();
//        }

//        String sql = "select * from video_train";
//        String sql = "select line from video_train where project='project01' order by line asc";
//        String sql = "select distinct train from video_train where project='project01' and line='line01' order by train asc";
//        String sql = "select distinct box from video_train where project='project01' and line='line01' and train='train01' order by box asc";
                String projectNum = "project01";
                String lineNum = "line01";
                String trainNum = "train01";
                String box = "box01";
                String location = "place";
                String stream = "stream02";

//        String sql = "insert into video_config(hash, location, stream) values('"+projectNum+" _ "+lineNum+"_"+trainNum+"_"+box+"_"+location+"_"+stream+"','"+location+"','"+stream+"')";
//        List<Map<String, String>> result = video_config.exeSql(sql);
//        String sql = "insert into video_config(hash, location, stream) values('"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"','"+location+"','"+stream+"')";
//        String sql = "delete from video_config where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"' and location='"+location+"' and stream='"+stream+"'";
        String sql = "update video_config set location='"+location+"' where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"' and location='"+location+"'";
//        String sql = "select stream from video_config where hash='"+projectNum+"_"+lineNum+"_"+trainNum+"_"+box+"' and location='"+location+"'";
//        video_config.insertSql(sql);
        List<Map<String, String>> result = video_config.exeSql(sql);
        System.out.println("111");
//        String ans = result.get(0);
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
