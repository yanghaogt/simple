package com.syg.manage.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.syg.manage.util.FileUtil;

public class FileIO {
	
	public static String readFileStr(String fullName){
		StringBuffer sb = null;
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(fullName));
			sb = new StringBuffer();
			String line = "";
			int count = 0;
			while((line = br.readLine()) != null){
				if (count==0) {
					sb.append(line);
				}else{
					sb.append("\n"+line);
				}
				count++;
			}
			br.close();
		} catch (Exception e) {
			return null;
		}
		return sb.toString();
	}
	
	public static String readInputStream(InputStream inputStream){
		String res;
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			res = sb.toString();
			br.close();
		} catch (Exception e) {
			return null;
		}
		return res;
	}
	
	public static void delFile(){
		String url = "E:\\测试结果\\AndroidManifest.xml";
		System.out.println("is:"+FileUtil.checkFileExist(url));
		if (FileUtil.checkFileExist(url)) {
			FileUtil.delete(url);
		}
	}

	public static void main(String[] args) {
		delFile();
	}
	
}
