package com.ll.controller.caoxin;

import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.WoDeProject;
import com.ll.service.caoxin.CXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
/**
　　* @Description: TODO
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author 曹鑫
　　* @date 2018-08-10 16:05 
　　*/
@Controller
@RequestMapping(value = "/caoxin")
public class CaoController {
    @Autowired
    private CXService cxService;
/**
　　* @Description: TODO
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author 曹鑫
　　* @date 2018-08-10 16:05 
　　*/
    @RequestMapping(value = "/show")
    public  String  show(){
        return "xin/originating";
    }
    @RequestMapping(value = "/addor")
    public  String  addor(){
        return "xin/addoriginating";
    }

    @RequestMapping(value = "/queryList")
    @ResponseBody
    public List<WoDeProject> queryList(){
        return cxService.queryList();
    }
    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws
    　　* @author 曹鑫
    　　* @date 2018-08-10 16:15
    　　*/
    //草稿箱
    @RequestMapping(value = "/queryCaogao")
    @ResponseBody
    public JSONObject queryCaogao(Caogao caogao, Integer offset, Integer limit){
        JSONObject json =new JSONObject();
        Long count =cxService.tctota(caogao);
        List<Caogao> user= new ArrayList<Caogao>();
        user=cxService.queryCaogao(caogao,offset,limit);
        json.put("total", count);
        json.put("rows",user);
        return json;
    }
    @RequestMapping(value = "/deleteCaogao")
    @ResponseBody
    public String deleteCaogao(String ids){
         cxService.deleteCaogao(ids);
         return "1";
    }

    @RequestMapping(value = "/insertorig")
    @ResponseBody
    public String insertorig(Caogao caogao){
        cxService.insertorig(caogao);
        return "1";
    }



}
