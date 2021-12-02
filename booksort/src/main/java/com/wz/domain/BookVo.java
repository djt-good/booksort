package com.wz.domain;

public class BookVo {
    private Integer eid;
    private String bookname;
    private String author;
    private Integer num;
    private Integer price;
    private String category;
    private Integer orderstatus;


    public BookVo(Integer eid, String bookname, String author, Integer num, Integer price, String category, Integer orderstatus) {
        this.eid = eid;
        this.bookname = bookname;
        this.author = author;
        this.num = num;
        this.price = price;
        this.category = category;
        this.orderstatus = orderstatus;
    }

    public BookVo() {
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Integer orderstatus) {
        this.orderstatus = orderstatus;
    }

    @Override
    public String toString() {
        return "BookVo{" +
                "eid=" + eid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                ", num=" + num +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", orderstatus=" + orderstatus +
                '}';
    }
}
