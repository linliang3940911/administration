package com.ll.pojo.lin;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/13 0013$ 17:19$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/13 0013$ 17:19$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Attribute {
    private String attributeid;
    private String attributename;
    private String attributeType;
    //业务字段
    private String woid;

    public String getWoid() {
        return woid;
    }

    public void setWoid(String woid) {
        this.woid = woid;
    }

    public String getAttributeid() {
        return attributeid;
    }

    public void setAttributeid(String attributeid) {
        this.attributeid = attributeid;
    }

    public String getAttributename() {
        return attributename;
    }

    public void setAttributename(String attributename) {
        this.attributename = attributename;
    }

    public String getAttributeType() {
        return attributeType;
    }

    public void setAttributeType(String attributeType) {
        this.attributeType = attributeType;
    }

    @Override
    public String toString() {
        return "Attribute{" +
                "attributeid='" + attributeid + '\'' +
                ", attributename='" + attributename + '\'' +
                ", attributeType='" + attributeType + '\'' +
                ", woid='" + woid + '\'' +
                '}';
    }
}
