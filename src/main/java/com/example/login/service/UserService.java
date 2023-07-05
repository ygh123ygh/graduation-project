package com.example.login.service;

import com.example.login.entity.UserBean;
import com.example.login.entity.UsersBean;
import com.example.login.entity.docBean;
import com.example.login.mapper.UserMapper;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {
    //将dao层属性注入service层
    @Resource
    private UserMapper userMapper;

    public UserBean LoginIn( String account, String password) {

        return userMapper.getInfo(account, password);
    }
    public UsersBean userLoginIn( Integer id, String phone) {

        return userMapper.userInfo(id, phone);
    }
    public boolean Insert(String account, String password, String name, String role) {
        try {
            userMapper.saveInfo(account, password, name, role);
            return true;
        } catch (Exception e){
            return false;
        }


    }
    public List<UserBean> findall() {

        return  userMapper.findall();
    }
    public List<docBean> findall2() {

        return  userMapper.findall2();
    }

    public boolean addmainss(String account, String password, String name, String role, String status,String time) {
        try {
            userMapper.add(account, password, name, role,status,time);
            return true;
        } catch (Exception e){
            return false;
        }


    }

    public UserBean findid(String account ){

        return  userMapper.findid(account);
    }

    public boolean update(String account, String password, String name, String role, String status, String time){

        try {
            userMapper.login_update(account, password, name, role,status,time);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public boolean docup(String account, String name, String age, String sex,String email,String duty,String subject,String status){

        try {
            userMapper.doc_update(account,name,age,sex,email,duty,subject,status);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public boolean docadd(String account, String name, String age, String sex,String email,String duty,String subject,String status){

        try {
            userMapper.doc_add(account,name,age,sex,email,duty,subject,status);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public boolean doc_dele(String account ){
        try {
            userMapper.doc_delete(account);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public List<docBean> finddoc(String account ){

        return  userMapper.finddoc(account);
    }
    public boolean dele(String account ){
        try {
            userMapper.delete(account);
            return true;
        } catch (Exception e){
            return false;
        }

    }
    public List<UserBean> sele(String name){

        return  userMapper.selmoh(name);
    }
    //用户
    public List<UsersBean> findall3() {

        return  userMapper.findall3();
    }

    public boolean user_update(Integer id, String name, String age, String sex,String phone,String live,String born,String status){

        try {
            userMapper.user_update(id,name,age,sex,phone,live,born,status);
            return true;
        } catch (Exception e){
            return false;
        }
    }
    public boolean user_add(Integer id, String name, String age, String sex,String phone,String live,String born,String status){

        try {
            userMapper.user_add(id,name,age,sex,phone,live,born,status);
            return true;
        } catch (Exception e){
            return false;
        }

    }
   public boolean user_dele(Integer id ){
        try {
            userMapper.user_delete(id);
            return true;
        } catch (Exception e){
            return false;
        }

    }


}
