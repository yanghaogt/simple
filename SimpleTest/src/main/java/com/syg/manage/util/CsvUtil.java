package com.syg.manage.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import au.com.bytecode.opencsv.CSVReader;

public class CsvUtil {
    public static CSVReader importCsvFile(MultipartFile csvFile) {  
	    CommonsMultipartFile cf= (CommonsMultipartFile)csvFile;
        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
        File targetFile = fi.getStoreLocation();
        
        CSVReader csvReader = null;  
        try {  
        	InputStreamReader isr = new InputStreamReader(new FileInputStream(targetFile),"GBK");
            csvReader = new CSVReader(isr);//importFile为要导入的文本格式逗号分隔的csv文件，提供getXX/setXX方法  
            if(csvReader == null){  
                throw new Exception("无法读取csv文件");
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
        
		return csvReader;   
          
    }  
}
