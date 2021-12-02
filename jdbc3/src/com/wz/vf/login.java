package com.wz.vf;

import java.util.Scanner;

public class login {
    public static void main(String[] args) {
        System.out.println("------注册------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的用户名");
        String s = sc.next();
        String arr[]=new String[2];
        arr[0] = s;
        System.out.println("请输入你的密码");
        int i = sc.nextInt();
        int arr2[] =new int[2];
        arr2[0]= i;
        System.out.println("------登录------");
        System.out.println("请输入登录账户");
        String s2 = sc.next();
        if(s2.equals(arr[0])){
            System.out.println("请输入你的登录密码");
            int i2 = sc.nextInt();
            if (i2 ==arr2[0]){
                System.out.println("登陆成功");
            }else {
                System.out.println("登录失败");
            }
        }else {
            System.out.println("登录失败");
        }
    }
}
