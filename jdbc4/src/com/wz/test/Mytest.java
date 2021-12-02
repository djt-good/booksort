package com.wz.test;

import com.wz.dao.UserDao;
import com.wz.domain.User;
import com.wz.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Mytest {
    @Test
    public void testQueryList() throws SQLException {
        Connection conn = JdbcUtil.getConn();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from user";
        List<User> query = queryRunner.query(conn, sql, new BeanListHandler<>(User.class));
        for (User user:query) {
            System.out.println(user);
        }
    }

    @Test
    public void testQueryOne() throws SQLException {
        Connection conn = JdbcUtil.getConn();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from user where id=?";
        User user = queryRunner.query(conn, sql, new BeanHandler<>(User.class), 2);
        System.out.println(user);
  }
       @Test
    //查询单列
    public void testQuerysalar() throws SQLException {
        Connection conn = JdbcUtil.getConn();
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select avg(id) from user where id>?";
        Object name = queryRunner.query(conn, sql, new ScalarHandler<>(), 1);
        System.out.println(name);
    }

    @Test
    //查询单列
    public void testDML() throws SQLException {
        Connection conn = JdbcUtil.getConn();
        QueryRunner queryRunner = new QueryRunner();
        //插入
//        String sql = "insert into user values(null,?,?)";
//        int i = queryRunner.update(conn,sql, "小明", "1234");
//        System.out.println(i);
        //更新
//        String sql = "update user set name=? where  id=?";
//        int i = queryRunner.update(conn, sql, "小华", 2);
//        System.out.println(i);
        //删除
        String sql = "delete from user where  id = ?";
        int update = queryRunner.update(conn, sql, 2);
        System.out.println(update);
    }

    @Test
    public  void test(){
        UserDao user =new UserDao();
        List<User> userDaos = user.queryMulit("select * from user  where id >?", User.class, 1);
        for (User user1:userDaos){
            System.out.println(user1);
        }
    }
}
