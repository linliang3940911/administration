package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Travel {

    private String travelid;//出差id
    @JSONField(format ="yyyy-MM-dd HH:mm" )
    private Date shengqingtime;//申请时间
    @JSONField(format ="yyyy-MM-dd HH:mm" )
    private Date kaishitime;//开始时间
    @JSONField(format ="yyyy-MM-dd HH:mm" )
    private Date jieshutime;//结束时间
    private String placeoftravel;//出差地点
    private String travelyuanyin;//出差事由
    private String userid;//用户关联ID
    //业务字段
    private String kaishi;
    //业务字段
    private String jieshu;
    //业务字段
    private String username;//出差人

    public String getTravelid() {
        return travelid;
    }

    public void setTravelid(String travelid) {
        this.travelid = travelid;
    }

    public Date getShengqingtime() {
        return shengqingtime;
    }

    public void setShengqingtime(Date shengqingtime) {
        this.shengqingtime = shengqingtime;
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

    public String getPlaceoftravel() {
        return placeoftravel;
    }

    public void setPlaceoftravel(String placeoftravel) {
        this.placeoftravel = placeoftravel;
    }

    public String getTravelyuanyin() {
        return travelyuanyin;
    }

    public void setTravelyuanyin(String travelyuanyin) {
        this.travelyuanyin = travelyuanyin;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getJieshu() {
        return jieshu;
    }

    public void setJieshu(String jieshu) {
        this.jieshu = jieshu;
    }

    public String getKaishi() {
        return kaishi;
    }

    public void setKaishi(String kaishi) {
        this.kaishi = kaishi;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "travelid='" + travelid + '\'' +
                ", shengqingtime=" + shengqingtime +
                ", kaishitime=" + kaishitime +
                ", jieshutime=" + jieshutime +
                ", placeoftravel='" + placeoftravel + '\'' +
                ", travelyuanyin='" + travelyuanyin + '\'' +
                ", userid='" + userid + '\'' +
                ", jieshu='" + jieshu + '\'' +
                ", kaishi='" + kaishi + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
