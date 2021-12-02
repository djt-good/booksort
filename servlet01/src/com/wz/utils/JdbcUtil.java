package com.wz.utils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil {
    public static <T> T queryForObject(String sql,Class<T> c,Object... parms){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            con = JDBCUtilsByDruid.getConn();
            stmt = con.prepareStatement(sql);
            for (int i =1;i <=parms.length;i++){
                stmt.setObject(i,parms[i-1]);
            }
            stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            T t= null;
            if(rs.next()){
              t =(T)  rs.getObject(1);
            }
            return t;
        }catch (Exception e){
           JDBCUtilsByDruid.clouse(rs,stmt,con);
        }
        return null;
    }

    //结果集为单列  SELECT NAME FROM t_emps
    public static <T> List<T> queryForColumn(String sql, Class<T> c, Object ... args){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //1.获取连接对象
            con = JDBCUtilsByDruid.getConn();
            //2.创建一个发送sql的对象
            stmt = con.prepareStatement(sql);
            //3.给sql中的？赋值
            for (int i = 1; i <= args.length; i++) {
                stmt.setObject(i,args[i-1]);
            }
            //4.发送sql给mysql服务器执行
            rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();

            ArrayList<T> t_list = new ArrayList<>();
            //5.结果集
            while (rs.next()){
                T t =(T) rs.getObject(1);
                t_list.add(t);
            }
            return t_list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    //结果集为多行select * from t_emps where id > ?
    public static <T> List<T> queryForList(String sql, Class<T> c, Object ... args){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //1.获取连接对象
            con = JDBCUtilsByDruid.getConn();
            //2.创建一个发送sql的对象
            stmt = con.prepareStatement(sql);
            //3.给sql中的？赋值
            for (int i = 1; i <= args.length; i++) {
                stmt.setObject(i,args[i-1]);
            }
            //4.发送sql给mysql服务器执行
            rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            //获取结果集总列数
            int columnCount = md.getColumnCount();
            ArrayList<T> t_list = new ArrayList<>();
            //5.结果集
            while (rs.next()){
                T t = c.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    Object object = rs.getObject(i);
                    String columnName = md.getColumnName(i);
                    Field f = c.getDeclaredField(columnName);
                    f.setAccessible(true);
                    f.set(t,object);
                }
                //每一行封装的对象t存入集合中
                t_list.add(t);
            }
            return t_list;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    //结果集为一行 select * from t_dept where id =?  order by ?
    public static <T> T  queryForOne(String sql,Class<T> c,Object ... args)  {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //1.获取连接对象
            con =JDBCUtilsByDruid.getConn();
            //2.创建一个发送sql的对象
            stmt = con.prepareStatement(sql);
            //3.给sql中的？赋值
            for (int i = 1; i <= args.length; i++) {
                stmt.setObject(i,args[i-1]);
            }
            //4.发送sql给mysql服务器执行
            rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            //获取结果集总列数
            int columnCount = md.getColumnCount();
            //5.结果集
            if(rs.next()){
                T t = c.newInstance();
                for (int i = 1; i <= columnCount; i++) {
                    Object value = rs.getObject(i);
                    //获取每一列的列名，和实体类的属性名一致的
                    String columnName = md.getColumnName(i);
                    //一行数据封装到一个对象中
                    Field f = c.getDeclaredField(columnName);
                    f.setAccessible(true);
                    f.set(t,value);
                }
                return t;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;

    }


    //封装增删改
    public static int update(String sql,Object... args) {
        Connection con = null;
        PreparedStatement stmt = null;
        try{
            //1.获取连接对象
            con = JDBCUtilsByDruid.getConn();

            //3.创建一个发送sql的对象
            stmt = con.prepareStatement(sql);
            //3.给sql中的？赋值
            for (int i = 1; i <= args.length; i++) {
                stmt.setObject(i,args[i-1]);
            }
            //4.发送sql给mysql服务器执行
            return stmt.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //6.释放资源
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;


    }
}


