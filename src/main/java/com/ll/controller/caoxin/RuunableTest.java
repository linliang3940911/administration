package com.ll.controller.caoxin;


import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class RuunableTest  implements Runnable {
    private String phone;


    /*@Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(400);
                System.out.println("当前线程:"+this.threadName+"----"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }*/
    static String str = null;

    @Override
    public void run() {
        //创建一个httpclient对象
        //封装发送短息需要的参数
        //执行httpClient请求
        //记录日志 看是否发送成功
        HashMap<String, Object> queryMap = new HashMap<String, Object>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = sdf.format(new Date());
        queryMap.put("accountSid", "ac925155bf4c481991395bc0ae6172f5");
        str = createRandomVcode();
        queryMap.put("templateid", "308918128");
        queryMap.put("param", str);
        queryMap.put("to", phone);
        String sig = MD5Utils.getPwd("ac925155bf4c481991395bc0ae6172f5" + "4e5d660caf0241ac8a454fde4080b2b9" + format);
        System.out.println(sig);
        queryMap.put("sig", sig);
        queryMap.put("timestamp", format);
        queryMap.put("respDataType", "JSON");
        System.out.println(queryMap);
        String mess = HttpClient.post("https://api.miaodiyun.com/20150822/industrySMS/sendSMS", queryMap);

        System.out.println(mess);

    }

    public static String createRandomVcode(){

        String vcode = "你的流程已通过";
        return vcode.toString();
    }
    public RuunableTest(String phone){
        this.phone = phone;
    }
}
