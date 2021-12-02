package com.wz.utils;



import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsByDruid {
    private static String user;
    private static String password;
    private static String url;
    private static String driver;
    private static DataSource db;
    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtilsByDruid.class.getClassLoader().getResourceAsStream("druid.properties"));
       //  properties.load(new FileInputStream("E:\\code\\code2019.3.1\\project\\jdbc3\\src\\druid.properties"));
            user = properties.getProperty("${username}");
            password = properties.getProperty("${password}");
            url = properties.getProperty("${url}");
            driver = properties.getProperty("${driverClassName}");
        db = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
           throw new RuntimeException(e);
             } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static Connection getConn(){

            try {
                return db.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        public static void clouse(ResultSet set, Statement statement, Connection connection) {
          if(set!=null){
              try {
                  set.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
          if(statement!=null){
              try {
                  statement.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
          if(connection!=null){
              try {
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
        }


    }



