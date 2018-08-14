package com.ll.controller.yre;

import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.yre.*;
import com.ll.service.yre.IYreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("yreController")
public class YreController {

    @Resource
    private IYreService yreService;

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws 分页查询上下班登记
    　　* @author 因蓉儿
    　　* @date 2018/8/11 10:38
    　　*/
    @RequestMapping("queryRegistration")
    @ResponseBody
    public JSONObject queryRegistration(Integer offset,Integer limit,Commute commute){
        return yreService.queryRegistration(offset,limit,commute);
    }

    /**
     　　* @Description: TODO
     　　* @param ${tags}
     　　* @return ${return_type}
     　　* @throws 去addReason.jsp说明情况页面
     　　* @author 因蓉儿
     　　* @date 2018/8/11 11:11
     　　*/
    @RequestMapping("addReasonById")
    public ModelAndView addReasonById(String commuteid){
        ModelAndView mv = new ModelAndView();
        Commute commute = yreService.addReasonById(commuteid);
        mv.addObject("commute",commute);
        mv.setViewName("yin/addReason");
        return mv;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws 新增书说明情况
    　　* @author 因蓉儿
    　　* @date 2018/8/11 15:39
    　　*/
    @RequestMapping("addReason2")
    @ResponseBody
    public Integer addReason2(Commute commute){
        yreService.addReason2(commute);
        return 1;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws 分页查询上下班登记<我的考勤管理(我的排班表/我的考勤)>
    　　* @author 因蓉儿
    　　* @date 2018/8/11 17:59
    　　*/
    @RequestMapping("queryMySchedule")
    @ResponseBody
    public JSONObject queryMySchedule(Integer offset,Integer limit,KaoQinBanCi kaoqinbanci){
        return yreService.queryMySchedule(offset,limit,kaoqinbanci);
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws 分页查询上下班登记<我的考勤管理(我的假期)>
    　　* @author 因蓉儿
    　　* @date 2018/8/11 17:59
    　　*/
    @RequestMapping("queryMyHoliday")
    @ResponseBody
    public JSONObject queryMyHoliday(Integer offset,Integer limit,Holiday holiday){
        return yreService.queryMyHoliday(offset,limit,holiday);
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type}
    　　* @throws 分页查询加班登记
    　　* @author 因蓉儿
    　　* @date 2018/8/13 19:08 
    　　*/
    @RequestMapping("queryOvertimeRegistration")
    @ResponseBody
    public JSONObject queryOvertimeRegistration(Integer offset,Integer limit,JiaBan jiaBan){
        return yreService.queryOvertimeRegistration(offset,limit,jiaBan);
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws   查询加班登记详情
    　　* @author 因蓉儿
    　　* @date 2018/8/13 19:36 
    　　*/
    @RequestMapping("queryxiangqing")
    public ModelAndView queryxiangqing(String jiabanid){
        ModelAndView mv = new ModelAndView();
        JiaBan jiaBan = yreService.queryxiangqing(jiabanid);
        mv.addObject("jb",jiaBan);
        mv.setViewName("yin/xiangqing");
        return mv;
    }

    /**
     　　* @Description: TODO
     　　* @param ${tags}
     　　* @return ${return_type}
     　　* @throws 添加登记
     　　* @author 因蓉儿
     　　* @date 2018/8/13 23:26
     　　*/
    @RequestMapping("addOvertimeRegistration")
    @ResponseBody
    public Integer addOvertimeRegistration(JiaBan jiaBan){
        yreService.addOvertimeRegistration(jiaBan);
        return 1;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws  分页查询出差登记
    　　* @author 因蓉儿
    　　* @date 2018/8/14 15:29
    　　*/
    @RequestMapping("queryRavelRegistration")
    @ResponseBody
    public JSONObject queryRavelRegistration(Integer offset,Integer limit,Travel travel){
        return yreService.queryRavelRegistration(offset,limit,travel);
    }

    /**
     　　* @Description: TODO
     　　* @param ${tags}
     　　* @return ${return_type}
     　　* @throws  出差详情travelXiangQing.jsp
     　　* @author 因蓉儿
     　　* @date 2018/8/14 15:54
     　　*/
    @RequestMapping("queryTravelXiangQing")
    public ModelAndView queryTravelXiangQing(String travelid){
        ModelAndView mv = new ModelAndView();
        Travel travel = yreService.queryTravelXiangQing(travelid);
        mv.addObject("travel",travel);
        mv.setViewName("yin/travelXiangQing");
        return mv;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws  新增出差登记
    　　* @author 因蓉儿
    　　* @date 2018/8/14 19:43
    　　*/
    @RequestMapping("addTravelRegistration")
    @ResponseBody
    public Integer addTravelRegistration(Travel travel){
        yreService.addTravelRegistration(travel);
        return 1;
    }


}
