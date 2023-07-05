package com.example.login.service;
import com.example.login.entity.*;
import com.example.login.mapper.chufMapper;
import com.example.login.mapper.webmainMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class WebmianService {
    @Resource
    private webmainMapper webmainMapper;

    public List department(String subject) {

        return   webmainMapper.department(subject);
    }

    public boolean yvyadd(Integer  yvyid,Integer  userid, String username, Integer  docid,
                          String docname,String subject,String time,String status){
        try {
            webmainMapper.add_yvy(yvyid,userid,username,docid,docname,subject,time,status);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public boolean yvyup(Integer  yvyid,Integer  userid, String username, Integer  docid,
                          String docname,String subject,String time,String status){
        try {
            webmainMapper.up_yvy(yvyid,userid,username,docid,docname,subject,time,status);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public boolean yvyupstatus(Integer yvyid,String status){
        try {
            webmainMapper.upsta_yvy(yvyid,status);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public boolean yvy_del(Integer yvyid ){
        try {
            webmainMapper.del_yvy(yvyid);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public List<yvyBean> findyvy(String id) {

        return  webmainMapper.findyvy(id);
    }

//    用户

    public List<yvyBean> useryvy(Integer ids) {

        return  webmainMapper.useryvy(ids);
    }
    public List<chufBean> userchuf(Integer ids) {
        return  webmainMapper.userchuf(ids);
    }

    public boolean usercf(Integer userid,String status){
        try {
            webmainMapper.userscf(userid,status);
            return true;
        } catch (Exception e){
            return false;
        }

    }
}
