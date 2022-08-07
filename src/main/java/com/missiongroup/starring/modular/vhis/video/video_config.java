package com.missiongroup.starring.modular.vhis.video;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.*;
public class video_config {
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String ADDRESS = "jdbc:mysql://10.176.25.26:3306/mit_vhis?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
//    private static final Integer SOCKET_TIMEOUT = 600000;

    @Bean
    public DataSource dataSource() throws SQLException {
        DriverManagerDataSource d = new DriverManagerDataSource() ;
        d.setUrl(ADDRESS); //设置url
        d.setUsername(USER); //设置账号
        d.setPassword(PASSWORD); //设置密码
        return d;
    }

    public static List<Map<String,String>> exeSql(String sql) throws SQLException {
        ApplicationContext ac = new AnnotationConfigApplicationContext(video_config.class);
        DataSource d = (DataSource) ac.getBean("dataSource");
        Connection c = d.getConnection(); //获取连接
        System.out.println(c);
        try {
            Statement statement = c.createStatement();
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData rsmd = results.getMetaData();
            List<Map<String,String>> list = new ArrayList<>();
            while(results.next()){
                Map<String,String> row = new HashMap<>();
                for(int i = 1;i<=rsmd.getColumnCount();i++){
                    row.put(rsmd.getColumnName(i),results.getString(rsmd.getColumnName(i)));
                }
                list.add(row);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void insertSql(String sql) throws SQLException{

        ApplicationContext ac = new AnnotationConfigApplicationContext(video_config.class);
        DataSource d = (DataSource) ac.getBean("dataSource");
        Connection c = d.getConnection(); //获取连接
        try {
            Statement statement = c.createStatement();
            statement.execute(sql);

            return;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return;
    }


}
