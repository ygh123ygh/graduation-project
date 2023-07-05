package com.example.login.entity;

import lombok.Data;

@Data
public class yvyBean {
    private Integer yvyid;
    private Integer userid;
    private Integer docid;

    @Override
    public String toString() {
        return "yvyBean{" +
                "yvyid=" + yvyid +
                ", userid=" + userid +
                ", docid=" + docid +
                ", username='" + username + '\'' +
                ", docname='" + docname + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    private String username;
    private String docname;
    private String time;
    private String status;
    private String subject;


}
