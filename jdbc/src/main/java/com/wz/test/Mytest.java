package com.wz.test;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import com.wz.utils.JdbcUtils;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mytest {
    Connection conn;
    String sql;
    @Before
    public void  inti() throws Exception {
        conn = JdbcUtils.getConnectin();
    }

    @Test
    public void test() throws Exception {
//String sql="insert into user values(2,'小明')";
//        String sql = "update user set name=? where id=?";
//        int i = testUpdate(sql);
//        String sql ="delete from user where id =?";
//        int i = testDelete(sql);
        String sql = "select * from user";
      testselect(sql);
    }

public int testAdd(String sql) throws  Exception{
    PreparedStatement preparedStatement = conn.prepareStatement(sql);
    int  i = (int) preparedStatement.executeLargeUpdate();
    return i;
    }

    public int testUpdate(String sql) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,"你好");
        preparedStatement.setInt(2,2);
        int  l =(int) preparedStatement.executeLargeUpdate();
        return l;
    }
    public  int testDelete(String sql) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,1);
       
        int  l =(int) preparedStatement.executeLargeUpdate();
        return l;
    }

    public  void testselect(String sql) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            Object id = resultSet.getObject(1);
            Object name = resultSet.getObject(2);
            System.out.println("id="+id+" name="+name);
        }
    }
    

}
