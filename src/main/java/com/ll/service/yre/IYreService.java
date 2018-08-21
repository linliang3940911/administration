package com.ll.service.yre;

import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.yre.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IYreService {
    JSONObject queryRegistration(Integer offset, Integer limit, Commute commute);

    Commute addReasonById(String commuteid);

    void addReason2(Commute commute);

    JSONObject queryMySchedule(Integer offset, Integer limit, HttpServletRequest request);

    JSONObject queryMyHoliday(Integer offset, Integer limit, HttpServletRequest request);

    JSONObject queryOvertimeRegistration(Integer offset, Integer limit, JiaBan jiaBan, HttpServletRequest request);

    JiaBan queryxiangqing(String jiabanid);

    void addOvertimeRegistration(JiaBan jiaBan, HttpServletRequest request);

    JSONObject queryRavelRegistration(Integer offset, Integer limit, Travel travel, HttpServletRequest request);

    Travel queryTravelXiangQing(String travelid);

    void addTravelRegistration(Travel travel, HttpServletRequest request);

    void operationLog(String operationMethod);

    JSONObject queryMongodbOperation(Integer offset, Integer limit, OperationPojo operationPojo);

    JSONObject queryKaoQinJiJiLu(Integer offset, Integer limit, KaoQinJi kaoQinJi);

    List<DeptPojo> queryDeptTree(String id);

    JSONObject queryOnTheJobStatus(Integer offset, Integer limit, Onduty onduty);

    JSONObject queryAttendanceStatistics(Integer offset, Integer limit, AttendanceStatistics attendanceStatistics);

    JSONObject queryAttendancesetting(Integer offset, Integer limit, Attendancesetting attendancesetting);

    JSONObject queryLeaveRegistration(Integer offset, Integer limit, QingJia qingJia);

    QingJia queryQingJiaXiangQing(String qingjiaid);

    void addLeaveRegistration(QingJia qingJia, HttpServletRequest request);
}
