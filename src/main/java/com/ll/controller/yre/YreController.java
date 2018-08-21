package com.ll.controller.yre;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.caoxin.User;
import com.ll.pojo.lin.WorkTree;
import com.ll.pojo.yre.*;
import com.ll.service.yre.IYreService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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
    public JSONObject queryMySchedule(Integer offset, Integer limit, HttpServletRequest request){
        return yreService.queryMySchedule(offset,limit,request);
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
    public JSONObject queryMyHoliday(Integer offset,Integer limit,HttpServletRequest request){
        return yreService.queryMyHoliday(offset,limit,request);
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
    public JSONObject queryOvertimeRegistration(Integer offset, Integer limit, JiaBan jiaBan, HttpServletRequest request){

        return yreService.queryOvertimeRegistration(offset,limit,jiaBan,request);
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
    public Integer addOvertimeRegistration(JiaBan jiaBan,HttpServletRequest request){
        yreService.addOvertimeRegistration(jiaBan,request);
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
    public JSONObject queryRavelRegistration(Integer offset,Integer limit,Travel travel, HttpServletRequest request){
        return yreService.queryRavelRegistration(offset,limit,travel,request);
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
    public Integer addTravelRegistration(Travel travel,HttpServletRequest request){
        yreService.addTravelRegistration(travel,request);
        return 1;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws  查询操作日志
    　　* @author 因蓉儿
    　　* @date 2018/8/16 9:51
    　　*/
    @RequestMapping("queryMongodbOperation")
    @ResponseBody
    public JSONObject queryMongodbOperation(Integer offset,Integer limit,OperationPojo operationPojo){
        JSONObject jsonObject = yreService.queryMongodbOperation(offset, limit, operationPojo);
        return jsonObject;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws  考勤机记录查看（分页条件查询）
    　　* @author 因蓉儿
    　　* @date 2018/8/17 15:25
    　　*/
    @RequestMapping("queryKaoQinJiJiLu")
    @ResponseBody
    public JSONObject queryKaoQinJiJiLu(Integer offset,Integer limit,KaoQinJi kaoQinJi){
        JSONObject jsonObject = yreService.queryKaoQinJiJiLu(offset, limit, kaoQinJi);
        return jsonObject;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws  查询部门树
    　　* @author 因蓉儿
    　　* @date 2018/8/18 11:28 
    　　*/
    @RequestMapping("queryDeptTree")
    @ResponseBody
    public List<DeptPojo> queryDeptTree(String id){

        List<DeptPojo> list= yreService.queryDeptTree(id);
        for (DeptPojo deptPojo : list) {
            String id1 = deptPojo.getDeptid();
            List<DeptPojo> queryTree = queryDeptTree(id1);
            if(queryTree!=null &&queryTree.size()>0){
                deptPojo.setNodes(queryTree);
            }
        }
        return  list;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws  查询在岗状态
    　　* @author 因蓉儿
    　　* @date 2018/8/18 18:01
    　　*/
    @RequestMapping("queryOnTheJobStatus")
    @ResponseBody
    public JSONObject queryOnTheJobStatus(Integer offset,Integer limit,Onduty onduty){
        JSONObject jsonObject = yreService.queryOnTheJobStatus(offset, limit, onduty);
        return jsonObject;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws  查询考勤统计
    　　* @author 因蓉儿
    　　* @date 2018/8/18 19:11
    　　*/
    @RequestMapping("queryAttendanceStatistics")
    @ResponseBody
    public JSONObject queryAttendanceStatistics(Integer offset,Integer limit,AttendanceStatistics attendanceStatistics){
        JSONObject jsonObject = yreService.queryAttendanceStatistics(offset, limit, attendanceStatistics);
        return jsonObject;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws  查询考勤设置
    　　* @author 因蓉儿
    　　* @date 2018/8/18 21:38
    　　*/
    @RequestMapping("queryAttendancesetting")
    @ResponseBody
    public JSONObject queryAttendancesetting(Integer offset,Integer limit,Attendancesetting attendancesetting){
        JSONObject jsonObject = yreService.queryAttendancesetting(offset, limit, attendancesetting);
        return jsonObject;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws  查询请假登记
    　　* @author 因蓉儿
    　　* @date 2018/8/20 21:09
    　　*/
    @RequestMapping("queryLeaveRegistration")
    @ResponseBody
    public JSONObject queryLeaveRegistration(Integer offset,Integer limit,QingJia qingJia){
        JSONObject jsonObject = yreService.queryLeaveRegistration(offset, limit, qingJia);
        return jsonObject;
    }


    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws  请假详情
    　　* @author 因蓉儿
    　　* @date 2018/8/21 11:25
    　　*/
    @RequestMapping("queryQingJiaXiangQing")
    public ModelAndView queryQingJiaXiangQing(String qingjiaid){
        ModelAndView mv = new ModelAndView();
        QingJia qingjia1 = yreService.queryQingJiaXiangQing(qingjiaid);
        mv.addObject("qingjia",qingjia1);
        mv.setViewName("yin/qingJiaXiangQing");
        return mv;
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws  新增请假登记
    　　* @author 因蓉儿
    　　* @date 2018/8/21 11:38
    　　*/
    @RequestMapping("addLeaveRegistration")
    @ResponseBody
    public Integer addLeaveRegistration(QingJia qingJia,HttpServletRequest request){
        yreService.addLeaveRegistration(qingJia,request);
        return 1;
    }


}
