package com.ll.service.yre;

import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.yre.*;

public interface IYreService {
    JSONObject queryRegistration(Integer offset, Integer limit, Commute commute);

    Commute addReasonById(String commuteid);

    void addReason2(Commute commute);

    JSONObject queryMySchedule(Integer offset, Integer limit, KaoQinBanCi kaoqinbanci);

    JSONObject queryMyHoliday(Integer offset, Integer limit, Holiday holiday);

    JSONObject queryOvertimeRegistration(Integer offset, Integer limit, JiaBan jiaBan);

    JiaBan queryxiangqing(String jiabanid);

    void addOvertimeRegistration(JiaBan jiaBan);

    JSONObject queryRavelRegistration(Integer offset, Integer limit, Travel travel);

    Travel queryTravelXiangQing(String travelid);

    void addTravelRegistration(Travel travel);
}
