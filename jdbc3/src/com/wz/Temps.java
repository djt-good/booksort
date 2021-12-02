package com.wz;

import java.util.Date;

public class Temps {
   private String id;
    private String name;
    private String  sex;
    private Date birth;
    private Double  salary;
    private Integer  deptId;

    public Temps(String id) {
        this.id = id;
    }

    public Temps(String id, String name, String sex, Date birth, Double salary, Integer deptId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.salary = salary;
        this.deptId = deptId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Temps() {
    }

    @Override
    public String toString() {
        return "Temps{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth=" + birth +
                ", salary=" + salary +
                ", deptId=" + deptId +
                '}';
    }
}
