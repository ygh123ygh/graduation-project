package com.example.login.entity;

import lombok.Data;

@Data
public class chufBean {
    private String zduan;

    @Override
    public String toString() {
        return "chufBean{" +
                "zduan='" + zduan + '\'' +
                ", docname='" + docname + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", username='" + username + '\'' +
                ", userage='" + userage + '\'' +
                ", usersex='" + usersex + '\'' +
                ", ziliao='" + ziliao + '\'' +
                ", cfid=" + cfid +
                ", docid=" + docid +
                ", userid=" + userid +
                '}';
    }

    private String docname;
    private String time;
    private String status;
    private String username;
    private String userage;
    private String usersex;
    private String ziliao;
    private Integer cfid;
    private Integer docid;
    private Integer userid;
    private String chuf;
    private String subject;
}
