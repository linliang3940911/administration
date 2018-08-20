package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Onduty {

    private String ondutyid;//在岗id
    private String register;//是否登记(1是,2否)
    private String userid;//用户关联id
    private String banciid;//班次关联id

    //业务字段
    private String username;//
    @JSONField(format="HH:mm:ss")
    private Date amshangban;//
    @JSONField(format="HH:mm:ss")
    private  Date amxiaban;//
    @JSONField(format="HH:mm:ss")
    private  Date pmshangban;//
    @JSONField(format="HH:mm:ss")
    private  Date pmxiaban;//
    private String deptname;//

    public String getOndutyid() {
        return ondutyid;
    }

    public void setOndutyid(String ondutyid) {
        this.ondutyid = ondutyid;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBanciid() {
        return banciid;
    }

    public void setBanciid(String banciid) {
        this.banciid = banciid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getAmshangban() {
        return amshangban;
    }

    public void setAmshangban(Date amshangban) {
        this.amshangban = amshangban;
    }

    public Date getAmxiaban() {
        return amxiaban;
    }

    public void setAmxiaban(Date amxiaban) {
        this.amxiaban = amxiaban;
    }

    public Date getPmshangban() {
        return pmshangban;
    }

    public void setPmshangban(Date pmshangban) {
        this.pmshangban = pmshangban;
    }

    public Date getPmxiaban() {
        return pmxiaban;
    }

    public void setPmxiaban(Date pmxiaban) {
        this.pmxiaban = pmxiaban;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    @Override
    public String toString() {
        return "Onduty{" +
                "ondutyid='" + ondutyid + '\'' +
                ", register='" + register + '\'' +
                ", userid='" + userid + '\'' +
                ", banciid='" + banciid + '\'' +
                ", username='" + username + '\'' +
                ", amshangban=" + amshangban +
                ", amxiaban=" + amxiaban +
                ", pmshangban=" + pmshangban +
                ", pmxiaban=" + pmxiaban +
                ", deptname='" + deptname + '\'' +
                '}';
    }
}
