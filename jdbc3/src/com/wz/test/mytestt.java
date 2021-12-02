package com.wz.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class mytestt {
    public static void main(String[] args) throws Exception {
//        DruidDataSource db = new DruidDataSource();
//        db.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        db.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai");
//        db.setUsername("root");
//        db.setPassword("1314");
//        for (int i =0; i <=9;i++ ){
//            DruidPooledConnection connection = db.getConnection();
//            System.out.println(connection);
//            if (i == 6){
//                connection.close();
//              }
//        }
//        HashMap map = new HashMap();
//        map.put("driverClassName","com.mysql.cj.jdbc.Driver");
//        map.put("url","jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai");
//        map.put("username","root");
//        map.put("password","1314");
//        DataSource dataSource = DruidDataSourceFactory.createDataSource(map);
//        Connection connection = dataSource.getConnection();
//        System.out.println(connection);

        Properties ps = new Properties();
        ps.setProperty("driverClassName","com.mysql.cj.jdbc.Driver");
        ps.setProperty("url","jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai");
        ps.put("username","root");
        ps.put("password","1314");
        DataSource dataSource = DruidDataSourceFactory.createDataSource(ps);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }
}
