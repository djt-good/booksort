package com.wz.domain;

import javax.persistence.*;

public class Book {
    @Id
    private Integer bid;

    /**
     * 书名
     */
    private String bookname;

    /**
     * 作者
     */
    private String author;

    /**
     * 详情
     */
    private String detail;

    /**
     * 书的状态分为两种，第一种是存在1，第二种是被借0
     */
    private Integer num;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 类别
     */
    private String category;

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
     * 获取书名
     *
     * @return bookname - 书名
     */
    public String getBookname() {
        return bookname;
    }

    /**
     * 设置书名
     *
     * @param bookname 书名
     */
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取详情
     *
     * @return detail - 详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置详情
     *
     * @param detail 详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取书的状态分为两种，第一种是存在1，第二种是被借0
     *
     * @return num - 书的状态分为两种，第一种是存在1，第二种是被借0
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置书的状态分为两种，第一种是存在1，第二种是被借0
     *
     * @param num 书的状态分为两种，第一种是存在1，第二种是被借0
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取价格
     *
     * @return price - 价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 设置价格
     *
     * @param price 价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取类别
     *
     * @return category - 类别
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置类别
     *
     * @param category 类别
     */
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", detail='" + detail + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}