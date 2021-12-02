package com;

import com.wz.utils.JdbcUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class gggg {
   public static <T> T queryForObject(String sql,Class<T> c,Object... parms){
       Connection con =null;
       PreparedStatement stmt = null;
       ResultSet rs =null;
       try {
           con= JdbcUtil.getConn();
           stmt = con.prepareStatement(sql);
           for (int i =1; i<=parms.length;i++){
               stmt.setObject(i,parms[i-1]);
           }
           rs = stmt.executeQuery();
           ResultSetMetaData metaData = rs.getMetaData();
           T t = null;
           if (rs.next()){
                t  = (T) rs.getObject(1);
           }
           return t;
       }catch (Exception e){
            throw  new RuntimeException();
       }finally {
           JdbcUtil.clouse(rs,stmt,con);
       }
   }
    public static <T> List<T> queryForColumn(String sql, Class<T> c, Object ... args) {
        Connection con =null;
        PreparedStatement stmt = null;
        ResultSet rs =null;
        try {
            con= JdbcUtil.getConn();
            stmt = con.prepareStatement(sql);
            for (int i = 1; i <= args.length; i++) {
                stmt.setObject(i,args[i-1]);
            }
            rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();

            ArrayList<T> t_list = new ArrayList<>();
            while (rs.next()){
             T t  = (T) rs.getObject(1);
             t_list.add(t);
            }
            return t_list;
        } catch (Exception e) {
            throw new RuntimeException();
        }


    }
    public static <T> List<T> queryForList(String sql, Class<T> c, Object ... args) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            //1.获取连接对象
            con = JdbcUtil.getConn();
            //2.创建一个发送sql的对象
            stmt = con.prepareStatement(sql);
            //3.给sql中的？赋值
            for (int i = 1; i <= args.length; i++) {
                stmt.setObject(i, args[i - 1]);
            }
            //4.发送sql给mysql服务器执行
            rs = stmt.executeQuery();
            ResultSetMetaData md = rs.getMetaData();
            //获取结果集总列数
            int columnCount = md.getColumnCount();
            ArrayList<T> t_list = new ArrayList<>();
            while (rs.next()){
                T t = c.newInstance();
                for (int i =0; i<=columnCount;i++ ){
                    Object value = rs.getObject(i);
                    String columnName = md.getColumnName(i);
                    Field f = c.getDeclaredField(columnName);
                    f.setAccessible(true);
                    f.set(t,value);
                }
                t_list.add(t);
            }
        return t_list;
        } catch (Exception e) {
           throw  new RuntimeException();
        }
        
    }
}