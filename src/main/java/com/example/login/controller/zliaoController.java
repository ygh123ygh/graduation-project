package com.example.login.controller;
import com.example.login.entity.chufBean;
import com.example.login.entity.yvyBean;
import com.example.login.service.ChufService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.example.login.service.WebmianService;

import java.util.List;
@Slf4j
@Controller
public class zliaoController {
    @Resource
    WebmianService webmainService;
    @Resource
    ChufService chufService;

    @RequestMapping(value = "/zliao_yvy",method = RequestMethod.GET)
    public String yvyall(HttpServletRequest request, Model model ){
        String  id  = (String) request.getSession().getAttribute("account");
        List<yvyBean>  userBean = webmainService.findyvy( id);
        System.out.println(userBean);
        String name  = (String) request.getSession().getAttribute("name");
        String  role  = (String) request.getSession().getAttribute("role");

        request.setAttribute("role",role);
        request.setAttribute("account",id);
        request.setAttribute("name",name);
        request.setAttribute("user",userBean);

        return "diagnosis/yvyall";
    }

    @RequestMapping(value = "/yvyve_eitd",method = RequestMethod.POST)
    public String yvyup(
            Integer  yvyid,Integer  userid, String username, Integer  docid,
            String docname,String subject,String time,String status,HttpServletRequest request){
        System.out.println(yvyid+userid+username+docid+docname+subject+time+status);
        boolean yvy= webmainService.yvyup(yvyid,userid,username,docid,docname,subject,time,status);
        request.getSession().setAttribute("aa",yvy);
        if(yvy){

            request.getSession().setAttribute("msg","编辑成功");

        }else {
            request.getSession().setAttribute("msg","编辑失败");

        }
        System.out.println("cs"+yvy);
        return "redirect:/zliao_yvy";

    }
    @RequestMapping(value = "/yvy_del",method = RequestMethod.GET)
    public String user_del(Integer yvyid,HttpServletRequest request){
        boolean a = webmainService.yvy_del( yvyid );
        System.out.println(yvyid);
        System.out.println(a);
        request.getSession().setAttribute("aa",a);
        if(a){
            request.getSession().setAttribute("msg","删除成功");

        }else {
            request.getSession().setAttribute("msg","删除失败");

        }

        return "redirect:/zliao_yvy";


    }
    @RequestMapping(value = "/yvy_upstatus",method = RequestMethod.GET)
    public String yvyupstatus( Integer yvyid,String status,HttpServletRequest request){
        System.out.println(status);
        System.out.println(yvyid);
        boolean yvy= webmainService.yvyupstatus(yvyid,status);
        request.getSession().setAttribute("aa",yvy);
        if(yvy){

            request.getSession().setAttribute("msg","编辑成功");

        }else {
            request.getSession().setAttribute("msg","编辑失败");

        }
        System.out.println("cs"+yvy);
        return "yvy";

    }
//处方
    @RequestMapping(value = "/zliao_chuf",method = RequestMethod.GET)
    public String chuf( HttpServletRequest request){
        String  account  = (String) request.getSession().getAttribute("account");
        List chuBean = chufService.findchuf(account);
        System.out.println(chuBean);
        String name  = (String) request.getSession().getAttribute("name");
        String  role  = (String) request.getSession().getAttribute("role");

        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("name",name);
        request.setAttribute("user",chuBean);
        return "diagnosis/chuf";
    }

    @RequestMapping(value = "/zliao_addchuf",method = RequestMethod.POST)
    public String addchuf( Integer  cfid,Integer  userid, String username, Integer  docid,
                        String docname,String subject,String zduan,String status,String yvystatus,String userage,
                        String usersex,String ziliao,String chuf,String time,Integer  yvyid,HttpServletRequest request){
        boolean a = chufService.chufadd(cfid,zduan,docid,docname,userid,username,userage,usersex,subject,ziliao,
                chuf,time,status);
        System.out.println(cfid); System.out.println(userid); System.out.println(username); System.out.println(zduan);
        System.out.println(a);

        boolean yvy= webmainService.yvyupstatus(yvyid,yvystatus);
        System.out.println(yvyid);
        System.out.println(yvystatus);
        request.getSession().setAttribute("aa",a);
//        if(a){
//            request.getSession().setAttribute("msg","编辑成功");
//
//        }else {
//            request.getSession().setAttribute("msg","编辑失败");
//
//        }
        return "redirect:/zliao_yvy";
    }
    @RequestMapping(value = "/chuf_eitd",method = RequestMethod.POST)
    public String chuup(Integer  cfid,Integer  docid, String zduan, Integer  userid,
                        String docname,String subject,String time,String status,
                        String username,String userage,String usersex,String chuf,
                        String ziliao,HttpServletRequest request){

        boolean yvy= chufService.chfup(cfid,zduan,docid,docname,userid,username,userage,usersex,subject,ziliao,
                chuf,time,status);
        request.getSession().setAttribute("aa",yvy);
        if(yvy){

            request.getSession().setAttribute("msg","编辑成功");

        }else {
            request.getSession().setAttribute("msg","编辑失败");

        }
        System.out.println("cs"+yvy);
        return "redirect:/zliao_chuf";

    }

}
