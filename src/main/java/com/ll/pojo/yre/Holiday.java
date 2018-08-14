package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Holiday {

    private String holidayid;//年假id
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date startyearlholiday;//开始年假时间
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endyearlholiday;//结束年假时间
    private  String userid;//
    private  String username;//

    public String getHolidayid() {
        return holidayid;
    }

    public void setHolidayid(String holidayid) {
        this.holidayid = holidayid;
    }

    public Date getStartyearlholiday() {
        return startyearlholiday;
    }

    public void setStartyearlholiday(Date startyearlholiday) {
        this.startyearlholiday = startyearlholiday;
    }

    public Date getEndyearlholiday() {
        return endyearlholiday;
    }

    public void setEndyearlholiday(Date endyearlholiday) {
        this.endyearlholiday = endyearlholiday;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
