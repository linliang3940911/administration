package com.ll.service.caoxin;

import com.ll.dao.caoxin.IcxDao;
import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.WoDeProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
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
    public List<Caogao> queryCaogao(Caogao caogao, Integer offset, Integer limit) {
        return cxdao.queryCaogao(caogao,offset,limit);
    }

    @Override
    public void deleteCaogao(String ids) {
        cxdao.deleteCaogao(ids);
    }

    @Override
    public Long tctota(Caogao caogao) {
        return cxdao.tctota(caogao);
    }

    @Override
    public void insertorig(Caogao caogao) {
        String  uuid= UUID.randomUUID().toString();
        caogao.setXiangid(uuid);
        Date date =new Date();
        caogao.setBainjishiqi(date);
        cxdao.insertorig(caogao);
    }


}
