package com.wz.logg;

import com.wz.utils.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

public class Hello2 {
    public static void main(String[] args) throws SQLException {
        System.out.println("-------------欢迎来到百里半用户管理系统-----------------");
        //创建map集合，存储注册的账户
//        HashMap<String, String> userAccount = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.println("请选择功能：1.注册   2.登录   3.输入其它任意字符结束");
            String menu = sc.nextLine();
            switch (menu){
                case "1":
                    System.out.println("---------注册------------");
                    System.out.println("请输入姓名：");
                    String name = sc.nextLine();
                    System.out.println("请输入密码：");
                    String psw = sc.nextLine();
                    //注册的姓名和密码存入map集合中
                    userAccount(name,psw);
                    break;
                case "2":
                    System.out.println("---------登录------------");
                    System.out.println("请输入登录账户：");
                    String login_name = sc.nextLine();
                    System.out.println("请输入登录密码：");
                    String login_psw = sc.nextLine();
                    //调用判断登录是否成功的方法
                    isLogin(login_name,login_psw);
                    break;
                default:
                    flag=false;

            }
        }
        System.out.println("程序结束，再见...");

    }

    private static void userAccount(String name, String psw) throws SQLException {
        Connection conn = JdbcUtil.getConn();
        String sql = "insert into user values(null,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2,psw);
        long l = preparedStatement.executeUpdate();
        if (l >0){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }

    private static void isLogin(String login_name, String login_psw) throws SQLException {
        Connection conn = JdbcUtil.getConn();
        String sql = "select * from user where name =? and password=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,login_name);
        preparedStatement.setString(2,login_psw);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet!=null){
            System.out.println("******登录成功！******");
        }else {
            System.out.println("******登录失败！******");
        }
    }
}
