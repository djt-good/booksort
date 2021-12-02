package com.wz.domain;

import javax.persistence.*;

public class Reader {
    @Id
    private Integer eid;

    private String ename;

    private String phone;

    private String adders;

    /**
     * @return eid
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * @param eid
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * @return ename
     */
    public String getEname() {
        return ename;
    }

    /**
     * @param ename
     */
    public void setEname(String ename) {
        this.ename = ename;
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