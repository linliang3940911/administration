package com.ll.service.lin;

import com.ll.dao.lin.IModelDao;
import com.ll.pojo.lin.WorkName;
import com.ll.pojo.lin.WorkTree;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<WorkName> queryWork(int offset, int limit,String url) {
        List<WorkName> list=ModelDao.queryWork(offset, limit,url);

        return list;
    }

    @Override
    public long queryCount(String url) {

        long str=ModelDao.queryCount(url);
        return str;
    }
}
