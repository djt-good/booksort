package com.wz.dao;

import com.wz.domain.User;
import com.wz.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao extends BasicDAO<User>{

    public int UserAdd(User user) throws SQLException {
       String sql = "insert into user values(null,?,?)";
        int update = update(sql, user.getName(), user.getPassword());
        return update;
    }
}
