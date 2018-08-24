package com.ll.pojo.lin;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/15 0015$ 9:38$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/15 0015$ 9:38$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Wangpan {
    private Integer id;
    private String text;
    @JSONField(format = "yyyy-MM-dd")
    private Date upddate;
    private String allname;
    private  String pid;
    private  String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getUpddate() {
        return upddate;
    }

    public void setUpddate(Date upddate) {
        this.upddate = upddate;
    }

    public String getAllname() {
        return allname;
    }

    public void setAllname(String allname) {
        this.allname = allname;
    }

    @Override
    public String toString() {
        return "Wangpan{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", upddate=" + upddate +
                ", allname='" + allname + '\'' +
                ", pid='" + pid + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
