package com.ll.pojo.yre;

import java.util.Date;

public class Attendancesetting {

    private String attendancesettingid;//考勤设置id
    private String banciname;//班次名称
    private String amshangbantime;//上午上班时间
    private String amxiabantime   ;//上午下班时间
    private String pmshangbantime;//下午上班时间
    private String pmxiabantime;//下午下班时间
    private Integer vacationstate;//休假状态(1是,2否)
    private Integer takeeffectstate;//生效状态(1是,2否)

    public String getAttendancesettingid() {
        return attendancesettingid;
    }

    public void setAttendancesettingid(String attendancesettingid) {
        this.attendancesettingid = attendancesettingid;
    }

    public String getBanciname() {
        return banciname;
    }

    public void setBanciname(String banciname) {
        this.banciname = banciname;
    }

    public String getAmshangbantime() {
        return amshangbantime;
    }

    public void setAmshangbantime(String amshangbantime) {
        this.amshangbantime = amshangbantime;
    }

    public String getAmxiabantime() {
        return amxiabantime;
    }

    public void setAmxiabantime(String amxiabantime) {
        this.amxiabantime = amxiabantime;
    }

    public String getPmshangbantime() {
        return pmshangbantime;
    }

    public void setPmshangbantime(String pmshangbantime) {
        this.pmshangbantime = pmshangbantime;
    }

    public String getPmxiabantime() {
        return pmxiabantime;
    }

    public void setPmxiabantime(String pmxiabantime) {
        this.pmxiabantime = pmxiabantime;
    }

    public Integer getVacationstate() {
        return vacationstate;
    }

    public void setVacationstate(Integer vacationstate) {
        this.vacationstate = vacationstate;
    }

    public Integer getTakeeffectstate() {
        return takeeffectstate;
    }

    public void setTakeeffectstate(Integer takeeffectstate) {
        this.takeeffectstate = takeeffectstate;
    }

    @Override
    public String toString() {
        return "Attendancesetting{" +
                "attendancesettingid='" + attendancesettingid + '\'' +
                ", banciname='" + banciname + '\'' +
                ", amshangbantime='" + amshangbantime + '\'' +
                ", amxiabantime='" + amxiabantime + '\'' +
                ", pmshangbantime='" + pmshangbantime + '\'' +
                ", pmxiabantime='" + pmxiabantime + '\'' +
                ", vacationstate=" + vacationstate +
                ", takeeffectstate=" + takeeffectstate +
                '}';
    }
}
