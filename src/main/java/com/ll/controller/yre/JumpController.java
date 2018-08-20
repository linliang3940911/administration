package com.ll.controller.yre;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("jumpController")
public class JumpController {

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws 去registrationCommuting.jsp<上下班登记>展示页面
    　　* @author 因蓉儿
    　　* @date 2018/8/11 10:58
    　　*/
    @RequestMapping("toRegistrationCommuting")
    public String toRegistrationCommuting(){
        return "yin/registrationCommuting";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws 去attendanceManagement.jsp<我的考勤管理>展示页面
    　　* @author 因蓉儿
    　　* @date 2018/8/11 17:07
    　　*/
    @RequestMapping("toAttendanceManagement")
    public String toAttendanceManagement(){
        return "yin/attendanceManagement";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws  去myAttendanceManagementLeft.jsp<我的考勤管理>左边展示页面
    　　* @author 因蓉儿
    　　* @date 2018/8/13 14:17
    　　*/
    @RequestMapping("toMyAttendanceManagementLeft")
    public String toMyAttendanceManagementLeft(){
        return "yin/myAttendanceManagementLeft";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws 我的考勤
    　　* @author 因蓉儿
    　　* @date 2018/8/13 14:24
    　　*/
    @RequestMapping("toMyAttendance")
    public String toMyAttendance(){
        return "yin/myAttendance";
    }
    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws 我的假期
    　　* @author 因蓉儿
    　　* @date 2018/8/13 14:24
    　　*/
    @RequestMapping("toMyHoliday")
    public String toMyHoliday(){
        return "yin/myHoliday";
    }
    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws 我的排位表
    　　* @author 因蓉儿
    　　* @date 2018/8/13 14:24
    　　*/
    @RequestMapping("toMySchedule")
    public String toMySchedule(){
        return "yin/mySchedule";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws 去加班登记<overtimeRegistration.jsp>页面
    　　* @author 因蓉儿
    　　* @date 2018/8/13 19:15
    　　*/
    @RequestMapping("toOvertimeRegistration")
    public String toOvertimeRegistration(){
        return "yin/overtimeRegistration";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws 加班登记页面<addOvertimeRegistration.jsp>
    　　* @author 因蓉儿
    　　* @date 2018/8/13 21:00 
    　　*/
    @RequestMapping("toAddOvertimeRegistration")
    public String toAddOvertimeRegistration(){
        return "yin/addOvertimeRegistration";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws 去  出差登记页面travelRegistration.jsp
    　　* @author 因蓉儿
    　　* @date 2018/8/14 15:41
    　　*/
    @RequestMapping("toTravelRegistration")
    public String toTravelRegistration(){
        return "yin/travelRegistration";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws  出差登记页面
    　　* @author 因蓉儿
    　　* @date 2018/8/14 19:39
    　　*/
    @RequestMapping("toAddTravelRegistration")
    public String toAddTravelRegistration(){
        return "yin/addTravelRegistration";
    }

    @RequestMapping("toOperationLog")
    public String toOperationLog(){
        return "yin/operationLog";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws 去考勤机记录kaoQinJiJiLu.jsp页面
    　　* @author 因蓉儿
    　　* @date 2018/8/17 15:43 
    　　*/
    @RequestMapping("toKaoQinJiJiLu")
    public String toKaoQinJiJiLu(){
        return "yin/kaoQinJiJiLu";
    }


    /**
    　　* @Description: TODO
    　　* @param ${tags} 
    　　* @return ${return_type} 
    　　* @throws  去surveyRecords.jsp 查询记录
    　　* @author 因蓉儿
    　　* @date 2018/8/18 15:13
    　　*/
    @RequestMapping("toSurveyRecords")
    public String toSurveyRecords(){
        return "yin/surveyRecords";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws  去 onTheJobStatus.jsp 在岗状态页面
    　　* @author 因蓉儿
    　　* @date 2018/8/18 18:11
    　　*/
    @RequestMapping("toOnTheJobStatus")
    public String toOnTheJobStatus(){
        return "yin/onTheJobStatus";
    }


    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws  去考勤统计 attendanceStatistics.jsp 页面
    　　* @author 因蓉儿
    　　* @date 2018/8/18 19:11
    　　*/
    @RequestMapping("toAttendanceStatistics")
    public String toAttendanceStatistics(){
        return "yin/attendanceStatistics";
    }

    /**
    　　* @Description: TODO
    　　* @param ${tags}
    　　* @return ${return_type}
    　　* @throws 去 attendanceSetting.jsp 考勤设置页面
    　　* @author 因蓉儿
    　　* @date 2018/8/18 21:44
    　　*/
    @RequestMapping("toAttendanceSetting")
    public String toAttendanceSetting(){
        return "yin/attendanceSetting";
    }

}
