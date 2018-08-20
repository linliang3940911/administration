package com.ll.pojo.yre;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
@Document(collection="operations")
public class OperationPojo implements Serializable{

    private String  operationid;//操作id

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date operationdate;//操作时间

    private String operationmothedname;//操作方法

    public String getOperationid() {
        return operationid;
    }

    public void setOperationid(String operationid) {
        this.operationid = operationid;
    }

    public Date getOperationdate() {
        return operationdate;
    }

    public void setOperationdate(Date operationdate) {
        this.operationdate = operationdate;
    }

    public String getOperationmothedname() {
        return operationmothedname;
    }

    public void setOperationmothedname(String operationmothedname) {
        this.operationmothedname = operationmothedname;
    }

    @Override
    public String toString() {
        return "OperationPojo{" +
                "operationid='" + operationid + '\'' +
                ", operationdate=" + operationdate +
                ", operationmothedname='" + operationmothedname + '\'' +
                '}';
    }
}
