package com.ll.pojo.lin;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/11 0011$ 16:02$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/11 0011$ 16:02$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WorkName {
    private String woname;
    private String woid;
    private String workType;

    public String getWoname() {
        return woname;
    }

    public void setWoname(String woname) {
        this.woname = woname;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getWoid() {
        return woid;
    }

    public void setWoid(String woid) {
        this.woid = woid;
    }

    @Override
    public String toString() {
        return "WorkName{" +
                "woname='" + woname + '\'' +
                ", woid='" + woid + '\'' +
                ", workType='" + workType + '\'' +
                '}';
    }
}
