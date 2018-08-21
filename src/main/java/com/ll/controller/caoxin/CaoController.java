package com.ll.controller.caoxin;

import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.caoxin.Caogao;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.caoxin.WoDeProject;
import com.ll.pojo.lin.Procedures;
import com.ll.pojo.lin.ShenQing;
import com.ll.pojo.lin.WorkTree;
import com.ll.service.caoxin.CXService;
import com.ll.util.ExportExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public JSONObject queryCaogao(Integer offset, Integer limit,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        JSONObject json =new JSONObject();
        Long count =cxService.tctota(user.getUserid());
        List<ShenQing> list=cxService.queryCaogao(offset,limit,user.getUserid());
        json.put("total", count);
        json.put("rows",list);
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
    public JSONObject queryshen( Integer offset, Integer limit,HttpServletRequest request){
        JSONObject json =new JSONObject();
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        String userid=user.getUserid();
        Long count =cxService.tctotas(userid);
        List<ShenQing> list=cxService.queryshen(offset,limit,userid);
        json.put("total", count);
        json.put("rows",list);
        return  json;
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
        return "xin/denglu";
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
    /**   跳到驳回页面
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 曹鑫
    　　* @date 2018-08-15 10:52
    　　*/
    @RequestMapping("/bohuilist")
    public  String  bohui(){
        return  "xin/bohui";
    }
    /**    驳回列表
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 曹鑫
    　　* @date 2018-08-15 11:00
    　　*/
    @RequestMapping("/queryBoHui")
    @ResponseBody
    public   String  queryBoHui(){
        return   null;
    }
    @RequestMapping("xiangqing")
    public String  xiangqing(String  proceid,Model model){
        ShenQing  shen=cxService.xiangqing(proceid);
        model.addAttribute("shen",shen);
        return "xin/xiangqing";
    }
    /**   审核流程页面
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws
    　　* @author 曹鑫
    　　* @date 2018-08-15 15:42
    　　*/
    @RequestMapping("/shenhe")
    public  String  shenhe(){
        return "xin/shenhe";
    }

    @RequestMapping("/tongguo")
    @ResponseBody
    public  String  tongguo(String  proceid){
        ShenQing shen = cxService.tongguo(proceid);
        cxService.updatepro(shen);
        return  "success";
    }
    @RequestMapping("/bohui")
    @ResponseBody
    public String  bohui(String  proceid){
        ShenQing shen = cxService.tongguo(proceid);
        if(shen.getShenhetongguo().equals("")){
            return  "susecc";
        }
        cxService.updatebohui(shen);
        return  "susecc";
    }



    //申请表导出
    @RequestMapping("querydaochulist")
    @ResponseBody
    public String DataService(HttpServletResponse  response) {
        List<ShenQing> list1 = cxService.queryShenqing();
        String path="E:\\qytjdy.xls";
        try {
            String title="申请表";
            String [] rowname= {"序号","申请人","申请编号","申请时间","审核人"};
            System.err.println(list1);
            List<Object[]> arrobj =new ArrayList<Object[]>();
            Object[] objs =null;
            for (int i = 0; i < list1.size(); i++) {
                ShenQing qy= new ShenQing();
                qy=list1.get(i);
                objs=new Object[rowname.length];
                objs[0]=qy.getProceuser();
                objs[1]=qy.getProceuser();
                objs[2]=qy.getProceid();
                objs[3]=qy.getProcedate();
                objs[4]=qy.getRoletext();
                arrobj.add(objs);
            }
            ExportExcel export=new ExportExcel(title,rowname,arrobj,path,response);
            export.export();
        } catch (Exception e) {
        }
        return "1";
    }



    //草稿表导出
    @RequestMapping("queryCaoGao")
    @ResponseBody
    public String queryCaoGao(HttpServletResponse  response) {
        List<ShenQing> list1 = cxService.queryCaoGao();
        String path="E:\\caogao.xls";
        try {
            String title="草稿表";
            String [] rowname= {"序号","申请人","申请编号","申请时间","审核人"};
            System.err.println(list1);
            List<Object[]> arrobj =new ArrayList<Object[]>();
            Object[] objs =null;
            for (int i = 0; i < list1.size(); i++) {
                ShenQing qy= new ShenQing();
                qy=list1.get(i);
                objs=new Object[rowname.length];
                objs[0]=qy.getProceuser();
                objs[1]=qy.getProceuser();
                objs[2]=qy.getProceid();
                objs[3]=qy.getProcedate();
                objs[4]=qy.getRoletext();
                arrobj.add(objs);
            }
            ExportExcel export=new ExportExcel(title,rowname,arrobj,path,response);
            export.export();
        } catch (Exception e) {
        }
        return "1";
    }
    @RequestMapping("/zhipai")
    public   String  zhipai(Model  model,String proceid){
        List<Procedures> list1 = cxService.queryrole();
        model.addAttribute("list",list1);
        ShenQing shen = cxService.tongguo(proceid);
        model.addAttribute("shen",shen);
        return "xin/role";
    }
    @RequestMapping("/queryLiu")
    public  String  queryLiu(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        List<ShenQing> list1 = cxService.queryLiu(user.getUserid());
        model.addAttribute("list",list1);
        return "index";
    }
    @RequestMapping("/zhipairen")
    @ResponseBody
    public   String  zhipairen(String  zxc,String proceid){
       ShenQing shen = cxService.tongguo(proceid);
        cxService.zhipairen(zxc,shen);
        return "success";
    }

    @RequestMapping("/queryListTree")
    @ResponseBody
    public  List<WorkTree>  queryListTree(){
        List<WorkTree> listTree=cxService.queryListTree();
        return listTree;
    }

    @RequestMapping("/queryLiuChang1")
    @ResponseBody
    public  List<ShenQing>  queryLiuChang1(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        List<ShenQing> listTree=cxService.queryLiuChang1(user.getUserid());
        return  listTree;
    }
    @RequestMapping("/queryLiuChang2")
    @ResponseBody
    public  List<ShenQing>  queryLiuChang2(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        List<ShenQing> listTree=cxService.queryLiuChang2(user.getUserid());
        return  listTree;
    }
    @RequestMapping("/queryLiuChang3")
    @ResponseBody
    public  List<ShenQing>  queryLiuChang3(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        List<ShenQing> listTree=cxService.queryLiuChang3(user.getUserid());
        return  listTree;
    }
    @RequestMapping("/queryLiuChang4")
    @ResponseBody
    public  List<ShenQing>  queryLiuChang4(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        List<ShenQing> listTree=cxService.queryLiuChang4(user.getUserid());
        return  listTree;
    }
    @RequestMapping("/jinji")
    public  String   jinji(){
        return "xin/jinji";
    }
    @RequestMapping("/zhongyao")
    public  String   zhongyao(){
        return "xin/zhongyao";
    }
    @RequestMapping("/putong")
    public  String   putong(){
        return "xin/putong";
    }
    @RequestMapping("/qita")
    public  String   qita(){
        return "xin/qita";
    }
    @RequestMapping("/daiban")
    public  String  daiban(){
        return "xin/daiban";
    }
}
