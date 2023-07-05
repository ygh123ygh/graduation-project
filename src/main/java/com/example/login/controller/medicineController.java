package com.example.login.controller;

import com.example.login.service.medicineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
public class medicineController {
    @Resource
    medicineService medicineService;
    @GetMapping("/templates")


    @RequestMapping(value = "/med",method = RequestMethod.GET)
    public String med(HttpServletRequest request){
        List  med =  medicineService.findallmdicine( );

        // log.info("account2:{}",userBean.toArray());
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",med);

        return "medicine/medicine";
    }
    @RequestMapping(value = "/meds",method = RequestMethod.GET)
    public String meds(HttpServletRequest request){
        List  med =  medicineService.findallmdicine( );
        boolean  aa = (boolean) request.getSession().getAttribute("aa");
        String  msg  = (String) request.getSession().getAttribute("msg");
        request.setAttribute("a",aa);
        request.setAttribute("msg",msg);
        // log.info("account2:{}",userBean.toArray());
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",med);

        return "medicine";
    }
    @RequestMapping(value = "/medadd",method = RequestMethod.POST)
    public String medadd(Integer id, String name, String taste, String effect,String dosage,String taboo,HttpServletRequest request){
        boolean a = medicineService.med_add(id,name,taste,effect,dosage,taboo);

        log.info("判断:{}",a);
        log.info("测试:{}",taboo);
        request.getSession().setAttribute("aa",a);
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);

        if(a){

            request.getSession().setAttribute("msg","添加成功");

        }else {
            request.getSession().setAttribute("msg","添加失败");

        }

        return "redirect:/meds";

    }
    @RequestMapping(value = "/medup",method = RequestMethod.POST)
    public String medup(Integer id, String name, String taste, String effect,String dosage,String taboo,HttpServletRequest request){
        boolean a = medicineService.med_up(id,name,taste,effect,dosage,taboo);

        log.info("判断:{}",a);
        log.info("测试:{}",taboo);
        request.getSession().setAttribute("aa",a);

        if(a){

            request.getSession().setAttribute("msg","编辑成功");

        }else {
            request.getSession().setAttribute("msg","编辑失败");

        }
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        return "redirect:/meds";

    }
    @RequestMapping(value = "/med_del",method = RequestMethod.GET)
    public String doc_del(Integer id,HttpServletRequest request){
        boolean a = medicineService.med_del( id );
        System.out.println(id);
        System.out.println(a);

        request.getSession().setAttribute("aa",a);
        if(a){
            request.getSession().setAttribute("msg","删除成功");

        }else {
            request.getSession().setAttribute("msg","删除失败");

        }
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        return "redirect:/meds";


    }
}
