package com.ll.controller.lin;

import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.lin.WorkName;
import com.ll.pojo.lin.WorkTree;
import com.ll.service.lin.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: 林亮
 * @CreateDate: 2018/8/8 0008$ 21:12$
 * @UpdateUser: 林亮
 * @UpdateDate: 2018/8/8 0008$ 21:12$
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Controller
@RequestMapping("modle")
public class ModelController {


    @Autowired
    private IModelService ModelService;
    @RequestMapping("queryHomePage")
    public String homepage(){


        return "index";
    }
   
    @RequestMapping("buzhi")
    public String buzhi(){


        return "lin/work";
    }
    /**
    * @Description:    工作流程--流程分类表
    * @Author:         林亮
    * @CreateDate:     2018/8/11 0011 15:27
    * @UpdateUser:     林亮
    * @UpdateDate:     2018/8/11 0011 15:27
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping("queryList")
    @ResponseBody
    public  List<WorkTree>  queryList(){
        Integer id=0;

        return   getQueryTree(id);
    }
    public List<WorkTree> getQueryTree(Integer id){
        List<WorkTree> list= ModelService.getQueryTree(id);
        for (WorkTree workTree : list) {
            Integer id1 = workTree.getId();
            List<WorkTree> queryTree = getQueryTree(id1);
            if(queryTree!=null &&queryTree.size()>0){
                workTree.setNodes(queryTree);
            }
        }
        return  list;
    }
    /**
    * @Description:    查询工作报表
    * @Author:         林亮
    * @CreateDate:     2018/8/11 0011 16:15
    * @UpdateUser:     林亮
    * @UpdateDate:     2018/8/11 0011 16:15
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping("queryWork")
    @ResponseBody
    public  JSONObject queryWork(int offset, int limit,String url){
        List<WorkName> list=ModelService.queryWork(offset,limit,url);
       long total= ModelService.queryCount(url);
        JSONObject json=new JSONObject();
        json.put("rows",list);
        json.put("total",total);
        return  json;
    }




}
