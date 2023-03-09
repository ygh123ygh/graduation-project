package com.example.login.entity;

public class UsersBean {
    private Integer id;
    private String name;
    private String age;
    private String sex;
    private String phone;
    private String live;

    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    private String born;


    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLive() {
        return live;
    }

    public void setLive(String live) {
        this.live = live;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
