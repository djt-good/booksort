package com.wz.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String user;
    private static String password;

    private static String url;
    private static String driver;

    static {

            Properties properties = new Properties();


            user = "root";
            password = "1314";
            url = "jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai";
            driver = "com.mysql.cj.jdbc.Driver";

    }
     public static Connection getConnectin() throws Exception {
         Connection connection = DriverManager.getConnection(url, user, password);
         return connection;
     }

//    public static void main(String[] args) throws Exception {
//        Connection connectin = JdbcUtils.getConnectin();
//        System.out.println(connectin);
//    }
}



//    public static void main(String[] args) throws SQLException {
//        Connection root = DriverManager.
//                getConnection("jdbc:mysql://localhost:3306/test?serverTimezone=Asia/Shanghai", "root", "1314");
////        String sql = "insert into user values(1,'djt')";
////        String sql = "update user set name=? where id=? ";
//        String sql = "select * from user";
////        String sql = "insert into user values(1,'djt')";
//        PreparedStatement preparedStatement = root.prepareStatement(sql);
////        preparedStatement.setInt(2,1);
////        preparedStatement.setString(1,"dddd");
////        long i = preparedStatement.executeLargeUpdate();
//        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next()){
//            Object object = resultSet.getObject(1);
//            Object object1 = resultSet.getObject(2);
//            System.out.println(object+""+object1);
//
//
//        }
//
//    }
//}


