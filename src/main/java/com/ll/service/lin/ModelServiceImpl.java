package com.ll.service.lin;

import com.alibaba.fastjson.JSONObject;
import com.ll.dao.lin.IModelDao;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.lin.*;
import com.ll.util.OSSClientUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/8 0008$ 21:14$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/8 0008$ 21:14$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Service
public class ModelServiceImpl  implements  IModelService{
    @Resource
    private IModelDao ModelDao;

    @Override
    public String querymodle() {
        String str=  ModelDao.querymodle();

        return str;
    }

    @Override
    public List<WorkTree> getQueryTree(Integer id) {
        List<WorkTree>  list= ModelDao.getQueryTree(id);

        return list;
    }

    @Override
    public List<WorkName> queryWork(int offset, int limit,WorkTree  workName) {
        List<WorkName> list=null;
        if(workName.getUrl()!=null&& !"".equals(workName.getUrl())){
            list=ModelDao.queryWorks(offset, limit,workName);


        }else {
            list=ModelDao.queryWork(offset, limit,workName);
        }


            return list;
    }

    @Override
    public long queryCount(WorkTree  workName) {
        long str=0;
        if(workName.getUrl()!=null&& !"".equals(workName.getUrl())){
            str= ModelDao.queryCounts(workName);


        }else {
            str=ModelDao.queryCount(workName);
        }


        return str;
    }

    @Override
    public void commseiForm(Attribute attribute1) {
        ModelDao.commseiForm(attribute1);
    }

    @Override
    public void addNameAttributeid(String woid, String replace) {
        ModelDao.addNameAttributeid(woid,replace);
    }

    @Override
    public List<Procedures> queryProcedurelist() {
        List<Procedures> list=ModelDao.queryProcedurelist();
        return list;
    }

    @Override
    public void addWorkName(WorkName workName) {
        String replace = UUID.randomUUID().toString().replace("-", " ");
        workName.setWoid(replace);

        ModelDao.addWorkName(workName);
    }

    @Override
    public  List<Attribute>  application(WorkName workName) {
        List<Attribute>  workName1=ModelDao.application(workName);

        return workName1;
    }

    @Override
    public WorkName addshenqingliycheng(String woid) {
        WorkName workName=  ModelDao.addshenqingliycheng(woid);
        return workName;
    }



    @Override
    public void addshenqingliychengs(ShenQing shenQing,String username,String userid,String woid) {
        String replace = UUID.randomUUID().toString().replace("-", "");
        shenQing.setProceid(replace);
        shenQing.setProceuser(username);
        shenQing.setUserid(userid);
        shenQing.setWoid(woid);
        ModelDao.addshenqingliychengs(shenQing);
    }

    @Override
    public JSONObject querylistWangPan(int offset ,int limit, Wangpan wangpan) {
        JSONObject json=new JSONObject();
        List<Wangpan>  list=new ArrayList<>();

        if(wangpan.getPid()!=null&&!"".equals(wangpan.getPid())){

            list=ModelDao.querylistWangPans(offset,limit,wangpan.getPid());
        }else {
            list=ModelDao.querylistWangPan(offset,limit,wangpan);
        }
        long total=ModelDao.querycon(wangpan);
        json.put("rows",list);
        json.put("total",total);
        return json;
    }

    @Override
    public void addpackages(Wangpan wangpan) {
        Date date = new Date();
        wangpan.setUpddate(date);
        wangpan.setAllname("文件夹");
        wangpan.setUrl("http://cx-0-oss.oss-cn-beijing.aliyuncs.com/cx-img/1534329622082.jpg");
        ModelDao.addpackages(wangpan);
    }

    @Override
    public String uploadImg(MultipartFile myfile)throws IOException{
        if (myfile == null || myfile.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(myfile);
        String imgUrl = ossClient.getImgUrl(name);
        String[] split = imgUrl.split("\\?");

        return split[0];
    }

    @Override
    public void adduploadFile(Wangpan wangpan) {
        ModelDao.adduploadFile(wangpan);


    }

    @Override
    public KaoQinJi queryUserList(String userid,Date date,String format) {
        KaoQinJi user=ModelDao.queryUserList(userid,date,format);
        return user;
    }

    @Override
    public void updateKaoQinJi(KaoQinJi kaoQinJi,String replace,String format) {
        ModelDao.updateKaoQinJi(kaoQinJi,replace,format);
    }

    @Override
    public void addTime(KaoQinJi kaoQinJi) {
        ModelDao.addTime(kaoQinJi);
    }

    @Override
    public List<KaoQinJi> queryKaoqinji(String userid) {
        List<KaoQinJi> list=ModelDao.queryKaoqinji(userid);

        return list;
    }

    @Override
    public User geren(String userid) {
        User user=ModelDao.geren(userid);
        return user;
    }

    @Override
    public void deleteByIdWangPan(Wangpan wangpan) {
        ModelDao.deleteByIdWangPan(wangpan);
    }
}
