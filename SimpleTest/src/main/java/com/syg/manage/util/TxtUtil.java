package com.syg.manage.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import au.com.bytecode.opencsv.CSVReader;

public class TxtUtil {
    public static BufferedReader importCsvFile(MultipartFile txtFile) throws IOException {  
    	CommonsMultipartFile cf= (CommonsMultipartFile)txtFile;
		FileInputStream fis = (FileInputStream)cf.getInputStream();
		String os = System.getProperty("os.name");
		InputStreamReader is = null;
		if (os.toLowerCase().startsWith("windows")) {
			is = new InputStreamReader(fis, "UTF-8"); 
		} else {
			is = new InputStreamReader(fis, "iso-8859-1"); 
		}
		
		BufferedReader br = new BufferedReader(is);
		
        String temp = ""; 
        int i = 0; 
        while((temp=br.readLine()) != null){ 
            System.out.print(++i + "  "); 
            System.out.println(temp); 
        } 

        return br;
          
    }  
}
