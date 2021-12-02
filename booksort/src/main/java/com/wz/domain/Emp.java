package com.wz.domain;

import javax.persistence.*;

public class Emp {
    @Id
    private Integer id;

    private String username;

    private String password;

    /**
     * 0是超级管理员：能够进入系统管理界面，1是普通用户，进入普通用户界面，能够进行借书还书操作
     */
    private Integer grade;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取0是超级管理员：能够进入系统管理界面，1是普通用户，进入普通用户界面，能够进行借书还书操作
     *
     * @return grade - 0是超级管理员：能够进入系统管理界面，1是普通用户，进入普通用户界面，能够进行借书还书操作
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置0是超级管理员：能够进入系统管理界面，1是普通用户，进入普通用户界面，能够进行借书还书操作
     *
     * @param grade 0是超级管理员：能够进入系统管理界面，1是普通用户，进入普通用户界面，能够进行借书还书操作
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}