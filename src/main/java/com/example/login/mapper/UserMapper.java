package com.example.login.mapper;


import com.example.login.entity.UserBean;
import com.example.login.entity.UsersBean;
import com.example.login.entity.docBean;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //查询，可以实现登录功能
    @Select("SELECT * FROM login WHERE account = #{account} AND password = #{password}")
    UserBean getInfo(@Param("account") String account, @Param("password") String password);


    @Select("SELECT * FROM login WHERE role = 1 ")
    List<UserBean>  findall( );

    @Select("SELECT * FROM users WHERE id = #{id} AND phone = #{phone}")
    UsersBean userInfo(@Param("id") Integer id, @Param("phone") String phone);



    //增加，可以实现注册功能
    @Insert("insert into login(account,password,name,role)values(#{account},#{password},#{name},#{role})")
    void saveInfo(@Param("account") String account, @Param("password") String password,
                  @Param("name") String name, @Param("role") String role);

    @Insert("insert into login(account,password,name,role,status,time)values(#{account},#{password},#{name},#{role},#{status},#{time})")
    void add(@Param("account") String account, @Param("password") String password,
             @Param("name") String name, @Param("role") String role,@Param("status") String status,@Param("time") String time);


    //@Update("UPDATE   user set password = #{password},name =#{name},role = #{role},status = #{status} WHERE" +
    // "account = #{account}")
    @Select("SELECT * FROM login WHERE account = #{account}" )
    UserBean findid(@Param("account") String account);

    @Update("update login set password=#{password},name=#{name},role=#{role},status=#{status},time=#{time} WHERE account=#{account}")
    void login_update(@Param("account") String account, @Param("password") String password,
                     @Param("name") String name, @Param("role") String role,@Param("status") String status,@Param("time") String time);




    @Delete("delete from login where account=#{account}")
    void delete(@Param("account") String account);

    //模糊查询
    @Select("SELECT * FROM login WHERE name like   CONCAT('%',#{name},'%')")
    List<UserBean> selmoh(@Param("name") String name);
    //医生
    @Select("SELECT * FROM doctor ")
    List<docBean>  findall2( );

    @Insert("insert into doctor(account,name,age,sex,email,duty,subject,status)values(#{account},#{name},#{age},#{sex},#{email},#{duty},#{subject},#{status})")
    void doc_add(@Param("account") String account,@Param("name") String name, @Param("age") String age,@Param("sex") String sex,
    @Param("email") String email,@Param("duty") String duty,@Param("subject") String subject,@Param("status") String status);


    @Update("update doctor set name=#{name},age=#{age},sex=#{sex},email=#{email},duty=#{duty},subject=#{subject},status=#{status} WHERE account=#{account}")
    void doc_update(@Param("account") String account,@Param("name") String name, @Param("age") String age,@Param("sex") String sex,
                    @Param("email") String email,@Param("duty") String duty,@Param("subject") String subject,@Param("status") String status);

    @Delete("delete from doctor where account=#{account}")
    void doc_delete(@Param("account") String account);

   /* @Insert("insert into users (account,name,age,sex,email,duty,subject,status)values(#{account},#{name},#{age},#{sex}),#{email}),#{duty}),#{subject}),#{status})")
    void user_add(@Param("account") String account,@Param("name") String name, @Param("age") String age,@Param("sex") String sex,
                  @Param("email") String email,@Param("duty") String duty,@Param("subject") String subject,@Param("status") String status);*/
   @Select("SELECT * FROM doctor WHERE account = #{account}" )
   List<docBean> finddoc(@Param("account") String account);
    //用户
    @Select("SELECT * FROM  users ")
    List<UsersBean>  findall3( );

    @Insert("insert into users(id,name,age,sex,phone,live,born,status)values(#{id},#{name},#{age},#{sex},#{phone},#{live},#{born},#{status})")
    void user_add(@Param("id") Integer id,@Param("name") String name,
                 @Param("age") String age,@Param("sex") String sex,@Param("phone") String phone
            ,@Param("live") String live,@Param("born") String born,@Param("status") String status);

    @Update("update users set name=#{name},age=#{age},sex=#{sex},phone=#{phone},live=#{live},born=#{born},status=#{status} WHERE id=#{id}")
    void user_update(@Param("id") Integer id,@Param("name") String name,@Param("age") String age,@Param("sex") String sex,@Param("phone") String phone
            ,@Param("live") String live,@Param("born") String born,@Param("status") String status);


    @Delete("delete from users where id=#{id}")
    void user_delete(@Param("id") Integer id);

    @Select("SELECT * FROM login WHERE account = #{account}" )
    UserBean finduser(@Param("id") String account);

}

