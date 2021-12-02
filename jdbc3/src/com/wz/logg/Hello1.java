package com.wz.logg;

import java.util.Scanner;

public class Hello1 {
    public static void main(String[] args) {
        System.out.println("---------注册------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入密码：");
        String psw = sc.nextLine();

        System.out.println("---------登录------------");
        System.out.println("请输入登录账户：");
        String login_name = sc.nextLine();
        System.out.println("请输入登录密码：");
        String login_psw = sc.nextLine();

        if(name.equals(login_name)&&psw.equals(login_psw)){
            System.out.println("******登录成功！******");
        }else {
            System.out.println("******登录失败！******");
        }
    }
}
