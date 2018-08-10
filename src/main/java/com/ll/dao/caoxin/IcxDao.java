package com.ll.dao.caoxin;

import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.WoDeProject;
import org.apache.ibatis.annotations.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Mapper
public interface IcxDao {
    @Select("select * from WoDeProject")
    List<WoDeProject> queryList();

    @Delete("delete from Caogao where xiangid in (#{ids})")
    void deleteCaogao(@Param(value = "ids")String ids);



    @Select("select count(*) from Caogao")
    Long tctota(Caogao caogao);
    @Select("select * from Caogao where 1=1  LIMIT #{start},#{end}")
    List<Caogao> queryCaogao(@Param(value = "caogao") Caogao caogao,@Param(value = "start") Integer offset, @Param(value = "end")Integer limit);
    @Insert("insert into Caogao(xiangid,bianhao,biaoti,fenlei,liuchang,bianjishiqi) values (#{xiangid},#{bianhao},#{biaoti},#{fenlei},#{liuchang},#{bianjishiqi})")
    void insertorig(Caogao caogao);
}
