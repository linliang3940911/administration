package com.ll.pojo.lin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/14 0014$ 14:19$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/14 0014$ 14:19$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class ShenQing {

    private String proceid;  //申请ID
    @JSONField(format = "yyyy-MM-dd")
    private Date    procedate; //申请时间
    private String  procerole; //申请的审核人
    private String  proceuser;//申请人
    private Integer proceType;//申请人类型
    private String  shenhetongguo;

    private String   zhipairole;//指派人
    // 关联字段
    private String  userid;
    private  String  woid;
    //业务字段
    private String roletext; //申请的审核人roletext
    private  String  woname;
    private  Integer  dengji;



    //私有化x、y轴数据列表
    private List<String> xlist;
    private List<Integer> ylist;
    private String month;
    private Integer peoplenum;


    @Override
    public String toString() {
        return "ShenQing{" +
                "proceid='" + proceid + '\'' +
                ", procedate=" + procedate +
                ", procerole='" + procerole + '\'' +
                ", proceuser='" + proceuser + '\'' +
                ", proceType=" + proceType +
                ", shenhetongguo='" + shenhetongguo + '\'' +
                ", zhipairole='" + zhipairole + '\'' +
                ", userid='" + userid + '\'' +
                ", woid='" + woid + '\'' +
                ", roletext='" + roletext + '\'' +
                ", woname='" + woname + '\'' +
                ", dengji=" + dengji +
                ", xlist=" + xlist +
                ", ylist=" + ylist +
                ", month='" + month + '\'' +
                ", peoplenum=" + peoplenum +
                '}';
    }

    public String getProceid() {
        return proceid;
    }

    public void setProceid(String proceid) {
        this.proceid = proceid;
    }

    public Date getProcedate() {
        return procedate;
    }

    public void setProcedate(Date procedate) {
        this.procedate = procedate;
    }

    public String getProcerole() {
        return procerole;
    }

    public void setProcerole(String procerole) {
        this.procerole = procerole;
    }

    public String getProceuser() {
        return proceuser;
    }

    public void setProceuser(String proceuser) {
        this.proceuser = proceuser;
    }

    public Integer getProceType() {
        return proceType;
    }

    public void setProceType(Integer proceType) {
        this.proceType = proceType;
    }

    public String getShenhetongguo() {
        return shenhetongguo;
    }

    public void setShenhetongguo(String shenhetongguo) {
        this.shenhetongguo = shenhetongguo;
    }

    public String getZhipairole() {
        return zhipairole;
    }

    public void setZhipairole(String zhipairole) {
        this.zhipairole = zhipairole;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getWoid() {
        return woid;
    }

    public void setWoid(String woid) {
        this.woid = woid;
    }

    public String getRoletext() {
        return roletext;
    }

    public void setRoletext(String roletext) {
        this.roletext = roletext;
    }

    public String getWoname() {
        return woname;
    }

    public void setWoname(String woname) {
        this.woname = woname;
    }

    public Integer getDengji() {
        return dengji;
    }

    public void setDengji(Integer dengji) {
        this.dengji = dengji;
    }

    public List<String> getXlist() {
        return xlist;
    }

    public void setXlist(List<String> xlist) {
        this.xlist = xlist;
    }

    public List<Integer> getYlist() {
        return ylist;
    }

    public void setYlist(List<Integer> ylist) {
        this.ylist = ylist;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(Integer peoplenum) {
        this.peoplenum = peoplenum;
    }
}
