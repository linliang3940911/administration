package com.ll.controller.lin;

import com.ll.service.lin.IModelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sound.midi.spi.SoundbankReader;

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
@RequestMapping("/modle")
public class ModelController {
    @Resource
    private IModelService ModelService;

    @RequestMapping("/querymodle")
    @ResponseBody
    public  void  querymodle(){
        String str=  ModelService.querymodle();
        System.out.println("阿萨德就好使++ "+str);
    }



}
