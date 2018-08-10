package com.ll.service.caoxin;

import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.WoDeProject;

import java.util.List;

public interface CXService {
    List<WoDeProject> queryList();

    List<Caogao> queryCaogao(Caogao caogao,Integer offset,Integer limit);

    void deleteCaogao(String ids);

    Long tctota(Caogao caogao);

    void insertorig(Caogao caogao);
}
