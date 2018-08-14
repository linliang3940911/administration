package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JiaBan {

    private String jiabanid;//
    @JSONField(format="yyyy-MM-dd")
    private Date shenqingtime;//申请时间
    @JSONField(format="yyyy-MM-dd HH:mm")
    private Date kaishitime;//开始时间
    @JSONField(format="yyyy-MM-dd HH:mm")
    private Date jieshutime;//结束时间
    private String jiabanyuanyin;//加班原因
    private Integer breakdown;//是否计入调休
    private String userid;//用户关联id

    //业务字段
    private String username;//登记人
    //业务字段
    private String kaishi;
    //业务字段
    private String jieshu;

    public String getJiabanid() {
        return jiabanid;
    }

    public void setJiabanid(String jiabanid) {
        this.jiabanid = jiabanid;
    }

    public Date getShenqingtime() {
        return shenqingtime;
    }

    public void setShenqingtime(Date shenqingtime) {
        this.shenqingtime = shenqingtime;
    }

    public Date getKaishitime() {
        return kaishitime;
    }

    public void setKaishitime(Date kaishitime) {
        this.kaishitime = kaishitime;
    }

    public Date getJieshutime() {
        return jieshutime;
    }

    public void setJieshutime(Date jieshutime) {
        this.jieshutime = jieshutime;
    }

    public String getJiabanyuanyin() {
        return jiabanyuanyin;
    }

    public void setJiabanyuanyin(String jiabanyuanyin) {
        this.jiabanyuanyin = jiabanyuanyin;
    }

    public Integer getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(Integer breakdown) {
        this.breakdown = breakdown;
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

    public String getKaishi() {
        return kaishi;
    }

    public void setKaishi(String kaishi) {
        this.kaishi = kaishi;
    }

    public String getJieshu() {
        return jieshu;
    }

    public void setJieshu(String jieshu) {
        this.jieshu = jieshu;
    }

    @Override
    public String toString() {
        return "JiaBan{" +
                "jiabanid='" + jiabanid + '\'' +
                ", shenqingtime=" + shenqingtime +
                ", kaishitime=" + kaishitime +
                ", jieshutime=" + jieshutime +
                ", jiabanyuanyin='" + jiabanyuanyin + '\'' +
                ", breakdown=" + breakdown +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", kaishi='" + kaishi + '\'' +
                ", jieshu='" + jieshu + '\'' +
                '}';
    }
}
