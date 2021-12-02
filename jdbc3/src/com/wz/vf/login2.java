package com.wz.vf;

import java.util.Scanner;

public class login2 {
    public static void main(String[] args) {
        int input = 0;
        String arr[]=new String[20];
        int arr2[] =new int[20];
        boolean flag = true;
        while (flag){
            menu();
           try {
               Scanner sc = new Scanner(System.in);
               input = sc.nextInt();
               switch (input){
                   case 1:
                       register(arr,arr2);
                       break;
                   case 2:
                       login(arr,arr2);
                       break;
//                   default:
//                       flag = false;
//                       System.out.println("程序结束，再见！！！！");
//                       break;
               }
            }catch (Exception e){
               flag = false;
               System.out.println("程序结束，再见！！！！");

           }
        }

    }
    public static void menu(){
        System.out.println("请选择功能");
        System.out.println("1.注册");
        System.out.println("2.登录");
        System.out.println("3输入任意字符结束");
    }
    public static void register(String arr[],int arr2[]){
        System.out.println("------注册------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的用户名");
        String s = sc.next();
//        String arr[]=new String[2];
        arr[0] = s;
        System.out.println("请输入你的密码");
        int i = sc.nextInt();
//        int arr2[] =new int[2];
        arr2[0]= i;

    }

    public static void login(String arr[],int arr2[]){
        System.out.println("请输入登录账户");
        Scanner sc = new Scanner(System.in);
        String s2 = sc.next();
        for (int i =0;i <arr.length;i++){
            if(s2.equals(arr[i])){
                System.out.println("请输入你的登录密码");
                int i2 = sc.nextInt();
               for (int j = 0;j < arr2.length;j++){
                   if (i2 ==arr2[j]){
                       System.out.println("登陆成功");
                       break;
                   }else {
                       if (j == arr2.length-1){

                           System.out.println("登录失败");
                       }
                   }
               }
               break;
            }else {
                if (i ==arr.length-1)
                System.out.println("登录失败");
            }
        }
//        if(s2.equals(arr[0])){
//            System.out.println("请输入你的登录密码");
//            int i2 = sc.nextInt();
//            if (i2 ==arr2[0]){
//                System.out.println("登陆成功");
//            }else {
//                System.out.println("登录失败");
//            }
//        }else {
//            System.out.println("登录失败");
//        }
    }
}
