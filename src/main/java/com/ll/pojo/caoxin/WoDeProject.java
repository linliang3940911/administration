package com.ll.pojo.caoxin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class WoDeProject {
    //id
    private  String  proid;
    //项目编号
    private  String  pronumber;
    //项目名称
    private  String  proname;
    //执行人
    private  String  executor;
    //审批人
    private  String   approver;
    //计划时间
    private   String   plannedtime;
    //计划工时
    private   Integer  plantime;
    //实际时间
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private    Date   actualtime;
    //状态
    private   Integer  prostatus;


    public String getProid() {
        return proid;
    }
    public void setProid(String proid) {
        this.proid = proid;
    }
    public String getPronumber() {
        return pronumber;
    }
    public void setPronumber(String pronumber) {
        this.pronumber = pronumber;
    }
    public String getProname() {
        return proname;
    }
    public void setProname(String proname) {
        this.proname = proname;
    }
    public String getExecutor() {
        return executor;
    }
    public void setExecutor(String executor) {
        this.executor = executor;
    }
    public String getApprover() {
        return approver;
    }
    public void setApprover(String approver) {
        this.approver = approver;
    }
    public String getPlannedtime() {
        return plannedtime;
    }
    public void setPlannedtime(String plannedtime) {
        this.plannedtime = plannedtime;
    }
    public Integer getPlantime() {
        return plantime;
    }
    public void setPlantime(Integer plantime) {
        this.plantime = plantime;
    }
    public Date getActualtime() {
        return actualtime;
    }
    public void setActualtime(Date actualtime) {
        this.actualtime = actualtime;
    }
    public Integer getProstatus() {
        return prostatus;
    }
    public void setProstatus(Integer prostatus) {
        this.prostatus = prostatus;
    }
    @Override
    public String toString() {
        return "WoDeProject{" +
                "proid='" + proid + '\'' +
                ", pronumber='" + pronumber + '\'' +
                ", proname='" + proname + '\'' +
                ", executor='" + executor + '\'' +
                ", approver='" + approver + '\'' +
                ", plannedtime='" + plannedtime + '\'' +
                ", plantime=" + plantime +
                ", actualtime=" + actualtime +
                ", prostatus=" + prostatus +
                '}';
    }
}
