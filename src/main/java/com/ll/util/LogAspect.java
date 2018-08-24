/**
 * <pre>项目名称:mongodb_demo
 * 文件名称:LogAspect.java
 * 包名:com.jk.pojo
 * 创建日期:2018年6月19日上午9:57:15
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre>
 */
package com.ll.util;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ll.pojo.yre.MyLogThread;
import com.ll.service.yre.IYreService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
　　* @Description: TODO
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author 因蓉儿
　　* @date 2018/8/15 20:49
　　*/
@Aspect
@Component
public class LogAspect {


	@Resource
	private IYreService yreService;

	//new一个单线程
	ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

	@Pointcut("execution(* com.ll.service..*.query*(..))")
	public  void querylog(){}


	/**
	 * 添加业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.ll.service..*.add*(..))")
	public void insertCell() {}


	/**
	 * 修改业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.ll.service..*.update*(..))")
	public void updateCell() {}


	/**
	 * 删除业务逻辑方法切入点
	 */
	@Pointcut("execution(* com.ll.service..*.delete*(..))")
	public void deleteCell() {}


	@AfterReturning(value="querylog()")
	//切点信息类(aop切入查询方法去自定义线程类，去service层将方法存入队列中)
	public  void  queryLogBean(JoinPoint jp) {

		String operationMethod = jp.getSignature().getName();


		singleThreadExecutor.execute(new MyLogThread(operationMethod, yreService));//把要存的东西，地址传到自定义线程中
	}

	@AfterReturning(value="insertCell()")
	//切点信息类(aop切入新增方法去自定义线程类，去service层将方法存入队列中)
	public  void  insertLogBean(JoinPoint jp) {
		String operationMethod = jp.getSignature().getName();


		singleThreadExecutor.execute(new MyLogThread(operationMethod, yreService));//把要存的东西，地址传到自定义线程中
	}

	@AfterReturning(value="updateCell()")
	//切点信息类(aop切修改方法去自定义线程类，去service层将方法存入队列中)
	public  void  updateLogBean(JoinPoint jp) {
		String operationMethod = jp.getSignature().getName();


		singleThreadExecutor.execute(new MyLogThread(operationMethod, yreService));//把要存的东西，地址传到自定义线程中
	}

	@AfterReturning(value="deleteCell()")
	//切点信息类(aop切入删除方法去自定义线程类，去service层将方法存入队列中)
	public  void  deleteLogBean(JoinPoint jp) {
		String operationMethod = jp.getSignature().getName();
		singleThreadExecutor.execute(new MyLogThread(operationMethod, yreService));//把要存的东西，地址传到自定义线程中
	}


}
