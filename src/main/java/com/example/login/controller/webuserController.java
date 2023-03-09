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
public class webuserController {

    @Resource
    UserService userService;
    UserBean UserBean;
    UsersBean usersBean;

    @GetMapping("/templates")
    // @Autowired
    //private UserMapper userMapper;


    @RequestMapping("/qwe")
    public String qwe(){
        return "webmain";
    }
}
