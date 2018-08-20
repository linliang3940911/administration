package com.ll.dao.yre;

import com.ll.pojo.yre.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface YreMapper {/**
　　* @Description: TODO
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws 分页查询上下班登记(查询总条数)
　　* @author 因蓉儿
　　* @date 2018/8/11 10:45
　　*/
    @Select("select count(*) from c_commute")
    Long queryRegistrationCount(@Param("commute") Commute commute);

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws 分页查询上下班登记(查询当前页数据)
    　　* @author 因蓉儿
    　　* @date 2018/8/11 10:45
    　　*/
    @Select("select * from c_commute limit #{page},#{rows}")
    List<Commute> queryRegistrationPage(@Param("page")Integer page,@Param("rows") Integer rows,@Param("commute") Commute commute);

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws 回显说明情况
    　　* @author 因蓉儿
    　　* @date 2018/8/11 15:42
    　　*/
    @Select("select * from c_commute where commuteid = #{commuteid}")
    Commute addReasonById(String commuteid);

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws 新增说明情况
    　　* @author 因蓉儿
    　　* @date 2018/8/11 15:42
    　　*/
    @Update("update c_commute set cause = #{cause} where commuteid = #{commuteid}")
    void addReason2(Commute commute);

    @Select("select count(*) from kaoqinbanci k,user u where u.userid = k.userid and u.userid = #{userid}")
    Long queryMyScheduleCount(@Param("userid") String userid);

    @Select("select u.*,k.* from kaoqinbanci k,user u where u.userid = k.userid and u.userid = #{userid} limit #{page},#{rows}")
    List<KaoQinBanCi> queryMySchedulePage(@Param("page")Integer page,@Param("rows")Integer rows,@Param("userid") String userid);

    @Select("select count(*) from holiday h,user u where u.userid = h.userid and u.userid = #{userid}")
    Long queryMyHolidayCount(@Param("userid") String userid);

    @Select("select u.*,h.* from holiday h,user u where u.userid = h.userid and u.userid = #{userid} limit #{page},#{rows}")
    List<Holiday> queryMyHolidayPage(@Param("page")Integer page,@Param("rows") Integer rows,@Param("userid") String userid);

    @Select("select count(*) from holiday h,user u where u.userid = u.userid and u.userid = #{userid}")
    Long queryOvertimeRegistrationCount(@Param("userid") String userid);

    @Select("select u.*,jb.* from jiaban jb,user u where u.userid = jb.userid and u.userid = #{userid} limit #{page},#{rows}")
    List<JiaBan> queryOvertimeRegistrationPage(@Param("page")Integer page, @Param("rows")Integer rows,@Param("userid") String userid);

    @Select("select jb.jiabanid,jb.kaishitime,jb.jieshutime,jb.jiabanyuanyin from jiaban jb where jiabanid = #{jiabanid}")
    JiaBan queryxiangqing(@Param("jiabanid") String jiabanid);

    @Insert("insert into jiaban(jiabanid,shenqingtime,kaishitime,jieshutime,jiabanyuanyin,breakdown,userid) VALUES(#{jiabanid},#{shenqingtime},#{kaishi},#{jieshu},#{jiabanyuanyin},#{breakdown},#{userid})")
    void addOvertimeRegistration(JiaBan jiaBan);

    @Select("select count(*) from travel t,user u where u.userid = t.userid and u.userid")
    Long queryRavelRegistrationCount(@Param("userid") String userid);

    @Select("select u.*,t.* from travel t,user u where u.userid = t.userid and u.userid = #{userid} limit #{page},#{rows}")
    List<Travel> queryRavelRegistrationPage(@Param("page")Integer page,@Param("rows") Integer rows,@Param("userid") String userid);

    @Select("select t.travelid,t.kaishitime,t.jieshutime,t.travelyuanyin from travel t where travelid = #{travelid}")
    Travel queryTravelXiangQing(String travelid);
    @Insert("insert into travel(travelid,shengqingtime,kaishitime,jieshutime,placeoftravel,travelyuanyin,userid) values(#{travelid},#{shengqingtime},#{kaishi},#{jieshu},#{placeoftravel},#{travelyuanyin},#{userid})")
    void addTravelRegistration(Travel travel);

    @Select("select count(*) from kaoqinji c,user u where u.userid = c.userid and u.userid")
    Long queryKaoQinJiJiLuCount(@Param("kaoQinJi")KaoQinJi kaoQinJi);
    @Select("select u.*,c.* from kaoqinji c,user u where u.userid = c.userid limit #{page},#{rows}")
    List<KaoQinJi> queryKaoQinJiJiLuPage(@Param("page") Integer page, @Param("rows")Integer rows, @Param("kaoQinJi")KaoQinJi kaoQinJi);

    @Select("select * from department")
    List<DeptPojo> queryDeptTree();

    @Select("select count(*) FROM onduty o,kaoqinbanci k,department d,user u where u.deptid = d.deptid and o.userid = u.userid and o.banciid = k.banciid")
    Long queryOnTheJobStatusCount(@Param("onduty") Onduty onduty);

    @Select("select o.*,k.*,d.deptid,d.deptname,u.userid,u.username from onduty o,kaoqinbanci k,department d,user u where u.deptid = d.deptid and o.userid = u.userid and o.banciid = k.banciid limit #{page},#{rows}")
    List<Onduty> queryOnTheJobStatusPage(@Param("page")Integer page,@Param("rows") Integer rows,@Param("onduty") Onduty onduty);

    @Select("select count(*) from attendancestatistics a,department d,user u where a.userid = u.userid and a.deptid = d.deptid")
    Long queryAttendanceStatisticsCount(@Param("attendanceStatistics")AttendanceStatistics attendanceStatistics);

    @Select("select a.*,u.userid,u.username,d.* from attendancestatistics a,department d,user u where a.userid = u.userid and a.deptid = d.deptid limit #{page},#{rows}")
    List<AttendanceStatistics> queryAttendanceStatisticsPage(@Param("page")Integer page,@Param("rows") Integer rows,@Param("attendanceStatistics") AttendanceStatistics attendanceStatistics);

    @Select("select count(*) from attendancesetting")
    Long queryAttendancesettingCount(@Param("attendancesetting") Attendancesetting attendancesetting);

    @Select("select * from attendancesetting")
    List<Attendancesetting> queryAttendancesettingPage(@Param("page") Integer page,@Param("rows") Integer rows,@Param("attendancesetting") Attendancesetting attendancesetting);

}
