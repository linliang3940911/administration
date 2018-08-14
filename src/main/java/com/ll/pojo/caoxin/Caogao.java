package com.ll.pojo.caoxin;

import com.alibaba.fastjson.annotation.JSONField;

import java.sql.Date;

public class Caogao {
    private String     xiangid;
    private String    bianhao;
    private String  biaoti;
    private String   fenlei;
    private String   liuchang;
    @JSONField(format = "yyyy-MM-dd")
    private Date bainjishiqi;


    public String getXiangid() {
        return xiangid;
    }

    public void setXiangid(String xiangid) {
        this.xiangid = xiangid;
    }

    public String getBianhao() {
        return bianhao;
    }

    public void setBianhao(String bianhao) {
        this.bianhao = bianhao;
    }

    public String getBiaoti() {
        return biaoti;
    }

    public void setBiaoti(String biaoti) {
        this.biaoti = biaoti;
    }

    public String getFenlei() {
        return fenlei;
    }

    public void setFenlei(String fenlei) {
        this.fenlei = fenlei;
    }

    public String getLiuchang() {
        return liuchang;
    }

    public void setLiuchang(String liuchang) {
        this.liuchang = liuchang;
    }

    public Date getBainjishiqi() {
        return bainjishiqi;
    }

    public void setBainjishiqi(Date bainjishiqi) {
        this.bainjishiqi = bainjishiqi;
    }

    @Override
    public String toString() {
        return "Caogao{" +
                "xiangid='" + xiangid + '\'' +
                ", bianhao='" + bianhao + '\'' +
                ", biaoti='" + biaoti + '\'' +
                ", fenlei='" + fenlei + '\'' +
                ", liuchang='" + liuchang + '\'' +
                ", bainjishiqi=" + bainjishiqi +
                '}';
    }
}
