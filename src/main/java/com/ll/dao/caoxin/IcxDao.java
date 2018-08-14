package com.ll.dao.caoxin;

import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.caoxin.WoDeProject;
import com.ll.pojo.lin.ShenQing;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface IcxDao {
    @Select("select * from WoDeProject")
    List<WoDeProject> queryList();
    @Delete("delete from Caogao where xiangid in (#{ids})")
    void deleteCaogao(@Param(value = "ids")String ids);

    @Insert("insert into Caogao  values (#{xiangid},#{bianhao},#{biaoti},#{fenlei},#{liuchang},now())")
    void insertorig(Caogao caogao);
    @Select("SELECT * FROM USER t WHERE t.username=#{username}")
    User queryUserByName(@Param("username")String username);
    @Insert("insert into user  values (#{userid},#{username},#{usersex},#{userbirth},#{userphone},#{userofficephone},#{userqq},#{usermailbox},#{useraddress},#{qiyeweixinhao},#{userimg},#{pwd})")
    void insertUser(User user);
    @Select("SELECT * FROM USER t WHERE t.userid=#{userid}")
    User geren(String userid);

    //申请表未提交
    @Select("select count(*) from ll_shenqing ls,ll_role lr  where proceType=0 AND lr.roleid=ls.procerole ")
    Long tctota(ShenQing shengqing);
    @Select("select ls.*,lr.roletext from ll_shenqing ls,ll_role lr  where proceType=0 AND lr.roleid=ls.procerole LIMIT #{start},#{end}")
    List<ShenQing> queryCaogao(@Param("shengqing") ShenQing shengqing,@Param("start") Integer offset, @Param("end")Integer limit);



    //申请表已提交
    @Select("select count(*) from ll_shenqing ls,ll_role lr  where proceType=1 AND lr.roleid=ls.procerole")
    Long tctotas(ShenQing shengqing);
    @Select("select ls.*,lr.roletext from ll_shenqing ls,ll_role lr  where proceType=1 AND lr.roleid=ls.procerole LIMIT #{start},#{end}")
    List<ShenQing> queryshen(@Param("shengqing") ShenQing shengqing,@Param("start") Integer offset, @Param("end")Integer limit);
    @Update("update ll_shenqing set proceType= 1 where proceid=#{ proceid}")
    void updateProce(@Param("proceid") String proceid);
}
