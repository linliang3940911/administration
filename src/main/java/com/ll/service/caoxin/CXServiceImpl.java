package com.ll.service.caoxin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ll.dao.caoxin.IcxDao;
import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.caoxin.WoDeProject;
import com.ll.pojo.lin.Procedures;
import com.ll.pojo.lin.ShenQing;
import com.ll.pojo.lin.WorkTree;
import com.ll.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class CXServiceImpl implements CXService {
    @Autowired
    private IcxDao cxdao;

    @Override
    public List<WoDeProject> queryList() {
        return cxdao.queryList();
    }

    @Override
    public List<ShenQing> queryCaogao(Integer offset, Integer limit,String userid) {
        return cxdao.queryCaogao(offset,limit,userid);
    }

    @Override
    public void deleteCaogao(String ids) {
        cxdao.deleteCaogao(ids);
    }

    @Override
    public Long tctota(String userid) {
        return cxdao.tctota(userid);
    }

    @Override
    public Long tctotas(String userid) {
        return cxdao.tctotas(userid);
    }
    @Override
    public List<ShenQing> queryshen(Integer offset, Integer limit,String userid) {
        List<ShenQing> queryshen = cxdao.queryshen(offset, limit);
        User user= cxdao.queryRoles(userid);
        List<ShenQing> query=new ArrayList<ShenQing>();
        for (ShenQing shenQing : queryshen) {
            String[] split = shenQing.getRoletext().split(",");

                if(user.getRoletext().equals(split[0])){
                    query.add(shenQing);

            }
        }
        return query;

    }

    @Override
    public void updateProce(String proceid) {
        cxdao.updateProce(proceid);
    }

    @Override
    public ShenQing xiangqing(String proceid) {
        return cxdao.xiangqing(proceid);
    }

    @Override
    public ShenQing tongguo(String proceid){
       return cxdao.tongguo(proceid);
    }



    @Override
    public List<ShenQing> queryShenqing() {
        return   cxdao.queryShenqing();
    }

    @Override
    public List<ShenQing> queryCaoGao() {
        return cxdao.queryCaoGao();
    }

    @Override
    public void updatebohui(ShenQing shen) {
       String  str = shen.getShenhetongguo();
        if(str.indexOf(",")!=-1){
            String[] split=str.split(",");
            String zxc="";
            for (int i = 0; i < split.length; i++) {
                if(i>0){
                    zxc += ","+split[i];
                }
            }
            zxc=zxc.substring(1);

            shen.setProcerole(split[0]+","+shen.getProcerole());
            shen.setShenhetongguo(zxc);

        }

        if(str.indexOf(",")==-1){
            shen.setProcerole(str+","+shen.getProcerole());
            shen.setShenhetongguo("");

        }
       cxdao.updatebohui(shen);
    }

    @Override
    public void updatepro(ShenQing shen2){
            String pro = shen2.getProcerole();
            String[] split = pro.split(",");
            String str="";
            if(pro.indexOf(",")!=-1){
                for (int i = 0; i < split.length; i++) {
                    if(i>0){
                        str += ","+split[i];
                    }
                }
            }
        str=str.substring(1);

        if("".equals(shen2.getShenhetongguo())){
            shen2.setShenhetongguo(split[0]);
            shen2.setProcerole(str);
            cxdao.updateUseridasd(shen2);
        }else if(!"".equals(shen2.getShenhetongguo())&&shen2.getShenhetongguo()!=null){
            shen2.setShenhetongguo(split[0]+","+shen2.getShenhetongguo());
            shen2.setProcerole(str);
            cxdao.updateUseridasd(shen2);
        }
    }
    @Override
    public void zhipairen(String zxc,ShenQing shen,String  usid) {
       String userids=shen.getUserid();
       shen.setUserid(usid);
       String  pro = shen.getProcerole();
       String dd="";
        if(pro.indexOf(",") != -1){
            String [] ss = pro.split(",");
            for (int i = 0; i < ss.length; i++) {
                if(i>0){
                    dd += ","+ss[i];
                }
                shen.setZhipairole(ss[0]);
            }
            dd=dd.substring(1);
            shen.setProcerole(zxc+","+dd);
        }
        if(pro.indexOf(",") == -1){
            shen.setZhipairole(shen.getProcerole());
            shen.setProcerole(zxc);
            shen.setUserid(usid);
        }
        cxdao.zhipairen(shen);
    }

    @Override
    public List<WorkTree> queryListTree() {
        return cxdao.queryListTree();
    }

    @Override
    public List<ShenQing> queryLiuChang1(String  userid) {
        return cxdao.queryLiuChang1(userid);
    }
    @Override
    public List<ShenQing> queryLiuChang2(String  userid) {
        return cxdao.queryLiuChang2(userid);
    }
    @Override
    public List<ShenQing> queryLiuChang3(String  userid) {
        return cxdao.queryLiuChang3(userid);
    }
    @Override
    public List<ShenQing> queryLiuChang4(String  userid) {
        return cxdao.queryLiuChang4(userid);
    }

    @Override
    public List<ShenQing> queryLiu(String userid) {
        return cxdao.queryLiu(userid);
    }

    @Override
    public List<User> queryUser(String userrole,String userid) {
        return cxdao.queryUser(userrole,userid);
    }

    @Override
    public List<ShenQing> querylist() {
        return cxdao.querylist();
    }

    @Override
    public Map<String, Object> login(User user) {
        String flag = "0";//0 :用户名错误    1：密码错误  2：登录成功
        Map<String, Object> map =  new  HashMap<>();
        User user2 = cxdao.queryUserByName(user.getUsername());
        if(user2 != null){
            flag = "1";
            if(user2.getPwd().equals(user.getPwd())){
                flag = "2";
                map.put("user2", user2);
            }
        }
        map.put("flag", flag);
        return map;
    }
/**
　　* @Description: 上传
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author 曹鑫
　　* @date 2018-08-14 11:25
　　*/
    @Override
    public String uploadImg(MultipartFile file) throws IOException {
        if (file == null || file.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(file);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");
        return split[0];
    }

    @Override
    public void insertUser(User user) {
        String  uuid= UUID.randomUUID().toString();
        user.setUserid(uuid);
        cxdao.insertUser(user);
    }

    @Override
    public User geren(String userid) {
        return cxdao.geren(userid);
    }

    @Override
    public void insertorig(Caogao caogao) {
        String  uuid= UUID.randomUUID().toString();
        caogao.setXiangid(uuid);
        cxdao.insertorig(caogao);
    }


}
