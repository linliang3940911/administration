package com.ll.pojo.lin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

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
    private Date procedate; //申请时间
    private String procerole; //申请的审核人
    private String proceuser;//申请人
    private Integer proceType;//申请人类型

    private String roletext; //申请的审核人


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

    public String getRoletext() {
        return roletext;
    }

    public void setRoletext(String roletext) {
        this.roletext = roletext;
    }

    @Override
    public String toString() {
        return "ShenQing{" +
                "proceid='" + proceid + '\'' +
                ", procedate=" + procedate +
                ", procerole='" + procerole + '\'' +
                ", proceuser='" + proceuser + '\'' +
                ", proceType=" + proceType +
                ", roletext='" + roletext + '\'' +
                '}';
    }
}
