package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class KaoQinBanCi {

    private  String banciid;//

    @JSONField(format="yyyy-MM-dd")
    private Date paibanriqi;//
    private  String banciname;//
    @JSONField(format="HH:mm:ss")
    private  Date amshangban;//
    @JSONField(format="HH:mm:ss")
    private  Date amxiaban;//
    @JSONField(format="HH:mm:ss")
    private  Date pmshangban;//
    @JSONField(format="HH:mm:ss")
    private  Date pmxiaban;//

    private  String userid;//
    private String remarks;//备注

    private  String username;//

    public String getBanciid() {
        return banciid;
    }

    public void setBanciid(String banciid) {
        this.banciid = banciid;
    }

    public Date getPaibanriqi() {
        return paibanriqi;
    }

    public void setPaibanriqi(Date paibanriqi) {
        this.paibanriqi = paibanriqi;
    }

    public String getBanciname() {
        return banciname;
    }

    public void setBanciname(String banciname) {
        this.banciname = banciname;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
