package com.example.login.service;
import com.example.login.entity.yvyBean;
import com.example.login.mapper.webmainMapper;
import org.springframework.stereotype.Service;
import com.example.login.entity.chufBean;
import javax.annotation.Resource;
import java.util.List;
import com.example.login.mapper.chufMapper;

@Service
public class ChufService {
    @Resource
    private chufMapper chufMapper;
    public boolean chufadd(Integer  cfid,String zduan,Integer docid,String docname,Integer  userid,
                           String username,String userage,String usersex,String subject,String ziliao, String chuf,String time,String status){
        try {
            chufMapper.add_chuf(cfid,zduan,docid,docname,userid,username,userage,usersex,subject,ziliao,
                    chuf,time,status);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public boolean chfup(Integer  cfid,String zduan,Integer docid,String docname,Integer  userid,
    String username,String userage,String usersex,String subject,String ziliao, String chuf,String time,String status){
        try {
            chufMapper.up_chuf(cfid,zduan,docid,docname,userid,username,userage,usersex,subject,ziliao,
            chuf,time,status);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public List<chufBean> findchuf(String account) {
        return  chufMapper.findchuf(account);
    }
}
