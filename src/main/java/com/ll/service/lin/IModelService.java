package com.ll.service.lin;

import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.lin.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/8 0008$ 21:13$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/8 0008$ 21:13$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public interface IModelService {
    String querymodle();

    List<WorkTree> getQueryTree(Integer id);

    List<WorkName> queryWork(int offset, int limit,WorkTree  workName);

    long queryCount(WorkTree  workName);

    void commseiForm(Attribute attribute1);

    void addNameAttributeid(String woid, String replace);

    List<Procedures> queryProcedurelist();

    void addWorkName(WorkName workName);

    List<Attribute>  application(WorkName workName);

    WorkName addshenqingliycheng(String woid);

    void addshenqingliychengs(ShenQing shenQing,String username,String userid,String woid);

    JSONObject querylistWangPan(int offset ,int limit, Wangpan wangpan);

    void addpackages(Wangpan wangpan);


    String uploadImg (MultipartFile myfile)throws IOException;

    void adduploadFile(Wangpan wangpan);

    KaoQinJi queryUserList(String userid,Date date,String format);

    void updateKaoQinJi(KaoQinJi kaoQinJi,String replace,String format);

    void addTime(KaoQinJi kaoQinJi);


    List<KaoQinJi> queryKaoqinji(String userid);

    User geren(String userid);

    void deleteByIdWangPan(Wangpan wangpan);
}
