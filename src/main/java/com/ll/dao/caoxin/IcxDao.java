package com.ll.dao.caoxin;

import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.caoxin.WoDeProject;
import com.ll.pojo.lin.Procedures;
import com.ll.pojo.lin.ShenQing;
import com.ll.pojo.lin.WorkTree;
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
    @Select("select count(*) from ll_shenqing   where proceType=0 ")
    Long tctota(ShenQing shengqing);

    @Select("SELECT t.*, (SELECT  GROUP_CONCAT(c.roletext)  FROM  ll_role c  WHERE  FIND_IN_SET(c.roleid,t.procerole)) AS  roletext FROM ll_shenqing t  WHERE t.proceType=0   LIMIT #{start},#{end}")
    List<ShenQing> queryCaogao(@Param("shengqing") ShenQing shengqing,@Param("start") Integer offset, @Param("end")Integer limit);

    //申请表已提交
    @Select("select count(*) from ll_shenqing  where proceType=1")
    Long tctotas(ShenQing shengqing);

    @Select("SELECT t.*, (SELECT  GROUP_CONCAT(c.roletext)  FROM  ll_role c  WHERE  FIND_IN_SET(c.roleid,t.procerole)) AS  roletext FROM ll_shenqing t  WHERE t.proceType=1   LIMIT #{start},#{end}")
    List<ShenQing> queryshen(@Param("shengqing") ShenQing shengqing,@Param("start") Integer offset, @Param("end")Integer limit);

    @Update("update ll_shenqing set proceType= 1 where proceid=#{ proceid}")
    void updateProce(@Param("proceid") String proceid);

    @Select("SELECT t.*, (SELECT  GROUP_CONCAT(c.roletext)  FROM  ll_role c  WHERE  FIND_IN_SET(c.roleid,t.procerole)) AS  roletext FROM ll_shenqing t   where proceid=#{proceid}")
    ShenQing xiangqing(@Param("proceid")String proceid);


    @Select("select *  from ll_shenqing where proceid=#{proceid}")
    ShenQing tongguo(@Param("proceid")String proceid);

    @Update("update ll_shenqing set shenhetongguo=#{shenhetongguo},procerole=#{procerole} where proceid=#{proceid}")
    void updatepro(ShenQing shen2);
    @Select("SELECT t.*, (SELECT  GROUP_CONCAT(c.roletext)  FROM  ll_role c  WHERE  FIND_IN_SET(c.roleid,t.procerole)) AS  roletext FROM ll_shenqing t  WHERE t.proceType=1")
    List<ShenQing> queryShenqing();
    @Select("SELECT t.*, (SELECT  GROUP_CONCAT(c.roletext)  FROM  ll_role c  WHERE  FIND_IN_SET(c.roleid,t.procerole)) AS  roletext FROM ll_shenqing t  WHERE t.proceType=0")
    List<ShenQing> queryCaoGao();
    @Update("update ll_shenqing set shenhetongguo=#{shenhetongguo},procerole=#{procerole} where proceid=#{proceid}")
    void updatebohui(ShenQing shen);
    @Select("select *  from ll_role ")
    List<Procedures> queryrole();
    @Update("update ll_shenqing set  procerole=#{procerole}  where proceid=#{proceid}")
    void updatePro(ShenQing shen);
    @Select("select * from ll_workTree")
    List<WorkTree> queryListTree();
    @Select("SELECT t.*, (SELECT  GROUP_CONCAT(c.roletext) FROM ll_role c  WHERE  FIND_IN_SET(c.roleid,t.procerole)) AS  roletext ,lw.`dengji`,lw.`woname` FROM ll_shenqing t ,ll_workname lw WHERE t.proceType=1 AND t.`woid`=lw.`woid` AND lw.dengji=1")
    List<ShenQing> queryLiuChang1();
    @Select("SELECT t.*, (SELECT  GROUP_CONCAT(c.roletext) FROM ll_role c  WHERE  FIND_IN_SET(c.roleid,t.procerole)) AS  roletext ,lw.`dengji`,lw.`woname` FROM ll_shenqing t ,ll_workname lw WHERE t.proceType=1 AND t.`woid`=lw.`woid` AND lw.dengji=2")
    List<ShenQing> queryLiuChang2();
    @Select("SELECT t.*, (SELECT  GROUP_CONCAT(c.roletext) FROM ll_role c  WHERE  FIND_IN_SET(c.roleid,t.procerole)) AS  roletext ,lw.`dengji`,lw.`woname` FROM ll_shenqing t ,ll_workname lw WHERE t.proceType=1 AND t.`woid`=lw.`woid` AND lw.dengji=3")
    List<ShenQing> queryLiuChang3();
    @Select("SELECT t.*, (SELECT  GROUP_CONCAT(c.roletext) FROM ll_role c  WHERE  FIND_IN_SET(c.roleid,t.procerole)) AS  roletext ,lw.`dengji`,lw.`woname` FROM ll_shenqing t ,ll_workname lw WHERE t.proceType=1 AND t.`woid`=lw.`woid` AND lw.dengji=4")
    List<ShenQing> queryLiuChang4();
}
