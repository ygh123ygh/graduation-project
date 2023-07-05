package com.example.login.controller;
import com.example.login.entity.UserBean;
import com.example.login.entity.UsersBean;
import com.example.login.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@Controller
public class userController {

    @Resource
    UserService userService;
    UserBean UserBean;
      UsersBean usersBean;

    @GetMapping("/templates")
    // @Autowired
     //private UserMapper userMapper;


    //管理员
    @RequestMapping(value = "/admins",method = RequestMethod.GET)
    public String aadmin(HttpServletRequest request ,boolean a ){
        List  userBean =  userService.findall( );
        boolean  aa = (boolean) request.getSession().getAttribute("aa");
        String  msg  = (String) request.getSession().getAttribute("msg");
        request.setAttribute("a",aa);
        request.setAttribute("msg",msg);

        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");

        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",userBean);
        return "Administrator";
    }

   @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String show(HttpServletRequest request ,boolean a ){
     List  userBean =  userService.findall( );


        //log.info("account1:{}",userBean.get(1));
       // log.info("account2:{}",userBean.toArray());
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");

        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",userBean);

        log.info("判断:{}",a);
        return "Administrator";
    }

    //实现添加功能
    @RequestMapping(value = "/addmain",method = RequestMethod.POST)
    public String addmain(String name, String role, String account, String password,String status,String time,HttpServletRequest request){
        boolean a = userService.addmainss(account, password,name,role,status,time);
        log.info("time:{}",role);
        log.info("判断:{}",a);

        request.getSession().setAttribute("aa",a);

        if(a){

            request.getSession().setAttribute("msg","添加成功");

        }else {
            request.getSession().setAttribute("msg","添加失败");

        }

        return "redirect:/admins";

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(String name, String role, String account, String password,String status,String time, HttpServletRequest request){
        boolean a = userService.update( account ,password,name,role,status,time);
        System.out.println(time);
        request.getSession().setAttribute("aa",a);
        if(a){
            request.getSession().setAttribute("msg","预约成功");

        }else {
            request.getSession().setAttribute("msg","预约失败");

        }
        return "redirect:/admins";
    }
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public String del(String account,String role,HttpServletRequest request){
        boolean a = userService.dele( account );
        System.out.println(a);
        log.info("role:{}",role);
        request.getSession().setAttribute("aa",a);
        if(a){
            request.getSession().setAttribute("msg","删除成功");

        }else {
            request.getSession().setAttribute("msg","删除失败");

        }

        return "redirect:/admins";


    }
    @RequestMapping(value = "/sel",method = RequestMethod.POST)
    public String sel(String name,HttpServletRequest request){
        List a = userService.sele( name );
        System.out.println(a);
        request.setAttribute("user",a);
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        return "Administrator";


    }

    //医师
    @RequestMapping(value = "/doc",method = RequestMethod.GET)
    public String doc(HttpServletRequest request){
        List  userBean =  userService.findall2( );


        //log.info("account1:{}",userBean.get(1));
        // log.info("account2:{}",userBean.toArray());
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",userBean);
        System.out.println(userBean);
        return "doctor";
    }
    @RequestMapping(value = "/docs",method = RequestMethod.GET)
    public String docs(HttpServletRequest request){
        List  userBean =  userService.findall2( );

        boolean  aa = (boolean) request.getSession().getAttribute("aa");
        String  msg  = (String) request.getSession().getAttribute("msg");
        request.setAttribute("a",aa);
        request.setAttribute("msg",msg);
        //log.info("account1:{}",userBean.get(1));
        // log.info("account2:{}",userBean.toArray());
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",userBean);

        return "doctor";
    }
    @RequestMapping("/doctors")
    public String doc(){
        return "doctor";
    }
    @RequestMapping(value = "/docup",method = RequestMethod.POST)
    public String docup(String name, String account, String age, String sex,String email,String duty,String subject,String status, HttpServletRequest request){
        boolean a = userService.docup( account ,name,age,sex,email,duty,subject,status);
        System.out.println(a);
        System.out.println(account);
        System.out.println(name);
        System.out.println(age);
        System.out.println(sex);
        System.out.println(email);
        System.out.println(duty);
        System.out.println(subject);
        System.out.println(status);

        request.getSession().setAttribute("aa",a);
        if(a){
            request.getSession().setAttribute("msg","编辑成功");

        }else {
            request.getSession().setAttribute("msg","编辑失败");

        }

        return "redirect:/docs";

    }
    @RequestMapping(value = "/adddoc",method = RequestMethod.POST)
    public String adddoc(String name, String account, String age, String sex,String email,String duty,String subject,String status, HttpServletRequest request){
        boolean a = userService.docadd(account,name,age,sex,email,duty,subject,status);
        System.out.println(a);
        System.out.println(account);
        System.out.println(name);
        System.out.println(age);
        System.out.println(sex);
        System.out.println(email);
        System.out.println(duty);
        System.out.println(subject);
        System.out.println(status);
        request.getSession().setAttribute("aa",a);
        if(a){
            request.getSession().setAttribute("msg","添加成功");

        }else {
            request.getSession().setAttribute("msg","添加失败");

        }

        return "redirect:/docs";

    }
    @RequestMapping(value = "/doc_del",method = RequestMethod.GET)
    public String doc_del(String account,HttpServletRequest request){
        boolean a = userService.doc_dele( account );
        System.out.println(account);
        System.out.println(a);

        request.getSession().setAttribute("aa",a);
        if(a){
            request.getSession().setAttribute("msg","删除成功");

        }else {
            request.getSession().setAttribute("msg","删除失败");

        }

        return "redirect:/docs";


    }
    @RequestMapping("/docxx")
    public String docxx(HttpServletRequest request){
        String  account  = (String) request.getSession().getAttribute("account");
        List  userBean =  userService.finddoc( account );

        // log.info("account2:{}",userBean.toArray());
        String  role  = (String) request.getSession().getAttribute("role");

        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",userBean);
        return "docxx";
    }
    //用户
    @RequestMapping("/users")
    public String user(){
        return "redirect:/user";
    }
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String users(HttpServletRequest request){
        List  userBean =  userService.findall3( );

        // log.info("account2:{}",userBean.toArray());
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",userBean);

        return "user";
    }
    @RequestMapping(value = "/userss",method = RequestMethod.GET)
    public String userss(HttpServletRequest request){
        List  userBean =  userService.findall3( );
        boolean  aa = (boolean) request.getSession().getAttribute("aa");
        String  msg  = (String) request.getSession().getAttribute("msg");
        request.setAttribute("a",aa);
        request.setAttribute("msg",msg);
        // log.info("account2:{}",userBean.toArray());
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",userBean);

        return "user";
    }
    @RequestMapping(value = "/userup",method = RequestMethod.POST)
    public String userup(Integer id, String name, String age, String sex,String live,String born,String phone,String status, HttpServletRequest request){
        boolean a = userService.user_update( id ,name,age,sex,phone,live,born,status);
        System.out.println(a);
        System.out.println(id);
        System.out.println(name);
        System.out.println(age);
        System.out.println(sex);
        System.out.println(phone);
        System.out.println(live);
        System.out.println(born);
        System.out.println(status);

        request.getSession().setAttribute("aa",a);
        if(a){
            request.getSession().setAttribute("msg","编辑成功");

        }else {
            request.getSession().setAttribute("msg","编辑失败");

        }

        return "redirect:/userss";

    }
    @RequestMapping(value = "/useradd",method = RequestMethod.POST)
    public String adduser(Integer id, String name, String age, String sex,String live,String born,String phone,String status, HttpServletRequest request){
        boolean a = userService.user_add(id,name,age,sex,phone,live,born,status);
        System.out.println(a);
        System.out.println(id);
        System.out.println(name);
        System.out.println(age);
        System.out.println(sex);
        System.out.println(phone);
        System.out.println(live);
        System.out.println(born);
        System.out.println(status);
        request.getSession().setAttribute("aa",a);
        if(a){
            request.getSession().setAttribute("msg","添加成功");

        }else {
            request.getSession().setAttribute("msg","添加失败");

        }

        return "redirect:/userss";

    }
   @RequestMapping(value = "/user_del",method = RequestMethod.GET)
    public String user_del(Integer id,HttpServletRequest request){
        boolean a = userService.user_dele( id );
        System.out.println(id);
        System.out.println(a);
       request.getSession().setAttribute("aa",a);
       if(a){
           request.getSession().setAttribute("msg","删除成功");

       }else {
           request.getSession().setAttribute("msg","删除失败");

       }

        return "redirect:/userss";


    }

    @RequestMapping("/userxx")
    public String userxx(HttpServletRequest request){
        List  userBean =  userService.findall3( );

        // log.info("account2:{}",userBean.toArray());
        String  role  = (String) request.getSession().getAttribute("role");
        String  account  = (String) request.getSession().getAttribute("account");
        request.setAttribute("role",role);
        request.setAttribute("account",account);
        request.setAttribute("user",userBean);
        return "userxx";
    }

}
