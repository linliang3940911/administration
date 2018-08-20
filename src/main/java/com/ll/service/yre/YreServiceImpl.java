package com.ll.service.yre;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ll.dao.yre.YreMapper;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.yre.*;
import org.apache.catalina.filters.RequestFilter;
import org.apache.http.HttpRequest;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.*;

@Service
public class YreServiceImpl implements IYreService{

    @Resource
    private YreMapper yreMapper;

    //注入AmqpTemplate将操作  存入  rabbitmq(队列)
    @Autowired
    private AmqpTemplate amqpTemplate;

    //mongoTemplate为查询操作日志所用
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public JSONObject queryRegistration(Integer page, Integer rows, Commute commute) {
        Long count = yreMapper.queryRegistrationCount(commute);
        List<Commute> commuteList = yreMapper.queryRegistrationPage(page,rows,commute);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", commuteList);
        return json;
    }

    @Override
    public Commute addReasonById(String commuteid) {
        return yreMapper.addReasonById(commuteid);
    }

    @Override
    public void addReason2(Commute commute) {
        yreMapper.addReason2(commute);
    }

    @Override
    public JSONObject queryMySchedule(Integer page, Integer rows,HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String userid = user.getUserid();
        Long count = yreMapper.queryMyScheduleCount(userid);
        List<KaoQinBanCi> myScheduleList = yreMapper.queryMySchedulePage(page,rows,userid);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", myScheduleList);
        return json;
    }

    @Override
    public JSONObject queryMyHoliday(Integer page, Integer rows,HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String userid = user.getUserid();
        Long count = yreMapper.queryMyHolidayCount(userid);
        List<Holiday> myHolidayList = yreMapper.queryMyHolidayPage(page,rows,userid);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", myHolidayList);
        return json;
    }

    @Override
    public JSONObject queryOvertimeRegistration(Integer page, Integer rows, JiaBan jiaBan, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String userid = user.getUserid();
        Long count = yreMapper.queryOvertimeRegistrationCount(userid);
        List<JiaBan> jiaBanList = yreMapper.queryOvertimeRegistrationPage(page,rows,userid);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", jiaBanList);
        return json;
    }

    @Override
    public JiaBan queryxiangqing(String jiabanid) {
        return yreMapper.queryxiangqing(jiabanid);
    }

    @Override
    public void addOvertimeRegistration(JiaBan jiaBan) {

        //UUID
        String jiaBanid = UUID.randomUUID().toString();
        jiaBan.setJiabanid(jiaBanid);

        //登记人（超级管理员）
        jiaBan.setUserid("4");

        //申请时间为当前系统时间
        Date date = new Date();
        jiaBan.setShenqingtime(date);
        yreMapper.addOvertimeRegistration(jiaBan);
    }

    @Override
    public JSONObject queryRavelRegistration(Integer page, Integer rows, Travel travel, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String userid = user.getUserid();
        Long count = yreMapper.queryRavelRegistrationCount(userid);
        List<Travel> ravelRegistrationList = yreMapper.queryRavelRegistrationPage(page,rows,userid);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", ravelRegistrationList);
        return json;
    }

    @Override
    public Travel queryTravelXiangQing(String travelid) {
        return yreMapper.queryTravelXiangQing(travelid);
    }

    @Override
    public void addTravelRegistration(Travel travel) {

        String travelid = UUID.randomUUID().toString();
        travel.setTravelid(travelid);
        travel.setUserid("4");
        Date date = new Date();
        travel.setShengqingtime(date);
        yreMapper.addTravelRegistration(travel);
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws  往队列里存当前操作人的（当前时间,操作人,操作方法）日志
    　　* @author 因蓉儿
    　　* @date 2018/8/15 17:44 
    　　*/
    @Override
    public void operationLog(String operationMethod) {
        /*HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String username = user.getUsername();//获取当前操作人*/

        OperationPojo operation = new OperationPojo();

        Date date = new Date();//当前系统时间
        String operationid = UUID.randomUUID().toString();

        operation.setOperationid(operationid);//操作id放入操作表中
        operation.setOperationdate(date);//1.当前系统时间放入操作表中
        operation.setOperationmothedname(operationMethod);//2.方法名放入操作表中
        //operation.setOperationname(username);//3.当前操作人放入操作表中
        String operationPojo = JSON.toJSONString(operation);
        amqpTemplate.convertAndSend("hello",operationPojo);

    }

    @Override
    public JSONObject queryMongodbOperation(Integer page, Integer rows, OperationPojo operationPojo) {
        Query query = new Query();
        //skip 跳过  设置分页查询的起始位置
        query.skip(page);
        //设置每页条数 从起始位置开始往后数两条数据
        query.limit(rows);
        long count = mongoTemplate.count(new Query(),OperationPojo.class);
        List<OperationPojo> operationList = mongoTemplate.find(query,OperationPojo.class);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", operationList);
        return json;
    }

    @Override
    public JSONObject queryKaoQinJiJiLu(Integer page, Integer rows, KaoQinJi kaoQinJi) {
        Long count = yreMapper.queryKaoQinJiJiLuCount(kaoQinJi);
        List<KaoQinJi> kaoQinJiList = yreMapper.queryKaoQinJiJiLuPage(page,rows,kaoQinJi);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", kaoQinJiList);
        return json;
    }

    @Override
    public List<DeptPojo> queryDeptTree() {
        return yreMapper.queryDeptTree();
    }

    @Override
    public JSONObject queryOnTheJobStatus(Integer page, Integer rows, Onduty onduty) {
        Long count = yreMapper.queryOnTheJobStatusCount(onduty);
        List<Onduty> ondutyList = yreMapper.queryOnTheJobStatusPage(page,rows,onduty);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", ondutyList);
        return json;
    }

    @Override
    public JSONObject queryAttendanceStatistics(Integer page, Integer rows, AttendanceStatistics attendanceStatistics) {
        Long count = yreMapper.queryAttendanceStatisticsCount(attendanceStatistics);
        List<AttendanceStatistics> attendanceStatisticsList = yreMapper.queryAttendanceStatisticsPage(page,rows,attendanceStatistics);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", attendanceStatisticsList);
        return json;
    }

    @Override
    public JSONObject queryAttendancesetting(Integer page, Integer rows, Attendancesetting attendancesetting) {
        Long count = yreMapper.queryAttendancesettingCount(attendancesetting);
        List<Attendancesetting> attendancesettingList = yreMapper.queryAttendancesettingPage(page,rows,attendancesetting);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", attendancesettingList);
        return json;
    }
}






