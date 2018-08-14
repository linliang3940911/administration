package com.ll.service.yre;

import com.alibaba.fastjson.JSONObject;
import com.ll.dao.yre.YreMapper;
import com.ll.pojo.yre.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class YreServiceImpl implements IYreService{

    @Resource
    private YreMapper yreMapper;

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
    public JSONObject queryMySchedule(Integer page, Integer rows, KaoQinBanCi kaoqinbanci) {
        Long count = yreMapper.queryMyScheduleCount(kaoqinbanci);
        List<KaoQinBanCi> myScheduleList = yreMapper.queryMySchedulePage(page,rows,kaoqinbanci);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", myScheduleList);
        return json;
    }

    @Override
    public JSONObject queryMyHoliday(Integer page, Integer rows, Holiday holiday) {
        Long count = yreMapper.queryMyHolidayCount(holiday);
        List<Holiday> myHolidayList = yreMapper.queryMyHolidayPage(page,rows,holiday);
        JSONObject json = new JSONObject();
        json.put("total", count);
        json.put("rows", myHolidayList);
        return json;
    }

    @Override
    public JSONObject queryOvertimeRegistration(Integer page, Integer rows, JiaBan jiaBan) {
        Long count = yreMapper.queryOvertimeRegistrationCount(jiaBan);
        List<JiaBan> jiaBanList = yreMapper.queryOvertimeRegistrationPage(page,rows,jiaBan);
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
    public JSONObject queryRavelRegistration(Integer page, Integer rows, Travel travel) {
        Long count = yreMapper.queryRavelRegistrationCount(travel);
        List<Travel> ravelRegistrationList = yreMapper.queryRavelRegistrationPage(page,rows,travel);
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
}






