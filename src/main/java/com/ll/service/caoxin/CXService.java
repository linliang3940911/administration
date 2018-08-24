package com.ll.service.caoxin;

import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.caoxin.WoDeProject;
import com.ll.pojo.lin.Procedures;
import com.ll.pojo.lin.ShenQing;
import com.ll.pojo.lin.WorkTree;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CXService {
    List<WoDeProject> queryList();
    void deleteCaogao(String ids);
    void insertorig(Caogao caogao);


    Map<String,Object> login(User user);

    String uploadImg(MultipartFile imgs) throws IOException;

    void insertUser(User user);
    User geren(String userid);


//草稿箱未提交
    List<ShenQing> queryCaogao(Integer offset,Integer limit,String userid);
    Long tctota(String userid);


    //草稿箱已提交
    Long tctotas(String userid);
    List<ShenQing> queryshen( Integer offset, Integer limit,String userid);

    void updateProce(String proceid);

    ShenQing xiangqing(String proceid);

    ShenQing tongguo(String proceid);

    void updatepro(ShenQing shen);

    List<ShenQing> queryShenqing();

    List<ShenQing> queryCaoGao();

    void updatebohui(ShenQing shen);

    void zhipairen(String zxc,ShenQing shen,String  usid);

    List<WorkTree> queryListTree();

    List<ShenQing> queryLiuChang1(String  userid);

    List<ShenQing> queryLiuChang2(String  userid);

    List<ShenQing> queryLiuChang3(String  userid);

    List<ShenQing> queryLiuChang4(String  userid);

    List<ShenQing> queryLiu(String userid);

    List<User> queryUser(String userrole,String userid);

    List<ShenQing> querylist();
}
