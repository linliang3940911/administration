package com.ll.dao.lin;

import com.ll.pojo.caoxin.User;
import com.ll.pojo.lin.*;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/8 0008$ 21:16$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/8 0008$ 21:16$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Mapper
public interface IModelDao {
    @Select("select text from lin_users where id=1 ")
    String querymodle();
    @Select("select * from ll_workTree where pid=#{id} ")
    List<WorkTree> getQueryTree(Integer id);

    @Select("select * from ll_workname  LIMIT #{offset},#{limit}")
    List<WorkName> queryWork(@Param("offset") int offset, @Param("limit")int limit,@Param("workName") WorkTree  workName);
    @Select("select count(*) from ll_workname ")
    long queryCount( WorkTree  workName);

    @Select("select * from ll_workname where workType=#{workName.url} LIMIT #{offset},#{limit}")
    List<WorkName> queryWorks(@Param("offset")int offset,@Param("limit") int limit,@Param("workName") WorkTree  workName);
    @Select("select count(*) from ll_workname  where workType=#{workName.url}")
    long queryCounts(@Param("workName")WorkTree  workName);
    @Insert("INSERT into ll_attribute values(#{attribute1.attributeid},#{attribute1.attributename},#{attribute1.attributeType}) ")
    void commseiForm(@Param("attribute1")Attribute attribute1);
    @Insert("INSERT into ll_nameAttribute(name,attributeid) values(#{woid},#{replace})")
    void addNameAttributeid(@Param("woid")String woid,@Param("replace") String replace);
    @Select("select * from ll_role")
    List<Procedures> queryProcedurelist();
    @Insert("INSERT into ll_workname(woid,woname,workType) values(#{woid},#{woname},#{workType})")
    void addWorkName(WorkName workName);
    @Select("select b.attributeid,b.attributename,b.attributeType from ll_workname a,ll_attribute b,ll_nameattribute  c where c.name=a.woid and c.attributeid=b.attributeid and c.name=#{workName.woid}")
    List<Attribute>  application(@Param("workName") WorkName workName);
    @Select("select * from ll_workname where woid=#{woid}")
    WorkName addshenqingliycheng(@Param("woid") String woid);
    @Insert("INSERT into ll_ShenQing(proceid,procedate,procerole,proceuser,proceType,userid,woid) values(#{shenQing.proceid},now(),#{shenQing.procerole},#{shenQing.proceuser},#{shenQing.proceType},#{shenQing.userid},#{shenQing.woid})")
    void addshenqingliychengs(@Param("shenQing") ShenQing shenQing);

    @Select("select * from ll_wangpan where pid=#{wangpan.id} LIMIT #{offset},#{limit}")
    List<Wangpan> querylistWangPan(@Param("offset") int offset,@Param("limit") int limit,@Param("wangpan")  Wangpan wangpan);
    @Select("select count(*) from ll_wangpan where pid=#{wangpan.id}")
    long querycon(@Param("wangpan") Wangpan wangpan);
    @Insert("INSERT into ll_wangpan(text,upddate,allname,pid,url) values(#{wangpan.text},#{wangpan.upddate},#{wangpan.allname},#{wangpan.id},#{wangpan.url})")
    void addpackages(@Param("wangpan") Wangpan wangpan);
    @Insert("INSERT into ll_wangpan(text,upddate,allname,pid,url) values(#{wangpan.text},#{wangpan.upddate},#{wangpan.allname},#{wangpan.pid},#{wangpan.url})")
    void adduploadFile(@Param("wangpan")Wangpan wangpan);
    @Select("select * from kaoqinji a where userid=#{userid} and DATE_FORMAT(a.amupdakashijian,'2018-%m-%d')=#{format}")
    KaoQinJi queryUserList(@Param("userid") String userid, Date date, @Param("format")String format);
    @Update(" update kaoqinji a set a.pmdowndakashijian=now() where a.userid=#{replace} and DATE_FORMAT(a.amupdakashijian,'2018-%m-%d')=#{format}")
    void updateKaoQinJi(@Param("KaoQinJi")KaoQinJi kaoQinJi,@Param("replace")String replace,@Param("format")String format);
    @Insert("INSERT into kaoqinji(kaoqinid,amupdakashijian,userid) values(#{KaoQinJi.kaoqinid},now(),#{KaoQinJi.userid})")
    void addTime(@Param("KaoQinJi")KaoQinJi kaoQinJi);
    @Select("select DATE_FORMAT(a.amupdakashijian,'%d') signDay from kaoqinji a where a.userid=#{userid}")
    List<KaoQinJi> queryKaoqinji(@Param("userid") String userid);
    @Select("select *  from user a ,ll_role b where a.userrole=b.roleid and a.userid=#{userid}")
    User geren(@Param("userid") String userid);
    @Select("select *  from ll_wangpan a where pid=#{pid}")
    Wangpan queryWangpan1(@Param("pid") String pid);
    @Select("select * from ll_wangpan where pid=#{pid} LIMIT #{offset},#{limit}")
    List<Wangpan> querylistWangPans(@Param("offset") int offset,@Param("limit") int limit,@Param("pid") String pid);
    @Delete(" delete from ll_wangpan where id=#{wangpan.id}")
    void deleteByIdWangPan(@Param("wangpan") Wangpan wangpan);
}
