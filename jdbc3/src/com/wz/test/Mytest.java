package com.wz.test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.wz.Temps;
import com.wz.utils.JdbcUtil;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Mytest {
    public static void main(String[] args) throws SQLException {
//            queryone("select * from user");
//            update("update user set name=? where  id =? ");
//            querymore("select * from user");
//                delete("delete from user where id =?");
//        insert("insert  into user values(?,?)");
        query("select * from t_emps");
    }

    public static  void query(String sql) throws SQLException {
        Connection conn =  JdbcUtil.getConn();

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Temps> list= new ArrayList<>();
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            Date birth =(Date) resultSet.getObject("birth");
            Double salary =(Double)resultSet.getObject("salary");
            int deptId = resultSet.getInt("deptId");
            Temps temps = new Temps(id,name,sex,birth,salary,deptId);
            list.add(temps);
        }
            System.out.println(list);
        System.out.println(" ········································");
        list.stream().forEach(System.out::println);

        }


    public static  void query2(String sql) throws SQLException {
        Connection conn =  JdbcUtil.getConn();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        if (resultSet.next()) {
            for (int i = 1; i <= columnCount ; i++) {
                Object value = resultSet.getObject(i);
                System.out.print(value+"\t");
            }
            System.out.println();

        }
    }
    public static  void queryone1(String sql) throws SQLException {
        Connection conn =  JdbcUtil.getConn();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            System.out.println("id="+anInt+",name="+string);

        }

    }

    public static  void queryone(String sql) throws SQLException {
        Connection conn =  JdbcUtil.getConn();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            System.out.println("id="+anInt+",name="+string);

        }

    }

    public static  void querymore(String sql) throws SQLException {
        Connection conn =  JdbcUtil.getConn();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            String string = resultSet.getString(2);
            System.out.println("id=" + anInt + ",name=" + string);
        }
    }
        public static void  update(String sql) throws SQLException {
            Connection conn =  JdbcUtil.getConn();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,"asdf");
        preparedStatement.setInt(2,2);
        long i = preparedStatement.executeLargeUpdate();
        if (i >0){
            System.out.println("更新成功！");
        }
    }

    public static void  delete(String sql) throws SQLException {
        Connection conn =  JdbcUtil.getConn();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setInt(1,3);
        long i = preparedStatement.executeLargeUpdate();
        if (i >0){
            System.out.println("删除成功！");
        }
    }

    public static void  insert(String sql) throws SQLException {
        Connection conn =  JdbcUtil.getConn();
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,3);
        preparedStatement.setString(2,"小明");
        long i = preparedStatement.executeLargeUpdate();
        if (i >0){
            System.out.println("添加成功！");
        }
    }
}
