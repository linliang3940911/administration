package com.ll.service.lin;

import com.ll.dao.lin.IModelDao;
import com.ll.pojo.lin.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
