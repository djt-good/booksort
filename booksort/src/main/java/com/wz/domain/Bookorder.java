package com.wz.domain;

import javax.persistence.*;

public class Bookorder {
    @Id
    private Integer orderid;

    private Integer rid;

    private Integer bid;

    private Integer orderstatus;

    private Integer num;

    /**
     * @return orderid
     */
    public Integer getOrderid() {
        return orderid;
    }

    /**
     * @param orderid
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * @return rid
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * @param rid
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * @return bid
     */
    public Integer getBid() {
        return bid;
    }

    /**
     * @param bid
     */
    public void setBid(Integer bid) {
        this.bid = bid;
    }

    /**
     * @return orderstatus
     */
    public Integer getOrderstatus() {
        return orderstatus;
    }

    /**
     * @param orderstatus
     */
    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    /**
     * @return num
     */
    public Integer getNum() {
        return num;
    }

    /**
     * @param num
     */
    public void setNum(Integer num) {
        this.num = num;
    }
}