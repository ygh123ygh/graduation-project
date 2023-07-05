package com.example.login.mapper;

import com.example.login.entity.MedicineBean;
import org.apache.ibatis.annotations.Mapper;
import com.example.login.entity.chufBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface chufMapper {
    @Insert("insert into chuf(cfid,zduan,docid,docname,userid,username,userage,usersex,subject,ziliao,chuf,time,status)" +
            "values(#{cfid},#{zduan},#{docid},#{docname},#{userid},#{username},#{userage},#{usersex}," +
            "#{subject},#{ziliao},#{chuf},#{time},#{status})")
    void add_chuf(@Param("cfid") Integer cfid, @Param("zduan") String zduan, @Param("docid") Integer docid
            , @Param("docname") String docname, @Param("userid") Integer userid, @Param("username") String username,
                  @Param("userage") String userage, @Param("usersex") String usersex,
                  @Param("subject") String subject, @Param("ziliao") String ziliao, @Param("chuf") String chuf ,
                  @Param("time") String time,
                  @Param("status") String status);


    @Update("update chuf set zduan=#{zduan},docid=#{docid},docname=#{docname},userid=#{userid}" +
            ",username=#{username},userage=#{userage},usersex=#{usersex},subject=#{subject}" +
            ",ziliao=#{ziliao},chuf=#{chuf},time=#{time},status=#{status} WHERE cfid=#{cfid}")
    void up_chuf(@Param("cfid") Integer cfid, @Param("zduan") String zduan, @Param("docid") Integer docid
             , @Param("docname") String docname, @Param("userid") Integer userid, @Param("username") String username,
                 @Param("userage") String userage, @Param("usersex") String usersex,
                 @Param("subject") String subject, @Param("ziliao") String ziliao, @Param("chuf") String chuf ,
                 @Param("time") String time,
                 @Param("status") String status
                );

    @Select("SELECT * FROM  chuf WHERE docid = #{docid }")
    List<chufBean> findchuf( @Param("docid") String docid);


}
