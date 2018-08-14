package com.ll.controller.caoxin;

import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.caoxin.WoDeProject;
import com.ll.pojo.lin.ShenQing;
import com.ll.service.caoxin.CXService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/addor")
    public  String  addor(){
        return "xin/addoriginating";
    }
    //查询登录页面
    @RequestMapping(value = "/denglu")
    public String denglu(){
        return "xin/denglu";
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
    //草稿箱未提交
    @RequestMapping(value = "/show")
    public  String  show(){
        return "xin/originating";
    }
    @RequestMapping(value = "/queryCaogao")
    @ResponseBody
    public JSONObject queryCaogao(ShenQing shengqing, Integer offset, Integer limit){
        JSONObject json =new JSONObject();
        Long count =cxService.tctota(shengqing);
        List<ShenQing> user= new ArrayList<ShenQing>();
        user=cxService.queryCaogao(shengqing,offset,limit);
        json.put("total", count);
        json.put("rows",user);
        return  json;
    }

    @RequestMapping(value = "/updateProce")
    @ResponseBody
    public  String  updateProce(String  proceid){
        cxService.updateProce(proceid);
        return  "success";
    }



    //申请表已提交
    @RequestMapping(value = "/shenqing")
    public  String  shenqing(){
        return "xin/shenqing";
    }

    @RequestMapping(value = "/queryshen")
    @ResponseBody
    public JSONObject queryshen(ShenQing shengqing, Integer offset, Integer limit){
        JSONObject json =new JSONObject();
        Long count =cxService.tctotas(shengqing);
        List<ShenQing> user= new ArrayList<ShenQing>();
        user=cxService.queryshen(shengqing,offset,limit);
        json.put("total", count);
        json.put("rows",user);
        return  json;
    }



    //草稿箱  批删
    @RequestMapping(value = "/deleteCaogao")
    @ResponseBody
    public String deleteCaogao(String ids){
         cxService.deleteCaogao(ids);
         return "1";
    }
    //新增
    @RequestMapping(value = "/insertorig")
    @ResponseBody
    public String insertorig(Caogao caogao){
        cxService.insertorig(caogao);
        return "1";
    }
    /** 登录
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 曹鑫
    　　* @date 2018-08-14 9:57
    　　*/
    @RequestMapping(value = "/queryUser")
    @ResponseBody
    public String login(User user,HttpServletRequest request){
        Map<String, Object> map = cxService.login(user);
        User user2 = (User) map.get("user2");
        if(user2 != null){
            request.getSession().setAttribute("loginUser", user2);
        }
        return map.get("flag").toString();
    }
    /**  注册页面
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 曹鑫
    　　* @date 2018-08-14 10:46
    　　*/

    @RequestMapping(value ="/adduser")
    public  String  adduser(){

        return  "xin/adduser";
    }
    /** 注册
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 曹鑫
    　　* @date 2018-08-14 11:41
    　　*/
    @RequestMapping(value ="/insertUser")
    @ResponseBody
    public  String  insertUser(User user){
        cxService.insertUser(user);
        return  "success";
    }

    /**
     * controller
     * uploadify--oss--图片上传
     * @param imgs
     * @param request
     * @param response
     * @return
     * @throws IOException  抛异常
     */
    @RequestMapping("/uploadImg")
    @ResponseBody
    public  String uploadImg(MultipartFile imgs,
                             HttpServletRequest request,HttpServletResponse response) throws IOException {
        String uploadImg = cxService.uploadImg(imgs);
        System.out.println(uploadImg);

        return uploadImg ;
    }
    /**  登出退出
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 曹鑫
    　　* @date 2018-08-14 19:28
    　　*/
    @RequestMapping("/dengchu")
    public  String  dengchu(HttpServletRequest request){
        request.removeAttribute("loginUser");
        return "xin/login/denglu";
    }
    /**  个人中心回显
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 曹鑫
    　　* @date 2018-08-14 19:28
    　　*/
    @RequestMapping("/gerenxinxi")
    public   String   geren(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        User user3=cxService.geren(user.getUserid());
        request.setAttribute("user",user3);
        return "xin/geren";
    }
}
