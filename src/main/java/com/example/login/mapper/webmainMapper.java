package com.example.login.mapper;
import com.example.login.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface webmainMapper {
    @Select("SELECT * FROM doctor WHERE subject = #{subject }")
    List<docBean>   department(@Param("subject") String subject);


    @Insert("insert into yvy(yvyid,userid,username,docid,docname,subject,time,status)" +
            "values(#{yvyid},#{userid},#{username},#{docid},#{docname},#{subject},#{time},#{status})")
    void add_yvy(@Param("yvyid") Integer yvyid, @Param("userid") Integer userid, @Param("user_name") String user_name,
                  @Param("docid") Integer docid, @Param("docname") String docname,
                 @Param("subject") String subject, @Param("time") String time,@Param("status") String status);

    @Update("update yvy set userid=#{userid},docid=#{docid},username=#{username},docname=#{docname}" +
            ",time=#{time},subject=#{subject},status=#{status} WHERE yvyid=#{yvyid}")
    void up_yvy(@Param("yvyid") Integer yvyid, @Param("userid") Integer userid, @Param("username") String username,
                 @Param("docid") Integer docid, @Param("docname") String docname,
                 @Param("subject") String subject, @Param("time") String time,@Param("status") String status);

    @Update("update yvy set status=#{status} WHERE yvyid=#{yvyid}")
    void upsta_yvy(@Param("yvyid") Integer yvyid,@Param("status") String status);

    @Delete("delete from yvy where yvyid=#{yvyid}")
    void del_yvy(@Param("yvyid") Integer yvyid);

    @Select("SELECT * FROM yvy WHERE docid = #{docid }")
    List<yvyBean>  findyvy( @Param("docid") String docid);
    @Select("SELECT * FROM yvy WHERE userid = #{userid }")
    List<yvyBean>  useryvy( @Param("userid") Integer userid);
    @Select("SELECT * FROM  chuf WHERE userid = #{userid }")
    List<chufBean> userchuf(@Param("userid") Integer userid);
    @Update("update chuf set status =#{status} WHERE userid =#{userid}")
    void userscf(@Param("userid") Integer userid, @Param("status") String status
    );
}
