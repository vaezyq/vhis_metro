package com.missiongroup.starring.modular.vhis.monitoring.controller;


import com.missiongroup.starring.modular.vhis.data.websocket.consistenthash.ConsistentHashRouter;
import com.missiongroup.starring.modular.vhis.data.websocket.consistenthash.GetNodes;
import com.missiongroup.starring.modular.vhis.data.websocket.consistenthash.MyServiceNode;
import com.missiongroup.starring.modular.vhis.monitoring.dto.LineInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LineUtils {
    private ConsistentHashRouter<MyServiceNode> consistentHashRouter;

    public static List<LineInfo> getFromDB()   throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<LineInfo> list = new ArrayList<LineInfo>();
        String dirver = "com.mysql.jdbc.Driver";
        String user = "root";
        String psd = "123456";
        String database = "train_card";
        String ip = "10.176.25.26";
        String url = "jdbc:mysql://" + ip + ":3306/train_card?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true" + "&user=" + user + "&password=" + psd;
        Connection conn = DriverManager.getConnection(url);
        Statement stat = conn.createStatement();
        String sql1 = "select * from  line_content";
        ResultSet rs1 = stat.executeQuery(sql1);
        rs1.next();
        System.out.println(rs1.getString("base"));
//        while (rs1.next()) {
////            System.out.println(rs1.getCursorName());
//
//        }
        rs1.close();
        stat.close();
        conn.close();
        return list;
    }

}