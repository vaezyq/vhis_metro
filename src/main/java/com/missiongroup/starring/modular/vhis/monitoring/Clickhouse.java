package com.missiongroup.starring.modular.vhis.monitoring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import net.sf.json.JSONObject;
import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import static java.lang.Thread.sleep;

@Slf4j
@Component
public class Clickhouse {
    // clickhouse properties
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    //    private static final String PASSWORD = "mission";
    private static final String ADDRESS = "jdbc:clickhouse://10.176.25.26:3306";
    //    private static final String ADDRESS = "jdbc:clickhouse://47.100.176.192:8123";
    private static final String DB = "train_card";
    //    private static final String DB = "dalianjinpu";
    private static final Integer SOCKET_TIMEOUT = 600000;

    // 获得clickhouse连接
    public static Connection getConn() {
        ClickHouseConnection conn = null;
        ClickHouseProperties chProps = new ClickHouseProperties();
        chProps.setUser(USER);
        chProps.setPassword(PASSWORD);
        chProps.setDatabase(DB);
        chProps.setSocketTimeout(SOCKET_TIMEOUT);

        ClickHouseDataSource clickHouseDataSource = new ClickHouseDataSource(ADDRESS, chProps);
        try {
            conn = clickHouseDataSource.getConnection();
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    // 处理sql语句
    public static List<Map<String, String>> exeSql(String sql) {
        System.out.println("cliockhouse 执行sql：" + sql);
        Connection connection = getConn();
        try {
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData rsmd = results.getMetaData();
            List<Map<String, String>> list = new ArrayList<>();
            while (results.next()) {
                Map<String, String> row = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.put(rsmd.getColumnName(i), results.getString(rsmd.getColumnName(i)));
                }
                list.add(row);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void insertSql(String sql) {
//        System.out.println("cliockhouse 执行sql：" + sql);
        Connection connection = getConn();
        try {
            Statement statement = connection.createStatement();
            statement.executeQuery(sql);

            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }

//    public void handle02() throws InterruptedException {
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy/MM/dd_hh:mm:ss:SS");
//        String[]  sql = new String[13];
//        Date date;
//        date = new Date();
//        sleep(1);
//        sql[0] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net01', 'zero', 'run01','control01','南京大学','东南大学','fault','online','yes','55','1201','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[1] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net02', 'zero', 'run02','control02','东南大学','南京南','fault','online','yes','63','1202','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[2] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net03', 'zero', 'run03','control03','南京南','玄武湖','fault','online','yes','86','1203','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[3] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net04', 'zero', 'run04','control04','玄武湖','南京站','fault','online','yes','58','1204','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[4] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net05', 'zero', 'run05','control05','南京站','秦皇庙','fault','online','yes','95','1205','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[5] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net06', 'zero', 'run06','control06','玄武湖','鼓楼','fault','online','yes','105','1206','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[6] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net07', 'zero', 'run07','control07','鼓楼','鸡鸣寺','fault','online','yes','73','1207','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[7] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net08', 'zero', 'run08','control08','鸡鸣寺','珠江路','fault','online','yes','82','1208','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[8] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net09', 'zero', 'run09','control09','珠江路','新街口','fault','online','yes','51','1209','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[9] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net10', 'zero', 'run10','control10','新街口','张府园','fault','online','yes','59','1210','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[10] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net11', 'zero', 'run11','control11','张府园','三山街','fault','online','yes','96','1211','" + ft.format(date) + "')";
//        date = new Date();
//        sleep(1);
//        sql[11] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net12', 'zero', 'run12','control12','三山街','中华门','fault','online','yes','121','1212','" + ft.format(date) + "')";
//        date = new Date();
//        sql[12] = "insert into train12_content values('" + ft.format(date) + "', '12', 'net13', 'zero', 'run13','control13','中华门','安德门','fault','online','yes','136','1213','" + ft.format(date) + "')";
//
//        for(int i = 0; i < 13; i++){
//
//            Clickhouse.insertSql(sql[i]);
//        }
//
//
//        return;
//    }
}
