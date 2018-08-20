package com.ll.pojo.yre;

public class AttendanceStatistics {

    private String kaoqintongjiid;//考勤统计id
    private String kaoqintongjidate;//考勤统计时间
    private String deptid;//部门关联id
    private String userid;//用户关联id

    //业务字段
    private String deptname;//
    private String username;//

    public String getKaoqintongjiid() {
        return kaoqintongjiid;
    }

    public void setKaoqintongjiid(String kaoqintongjiid) {
        this.kaoqintongjiid = kaoqintongjiid;
    }

    public String getKaoqintongjidate() {
        return kaoqintongjidate;
    }

    public void setKaoqintongjidate(String kaoqintongjidate) {
        this.kaoqintongjidate = kaoqintongjidate;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "AttendanceStatistics{" +
                "kaoqintongjiid='" + kaoqintongjiid + '\'' +
                ", kaoqintongjidate='" + kaoqintongjidate + '\'' +
                ", deptid='" + deptid + '\'' +
                ", userid='" + userid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
