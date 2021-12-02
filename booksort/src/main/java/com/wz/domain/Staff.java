package com.wz.domain;

import javax.persistence.*;

public class Staff {
    @Id
    private Integer id;

    private String name;

    private String age;

    private String phone;

    private String adders;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return adders
     */
    public String getAdders() {
        return adders;
    }

    /**
     * @param adders
     */
    public void setAdders(String adders) {
        this.adders = adders;
    }
}