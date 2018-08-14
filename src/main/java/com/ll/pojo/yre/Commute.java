package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Commute {

    private String commuteid;//
    private String banci;//
    private String dengjitype;//
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date settime;//
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date starttime;//
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date endtime;//
    private String registrationtime;//
    private String cause;//

    public String getCommuteid() {
        return commuteid;
    }

    public void setCommuteid(String commuteid) {
        this.commuteid = commuteid;
    }

    public String getBanci() {
        return banci;
    }

    public void setBanci(String banci) {
        this.banci = banci;
    }

    public String getDengjitype() {
        return dengjitype;
    }

    public void setDengjitype(String dengjitype) {
        this.dengjitype = dengjitype;
    }

    public Date getSettime() {
        return settime;
    }

    public void setSettime(Date settime) {
        this.settime = settime;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getRegistrationtime() {
        return registrationtime;
    }

    public void setRegistrationtime(String registrationtime) {
        this.registrationtime = registrationtime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
