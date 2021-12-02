package com.wz.dao;

import com.wz.domain.User;
import com.wz.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;

import java.util.List;


public class BasicDao<T> {

    private QueryRunner qur = new QueryRunner();
   //查询多个
    public List<T> queryMulit(String sql, Class<T> tClass, int parms){
        Connection conn = null;
        try {
            conn = JdbcUtil.getConn();
            return  qur.query(conn, sql, new BeanListHandler<>(tClass), parms);
        } catch (Exception e) {
            throw  new RuntimeException();
        }finally {
            JdbcUtil.clouse(null,null,conn);
        }
    }

    //查询单个
    public T queryOne(String sql, Class<T> tClass, Object... parms){
        Connection conn = null;
        try {
            conn = JdbcUtil.getConn();
            return qur.query(conn, sql, new BeanHandler<>(tClass), parms);
        } catch (Exception e) {
            throw  new RuntimeException();
        }finally {
            JdbcUtil.clouse(null,null,conn);
        }
    }

    //通用DMl
    public int update(String sql,Object... parms){
        Connection conn = null;
        try {
            conn = JdbcUtil.getConn();
            return qur.update(conn,sql,parms);
        } catch (Exception e) {
            throw  new RuntimeException();
        }finally {
            JdbcUtil.clouse(null,null,conn);
        }
    }
}
