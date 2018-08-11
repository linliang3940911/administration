package com.ll.pojo.lin;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/11 0011$ 15:30$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/11 0011$ 15:30$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class WorkTree {
    private Integer id;
    private String text;
    private String url;
    private Integer pid;
    private List<WorkTree> nodes;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<WorkTree> getNodes() {
        return nodes;
    }

    public void setNodes(List<WorkTree> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "WorkTree{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", pid=" + pid +
                ", nodes=" + nodes +
                '}';
    }
}
