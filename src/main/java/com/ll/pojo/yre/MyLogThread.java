package com.ll.pojo.yre;

import com.ll.service.yre.IYreService;

public class MyLogThread implements Runnable{

    private IYreService yreService;//service地址

    private String operationMethod;//方法名

    public MyLogThread(String operationMethod, IYreService yreService){
        this.operationMethod = operationMethod;
        this.yreService = yreService;
    }

    public MyLogThread(){

    }

    @Override
    public void run() {
        yreService.operationLog(operationMethod);//通过addOperationLog方法将要存的东西传到service层
    }
}
