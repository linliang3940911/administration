package com.ll.pojo.config;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ll.pojo.yre.OperationPojo;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="hello")//该注解为监听rabbit(队列)的queue name(可监听多个)
public class HelloReceiver {

    //注入MongoTemplate 从rabbitmq队列 中取出(方法名,当前系统时间,当前操作人)  存入mongodb
    @Autowired
    private MongoTemplate mongoTemplate;

    //通过@RabbitHandler注解输出rabbit(队列)里存的queue
    @RabbitHandler //将该方法后才可输出存入队列中的东西
    public void process(String operationLog) {
        System.out.println("Receiver  : " + operationLog);
        OperationPojo operationsLog = JSON.parseObject(operationLog, OperationPojo.class);//将string 类型转为对象
        mongoTemplate.save(operationsLog);//将对象存入mongodb
    }


}
