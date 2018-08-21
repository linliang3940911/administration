package com.ll.pojo.yre;

import java.util.List;

public class DeptPojo {

    private String deptid;//
    private String deptname;//
    private String deptpid;//
    private String url;//
    private List<DeptPojo> nodes;

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

    public String getDeptpid() {
        return deptpid;
    }

    public void setDeptpid(String deptpid) {
        this.deptpid = deptpid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<DeptPojo> getNodes() {
        return nodes;
    }

    public void setNodes(List<DeptPojo> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "DeptPojo{" +
                "deptid='" + deptid + '\'' +
                ", deptname='" + deptname + '\'' +
                ", deptpid='" + deptpid + '\'' +
                ", url='" + url + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
