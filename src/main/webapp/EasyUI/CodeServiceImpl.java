/** 
 * <pre>项目名称:base_code_redis 
 * 文件名称:CodeServiceImpl.java 
 * 包名:com.jk.service.impl 
 * 创建日期:2018年6月26日上午11:25:46 
 * Copyright (c) 2018, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.jk.dao.ICodeMapper;
import com.jk.pojo.BaseCode;
import com.jk.pojo.DictCode;
import com.jk.service.ICodeService;

/** 
 * <pre>项目名称：base_code_redis    
 * 类名称：CodeServiceImpl    
 * 类描述：    
 * 创建人：因蓉儿
 * 创建时间：2018年6月26日 上午11:25:46    
 * 修改人：因蓉儿    
 * 修改时间：2018年6月26日 上午11:25:46    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class CodeServiceImpl implements ICodeService {

	@Resource
	private ICodeMapper CodeDao;

	/* (non-Javadoc)    
	 * @see com.jk.service.ICodeService#queryBaesCodePage()    
	 */
	public JSONObject queryBaesCodePage(int page,int rows,BaseCode base) {
		Long count = CodeDao.queryBaesCodeCount(base);
		int start = (page - 1) * rows;
		int end = start + rows;
		List<BaseCode> baseList = CodeDao.queryBaesCodePage(start,end,base);
		JSONObject json = new JSONObject();
		json.put("total", count);
		json.put("rows", baseList);
		return json;
	}

	/* (non-Javadoc)    
	 * @see com.jk.service.ICodeService#addBaseCode(com.jk.pojo.BaseCode)    
	 */
	public void addBaseCode(BaseCode base,DictCode dict) {
		
		String basecodeid = UUID.randomUUID().toString();
		String dictcodeid = UUID.randomUUID().toString();
		
		String basecode = base.getBasecode();
		dict.setDictpcode(basecode);
		
		
		CodeDao.addBaseCode(base);
		CodeDao.addDictCode(dict);
	}
	
}
