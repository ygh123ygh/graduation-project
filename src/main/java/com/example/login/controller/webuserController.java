package com.example.login.controller;
import com.example.login.entity.UserBean;
import com.example.login.entity.chufBean;
import com.example.login.entity.yvyBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.example.login.service.WebmianService;

import java.util.List;

@Slf4j
@Controller
public class webuserController {

    @Resource
    WebmianService webmainService;
    UserBean UserBean;


    @GetMapping("/templates")
    // @Autowired
    //private UserMapper userMapper;


    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String qwe(HttpServletRequest request){

        Integer  ids  = (Integer) request.getSession().getAttribute("ids");

        request.setAttribute("id",ids);
        return "webuser/webmain";
    }
    @RequestMapping(value = "/chat",method = RequestMethod.GET)
    public String chat(HttpServletRequest request){
        Integer  ids  = (Integer) request.getSession().getAttribute("ids");

        request.setAttribute("id",ids);
        return "chatbox";
    }
    @RequestMapping(value = "/yvyve",method = RequestMethod.GET)
    public String yvyve(HttpServletRequest request, String subject){
        Integer  ids  = (Integer) request.getSession().getAttribute("ids");
        List docter =  webmainService.department(subject);
        request.setAttribute("doc",docter);

        System.out.println(docter);
        System.out.println(docter.size());
        return "webuser/yvyve";
    }
    @RequestMapping(value = "/yvy",method = RequestMethod.GET)
    public String yvy(){
        return "webuser/yvyve";

    }
    @RequestMapping(value = "/yvyve_add",method = RequestMethod.POST)
    public String addyvy(
            Integer  yvyid,Integer  userid, String username, Integer  docid,
            String docname,String subject,String time,String status,HttpServletRequest request){

        System.out.println(yvyid+userid+username+docid+docname+subject+time+status);
        boolean yvy= webmainService.yvyadd(yvyid,userid,username,docid,docname,subject,time,status);
        request.getSession().setAttribute("aa",yvy);
        if(yvy){

            request.getSession().setAttribute("msg","预约成功");

        }else {
            request.getSession().setAttribute("msg","预约失败");

        }
        System.out.println("cs"+yvy);
        return "redirect:/index";

    }

//    用户
@RequestMapping(value = "/user_yvy",method = RequestMethod.GET)
public String useryvy(HttpServletRequest request, Model model ){
    Integer  ids  = (Integer) request.getSession().getAttribute("ids");
    List<yvyBean>  userBean = webmainService.useryvy(ids);
    System.out.println(userBean);
    System.out.println(ids);
    String name  = (String) request.getSession().getAttribute("name");



    request.setAttribute("ids",ids);
    request.setAttribute("name",name);
    request.setAttribute("user",userBean);

    return "webuser/myyvy";
}
    @RequestMapping(value = "/user_chuf",method = RequestMethod.GET)
    public String userchuf(HttpServletRequest request, Model model ){
        Integer  ids  = (Integer) request.getSession().getAttribute("ids");
    List<chufBean>  userBean = webmainService.userchuf(ids);
    System.out.println(userBean);
        System.out.println(ids);

    request.setAttribute("account",ids);

    request.setAttribute("user",userBean);

        return "webuser/mychuf";
    }
    @RequestMapping(value = "/usercf",method = RequestMethod.GET)
    public String usercf(HttpServletRequest request){
   String status = "1";
        Integer  userid  = (Integer) request.getSession().getAttribute("ids");
   System.out.println(userid);
        boolean yvy= webmainService.usercf(userid,status);
        request.getSession().setAttribute("aa",yvy);
        if(yvy){

            request.getSession().setAttribute("msg","编辑成功");

        }else {
            request.getSession().setAttribute("msg","编辑失败");

        }
        System.out.println("cs"+yvy);
        return "redirect:/user_chuf";

    }
}
