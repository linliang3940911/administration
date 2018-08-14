package com.ll.pojo.lin;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/13 0013$ 21:54$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/13 0013$ 21:54$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class Procedures {
    private int roleid;
    private String roletext;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRoletext() {
        return roletext;
    }

    public void setRoletext(String roletext) {
        this.roletext = roletext;
    }

    @Override
    public String toString() {
        return "procedure{" +
                "roleid=" + roleid +
                ", roletext='" + roletext + '\'' +
                '}';
    }
}
