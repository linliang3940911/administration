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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class CXServiceImpl implements CXService {
    @Autowired
    private IcxDao cxdao;

    @Override
    public List<WoDeProject> queryList() {
        return cxdao.queryList();
    }

    @Override
    public List<ShenQing> queryCaogao(ShenQing shengqing, Integer offset, Integer limit) {
        return cxdao.queryCaogao(shengqing,offset,limit);
    }

    @Override
    public void deleteCaogao(String ids) {
        cxdao.deleteCaogao(ids);
    }

    @Override
    public Long tctota(ShenQing shengqing) {
        return cxdao.tctota(shengqing);
    }

    @Override
    public Long tctotas(ShenQing shengqing) {
        return cxdao.tctotas(shengqing);
    }

    @Override
    public List<ShenQing> queryshen(ShenQing shengqing, Integer offset, Integer limit) {
        return cxdao.queryshen(shengqing,offset,limit);
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
       shen.setProcerole(str+","+shen.getProcerole());
       shen.setShenhetongguo(" ");
       cxdao.updatebohui(shen);
    }

    @Override
    public List<Procedures> queryrole() {
        return cxdao.queryrole();
    }
    @Override
    public void updatepro(ShenQing shen2){
        String pro = shen2.getProcerole();
        String[] split = pro.split(",");
        String str="";
        if(pro.indexOf(",")!=-1){
            for (int i = 0; i < split.length; i++) {
                shen2.setShenhetongguo(split[0]);
                if(i>0){
                    str += ","+split[i];
                }
            }
            str=str.substring(1);
        }
        System.out.println(str);
        shen2.setProcerole(str);
        cxdao.updatepro(shen2);
    }


    @Override
    public void zhipairen(String zxc,ShenQing shen) {
       String  pro = shen.getProcerole();
        if(pro.indexOf(",") != -1){
            String [] ss = pro.split(",");
            for (int i = 0; i < ss.length; i++) {
                shen.setProcerole(zxc+","+ss[i]);
            }
        }
        if(pro.indexOf(",") == -1){
            shen.setProcerole(zxc);
        }
        cxdao.updatePro(shen);
    }

    @Override
    public List<WorkTree> queryListTree() {
        return cxdao.queryListTree();
    }

    @Override
    public List<ShenQing> queryLiuChang1() {
        return cxdao.queryLiuChang1();
    }
    @Override
    public List<ShenQing> queryLiuChang2() {
        return cxdao.queryLiuChang2();
    }
    @Override
    public List<ShenQing> queryLiuChang3() {
        return cxdao.queryLiuChang3();
    }
    @Override
    public List<ShenQing> queryLiuChang4() {
        return cxdao.queryLiuChang4();
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
