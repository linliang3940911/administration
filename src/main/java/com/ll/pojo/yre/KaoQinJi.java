package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class KaoQinJi {

    private String kaoqinid;//考勤机id
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date amupdakashijian;//上午上班打卡时间
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date pmdowndakashijian;//小午下班打卡时间
    private String userid;//用户关联id

    //业务字段
    private String username;//考勤者

    public String getKaoqinid() {
        return kaoqinid;
    }

    public void setKaoqinid(String kaoqinid) {
        this.kaoqinid = kaoqinid;
    }

    public Date getAmupdakashijian() {
        return amupdakashijian;
    }

    public void setAmupdakashijian(Date amupdakashijian) {
        this.amupdakashijian = amupdakashijian;
    }

    public Date getPmdowndakashijian() {
        return pmdowndakashijian;
    }

    public void setPmdowndakashijian(Date pmdowndakashijian) {
        this.pmdowndakashijian = pmdowndakashijian;
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
