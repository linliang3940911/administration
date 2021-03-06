package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class User {

    private String userid;//
    private String username;//
    private Integer usersex;//
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date userbirth;//
    private String userphone;//
    private String userofficephone;//
    private String userqq;//
    private String usermailbox;//
    private String useraddress;//
    private String qiyeweixinhao;//
    private String userimg;//
    private String pwd;

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
}

