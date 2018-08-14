package com.ll.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {
	/**\
	 * 
	 * @param artImg   文件对象
	 * @param folderPath 上传的文件夹的路径
	 * @param folderName	文件夹名
	 * @return
	 */
	public static String uploadFile(MultipartFile artImg , String folderPath ,String folderName){
		 //获取原文件名称
        String fileName = artImg.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        File file = new File(folderPath);
//        该目录是否已经存在
        if(!file.exists()){
         //   创建文件夹
            file.mkdir();
        }
        String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
        FileOutputStream fos = null ;
		try {
			fos = new FileOutputStream(folderPath+onlyFileName);
			fos.write(artImg.getBytes());
	       
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		     try {
		    	fos.flush();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return folderName+"/"+onlyFileName;
	}
}
