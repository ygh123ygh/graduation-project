package com.example.login.controller;

import com.example.login.entity.UserBean;
import com.example.login.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.plugin.dom.core.Element;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class loginController {



        //将Service注入Web层
        @Resource
        UserService userService;
    @GetMapping("/templates")
        //实现登录
        @RequestMapping("/login")
        public String show(){
            return "login";
        }

        @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
        public String login(String account,String password,HttpServletRequest request){
            UserBean userBean = userService.LoginIn(account, password) ;
            //System.out.println(userBean.getName());
            //System.out.println(userBean.getStatus());
            log.info("account:{}",account);
            log.info("password:{}",password);
            //log.info("name:{}",userBean.getName());
            if(userBean!=null){

                request.getSession().setAttribute("name",userBean.getName());
                request.getSession().setAttribute("role",userBean.getRole());
                request.getSession().setAttribute("status",userBean.getStatus());
                request.getSession().setAttribute("account",userBean.getAccount());
            String  aa  = (String) request.getSession().getAttribute("name");
                request.setAttribute("aa",aa);
                return "main";

            }else {
                request.setAttribute("msg", "登录失败");
                return "login";
            }

        }




    @RequestMapping("/sighup")
        public String disp(){
            return "signUp";
        }

        //实现注册功能
        @RequestMapping(value = "/register",method = RequestMethod.POST)
        public String signUp(String account, String role, String name, String password, HttpServletRequest request){
       boolean a = userService.Insert(account, password,name,role);
       System.out.println(a);
           if(a){
               request.setAttribute("msg", "注册成功！！！");

           }else {
               request.setAttribute("msg", "注册失败");

           }
            return "login";


        }



}
