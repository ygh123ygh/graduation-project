package com.example.login.mapper;

import com.example.login.entity.MedicineBean;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface MedicineMapper {
    @Select("SELECT * FROM  medicine ")
    List<MedicineBean> findallmdicine( );

    @Insert("insert into medicine(id,name,taste,effect,dosage,taboo)values(#{id},#{name},#{taste},#{effect},#{dosage},#{taboo})")
    void med_add(@Param("id") Integer id, @Param("name") String name, @Param("taste") String taste,
             @Param("effect") String effect, @Param("dosage") String dosage, @Param("taboo") String taboo);


    @Update("update medicine set name=#{name},taste=#{taste},effect=#{effect},dosage=#{dosage},taboo=#{taboo} WHERE id=#{id}")
    void med_update(@Param("id") Integer id, @Param("name") String name, @Param("taste") String taste,
                    @Param("effect") String effect, @Param("dosage") String dosage, @Param("taboo") String taboo);
    @Delete("delete from medicine where id=#{id}")
    void med_del(@Param("id") Integer id);
}
