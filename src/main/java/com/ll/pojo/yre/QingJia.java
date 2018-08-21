package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class QingJia {

    private String qingjiaid;//请假id
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date shenqingtime;//申请时间
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date kaishitime;//请假开始时间
    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date jieshutime;//请假结束时间
    private Integer qingjiatianshu;//请假天数
    private Integer nianjiatianshu;//年假天数
    private Integer tiaoxiutianshu;//调休天数
    private Integer qingjiatype;//请假类型(1.病假，2.事假，3.年假，4.路途假，5.婚假，6.陪产假，7.产假，8.丧假，9.调休，10.其他)
    private String qingjiayuanyin;//请假原因
    private String userid;//用户关联id
    //业务字段
    private String username;//用户
    //业务字段
    private String kaishi;
    //业务字段
    private String jieshu;

    public String getQingjiaid() {
        return qingjiaid;
    }

    public void setQingjiaid(String qingjiaid) {
        this.qingjiaid = qingjiaid;
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

    public Integer getQingjiatianshu() {
        return qingjiatianshu;
    }

    public void setQingjiatianshu(Integer qingjiatianshu) {
        this.qingjiatianshu = qingjiatianshu;
    }

    public Integer getNianjiatianshu() {
        return nianjiatianshu;
    }

    public void setNianjiatianshu(Integer nianjiatianshu) {
        this.nianjiatianshu = nianjiatianshu;
    }

    public Integer getTiaoxiutianshu() {
        return tiaoxiutianshu;
    }

    public void setTiaoxiutianshu(Integer tiaoxiutianshu) {
        this.tiaoxiutianshu = tiaoxiutianshu;
    }

    public Integer getQingjiatype() {
        return qingjiatype;
    }

    public void setQingjiatype(Integer qingjiatype) {
        this.qingjiatype = qingjiatype;
    }

    public String getQingjiayuanyin() {
        return qingjiayuanyin;
    }

    public void setQingjiayuanyin(String qingjiayuanyin) {
        this.qingjiayuanyin = qingjiayuanyin;
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
        return "QingJia{" +
                "qingjiaid='" + qingjiaid + '\'' +
                ", shenqingtime=" + shenqingtime +
                ", kaishitime=" + kaishitime +
                ", jieshutime=" + jieshutime +
                ", qingjiatianshu=" + qingjiatianshu +
                ", nianjiatianshu=" + nianjiatianshu +
                ", tiaoxiutianshu=" + tiaoxiutianshu +
                ", qingjiatype=" + qingjiatype +
                ", qingjiayuanyin='" + qingjiayuanyin + '\'' +
                ", userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", kaishi='" + kaishi + '\'' +
                ", jieshu='" + jieshu + '\'' +
                '}';
    }
}
