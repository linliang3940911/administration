package com.ll.pojo.caoxin;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {

    private String userid;//
    private String username;//
    private Integer usersex;//
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date userbirth;//
    private String userphone;//
    private String userofficephone;//
    private String userqq;//
    private String usermailbox;//
    private String useraddress;//
    private String qiyeweixinhao;//
    private String userimg;//
    private String pwd;//
    private String deptid;//部门关联id
    private String deptname;//业务字段
    private String  roleid;//业务字段
    private String userrole;//业务字段
    private String roletext;//业务角色名字字段

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

    public Integer getUsersex() {
        return usersex;
    }

    public void setUsersex(Integer usersex) {
        this.usersex = usersex;
    }

    public Date getUserbirth() {
        return userbirth;
    }

    public void setUserbirth(Date userbirth) {
        this.userbirth = userbirth;
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone;
    }

    public String getUserofficephone() {
        return userofficephone;
    }

    public void setUserofficephone(String userofficephone) {
        this.userofficephone = userofficephone;
    }

    public String getUserqq() {
        return userqq;
    }

    public void setUserqq(String userqq) {
        this.userqq = userqq;
    }

    public String getUsermailbox() {
        return usermailbox;
    }

    public void setUsermailbox(String usermailbox) {
        this.usermailbox = usermailbox;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public String getQiyeweixinhao() {
        return qiyeweixinhao;
    }

    public void setQiyeweixinhao(String qiyeweixinhao) {
        this.qiyeweixinhao = qiyeweixinhao;
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getRoletext() {
        return roletext;
    }

    public void setRoletext(String roletext) {
        this.roletext = roletext;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", usersex=" + usersex +
                ", userbirth=" + userbirth +
                ", userphone='" + userphone + '\'' +
                ", userofficephone='" + userofficephone + '\'' +
                ", userqq='" + userqq + '\'' +
                ", usermailbox='" + usermailbox + '\'' +
                ", useraddress='" + useraddress + '\'' +
                ", qiyeweixinhao='" + qiyeweixinhao + '\'' +
                ", userimg='" + userimg + '\'' +
                ", pwd='" + pwd + '\'' +
                ", deptid='" + deptid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", roleid='" + roleid + '\'' +
                ", userrole='" + userrole + '\'' +
                ", roletext='" + roletext + '\'' +
                '}';
    }
}

