package com.ll.controller.lin;

import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.lin.*;
import com.ll.service.caoxin.CXService;
import com.ll.service.lin.IModelService;
import org.apache.catalina.core.ApplicationFilterConfig;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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
    @Autowired
    private CXService cxService;
    @Autowired
    private SolrClient solrClient;
    @Autowired
    private RedisTemplate  redisTemplate;

    @RequestMapping("queryHomePage")
    public String homepage(HttpServletRequest request,Model modle){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        User use=ModelService.geren(user.getUserid());
        List<ShenQing> list1 = cxService.queryLiu(user.getUserid());
        modle.addAttribute("list",list1);
        modle.addAttribute("use",use);
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
    public  JSONObject queryWork(int offset, int limit,WorkTree  workName){
        List<WorkName> list=ModelService.queryWork(offset,limit,workName);
       long total= ModelService.queryCount(workName);
        JSONObject json=new JSONObject();
        json.put("rows",list);
        json.put("total",total);
        return  json;
    }
    @RequestMapping("attribute")
    public  String attribute(String woid, Model model){

        model.addAttribute("woi",woid);
        return  "lin/Attribute";
    }
    @RequestMapping("commseiForm")
    @ResponseBody
    public  Integer  commseiForm(Attribute attribute){
        String replace = UUID.randomUUID().toString().replace("-", "");
        String[] split = attribute.getAttributename().split(",");
        String[] split1 = attribute.getAttributeType().split(",");
        Attribute attribute1 = new Attribute();
        attribute1.setAttributeid(replace);
        for (int i = 0; i < split.length; i++) {
            attribute1.setAttributename(split[i]);
            attribute1.setAttributeType(split1[i]);
            ModelService.commseiForm(attribute1);
        }
        ModelService.addNameAttributeid(attribute.getWoid(),replace);

    return  1;
    }
    @RequestMapping("addwork")
    public  String addwork(){

        return "lin/addwork";
    }

    @RequestMapping("yanchukuang")
    public String yanchukuang(){

        return  "lin/procedure";
    }
    /**
    * @Description:    查询审核人员
    * @Author:         林亮
    * @CreateDate:     2018/8/13 0013 21:48
    * @UpdateUser:     林亮
    * @UpdateDate:     2018/8/13 0013 21:48
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping("queryProcedurelist")
    @ResponseBody
    public  List<Procedures>  queryProcedurelist(){
        List<Procedures> list=ModelService.queryProcedurelist();
        return list;
    }
    /**
    * @Description:    添加流程表
    * @Author:         林亮
    * @CreateDate:     2018/8/13 0013 23:40
    * @UpdateUser:     林亮
    * @UpdateDate:     2018/8/13 0013 23:40
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping("addWorkName")
    @ResponseBody
    public Integer addWorkName(WorkName workName){
        ModelService.addWorkName(workName);

        return 1;
    }
    /**
    * @Description:    跳转流程页面
    * @Author:         林亮
    * @CreateDate:     2018/8/13 0013 23:41
    * @UpdateUser:     林亮
    * @UpdateDate:     2018/8/13 0013 23:41
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping("/queryListWorkName")
   public String queryListWorkName(){

        return  "lin/procedure";
    }
    /**
    * @Description:   跳转到流程发起
    * @Author:         林亮
    * @CreateDate:     2018/8/14 0014 9:13
    * @UpdateUser:     林亮
    * @UpdateDate:     2018/8/14 0014 9:13
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
   @RequestMapping("/application")
   public  String application(WorkName workName,Model modle){
      List<Attribute> list =  ModelService.application(workName);
        modle.addAttribute("list",list);

        return "lin/application";
    }
    
    /**
    * @Description:    员工申请流程
    * @Author:         林亮
    * @CreateDate:     2018/8/14 0014 13:26
    * @UpdateUser:     林亮
    * @UpdateDate:     2018/8/14 0014 13:26
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping("/addshenqingliycheng")
    @ResponseBody
    public  Integer  addshenqingliycheng(String woid,Integer proceType,HttpServletRequest request,String  dengji){
        ShenQing shenQing = new ShenQing();
        shenQing.setProceType(proceType);
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("loginUser");
        WorkName workName= ModelService.addshenqingliycheng(woid);
        shenQing.setProcerole(workName.getConditio());
        ModelService.addshenqingliychengs(shenQing,user.getUsername(),user.getUserid(),woid);
        System.out.println(dengji);
        return  1;
    }

    /**
     * @Description:    跳转网盘页面
     * @Author:         林亮
     * @CreateDate:     2018/8/15 0015 9:40
     * @UpdateUser:     林亮
     * @UpdateDate:     2018/8/15 0015 9:40
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @RequestMapping("/wangpan")
    public String wangpan(){

        return  "lin/wangpan";
    }
    /**
     * @Description:    网盘内容查询
     * @Author:         林亮
     * @CreateDate:     2018/8/15 0015 9:42
     * @UpdateUser:     林亮
     * @UpdateDate:     2018/8/15 0015 9:42
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @RequestMapping("/querylistWangPan")
    @ResponseBody
    public  JSONObject querylistWangPan(int offset, int limit, Wangpan wangpan){
        if(wangpan.getId()==null&&!"".equals(wangpan.getId())){
            wangpan.setId(0);
            JSONObject json=ModelService.querylistWangPan(offset,limit,wangpan);
        }
        JSONObject json=ModelService.querylistWangPan(offset,limit,wangpan);
        return  json;
    }

    /**
     * @Description:    添加网盘目录
     * @Author:         林亮
     * @CreateDate:     2018/8/15 0015 18:27
     * @UpdateUser:     林亮
     * @UpdateDate:     2018/8/15 0015 18:27
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @RequestMapping("/addpackages")
    @ResponseBody
    public Integer  addpackages(Wangpan wangpan){
        ModelService.addpackages(wangpan);

        return 1;
    }

    // uploadFile
    @RequestMapping("/uploadFile")
    @ResponseBody
    public void uploadFile(MultipartFile myfile,Wangpan wangpan,
                           HttpServletRequest request,HttpServletResponse response)throws IOException {
        // 原始名称
        String oldFileName = myfile.getOriginalFilename(); // 获取上传文件的原名
        System.out.println(oldFileName);
        Date date = new Date();
        String uploadImg = ModelService.uploadImg(myfile);
        wangpan.setUrl(uploadImg);
        wangpan.setText(oldFileName);
        wangpan.setUpddate(date);
        ModelService.adduploadFile(wangpan);
    }
    /**
     * @Description:    跳转签到日历
     * @Author:         林亮
     * @CreateDate:     2018/8/17 0017 17:02
     * @UpdateUser:     林亮
     * @UpdateDate:     2018/8/17 0017 17:02
     * @UpdateRemark:   修改内容
     * @Version:        1.0
     */
    @RequestMapping("/qiandaorili")
    public  String qiandaorili(){

        return "lin/qiandao";
    }
    @RequestMapping("/addTime")
    @ResponseBody
    public Integer addTime(HttpServletRequest request){
        User user2 = (User)request.getSession().getAttribute("loginUser");
        SimpleDateFormat formatter =new SimpleDateFormat("yyyy-MM-dd");
        String format = formatter.format(new Date());
        KaoQinJi user= ModelService.queryUserList(user2.getUserid(),new Date(),format);
        KaoQinJi kaoQinJi = new KaoQinJi();
        kaoQinJi.setUserid(user2.getUserid());
        String replace = UUID.randomUUID().toString().replace("-", "");
        if(user!=null){
            kaoQinJi.setPmdowndakashijian(new Date());
            ModelService.updateKaoQinJi(kaoQinJi,user.getUserid(),format);
        }else {
            kaoQinJi.setKaoqinid(replace);
            kaoQinJi.setAmupdakashijian(new Date());
            ModelService.addTime(kaoQinJi);

        }
        return 1;
    }


    @RequestMapping("/queryKaoqinji")
    @ResponseBody
    public List<KaoQinJi> queryKaoqinji(HttpServletRequest request){
        User user2 = (User)request.getSession().getAttribute("loginUser");
        List<KaoQinJi> list= ModelService.queryKaoqinji(user2.getUserid());
        return list;
    }

    /**
    * @Description:    删除网盘内容
    * @Author:         林亮
    * @CreateDate:     2018/8/20 0020 19:01
    * @UpdateUser:     林亮
    * @UpdateDate:     2018/8/20 0020 19:01
    * @UpdateRemark:   修改内容
    * @Version:        1.0
    */
    @RequestMapping("/deleteByIdWangPan")
    @ResponseBody
    public  Integer deleteByIdWangPan(Wangpan wangpan){
        ModelService.deleteByIdWangPan(wangpan);
        return 1;
    }





}
