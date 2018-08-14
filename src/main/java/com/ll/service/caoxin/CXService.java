package com.ll.service.caoxin;

import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.caoxin.WoDeProject;
import com.ll.pojo.lin.ShenQing;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebService;
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
    List<ShenQing> queryCaogao(ShenQing shengqing,Integer offset,Integer limit);
    Long tctota(ShenQing shengqing);


    //草稿箱已提交
    Long tctotas(ShenQing shengqing);
    List<ShenQing> queryshen(ShenQing shengqing, Integer offset, Integer limit);

    void updateProce(String proceid);
}
