package com.syg.manage.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.syg.common.HttpHelper;
import com.syg.manage.util.RemoteHttpUtil;

public class HttpPostGet {

	public static void downFileLogin() throws IOException{
		int bytesum = 0;
	    int byteread = 0;
		String path="http://192.168.2.124:12473/job/DataManage/ws/target/ROOT-release.zip";
        String pathLogin ="http://192.168.2.124:12473/j_acegi_security_check";
		String targetPath="E:\\测试结果";
		URL url = new URL(pathLogin);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoInput(true);
		connection.setDoOutput(true);
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "GBK");  
		out.write("j_username=zzw&j_password=zhaozhanwei");
		out.flush();
		out.close();
		String cookieVal = connection.getHeaderField("Set-Cookie");
		//得到后，下面的操作就是你想得到哪个页面的数据了
		url = new URL(path);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();    
		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
		conn.setRequestProperty("Cookie", cookieVal);
		conn.connect();
		try {
			InputStream urlStream = conn.getInputStream();
			FileOutputStream fs = new FileOutputStream(targetPath);
	        byte[] buffer = new byte[1204];
	        while ((byteread = urlStream.read(buffer)) != -1) {
	            bytesum += byteread;
	            fs.write(buffer, 0, byteread);
	        }
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }	
	}
	
	public static void downFileHUC(){
		String remoteFilePath = "http://192.168.2.124:12473/job/DataManage/ws/target/ROOT-release.zip";
		String localFilePath = "E:\\测试结果";
        URL urlfile = null;
        HttpURLConnection httpUrl = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        File f = new File(localFilePath);
        try{
            urlfile = new URL(remoteFilePath);
            httpUrl = (HttpURLConnection)urlfile.openConnection();
            httpUrl.connect();
            bis = new BufferedInputStream(httpUrl.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(f));
            int len = 2048;
            byte[] b = new byte[len];
            while ((len = bis.read(b)) != -1)
            {
                bos.write(b, 0, len);
            }
            bos.flush();
            bis.close();
            httpUrl.disconnect();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                bis.close();
                bos.close();
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
	
	public static void downFileUC() throws MalformedURLException {
        String path="http://192.168.2.124:12473/job/DataManage/ws/target/ROOT-release.zip";
        String pathLogin ="http://192.168.2.124:12473/j_acegi_security_check";
		String targetPath="E:\\测试结果";
        try {
        	URL urlLogin = new URL(pathLogin);
        	URLConnection connection =  urlLogin.openConnection();
        	connection.setDoOutput(true);//允许连接提交信息
        	connection.setDoOutput(true);//发送POST请求必须设置如下两行
        	connection.setDoInput(true);
        	String content = "j_username=zzw&j_password=zhaozhanwei";
        	OutputStream os = connection.getOutputStream();
        	os.write(content.toString().getBytes("UTF-8"));
        	os.close();
        	String responseCookie = connection.getHeaderField("Set-Cookie");//取到所用的Cookie
        	URL url = new URL(path);
	        URLConnection conn = url.openConnection();
	        conn.setRequestProperty("Connection", "Keep-Alive");//维持长连接
	        conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
	        conn.setRequestProperty("Accept-Encoding", "gzip, deflate");
	        conn.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
	        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            conn.setRequestProperty("Cookie", responseCookie);
        	conn.connect();
        	FileInputStream fis = (FileInputStream) conn.getInputStream();
            FileOutputStream fos = new FileOutputStream(targetPath);
            byte[] b = new byte[fis.available()];
            int len = 0;
			while ((len = fis.read(b)) != -1){
				fos.write(b, 0, len);
				fos.flush();
			}
			fos.close();
			fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	public static void downFileLocal() throws Exception{
		//由绝对路径得到输出流
		//path源路径
		//fileCopeToPath 目标路径 
		//String path="E:\\测试\\wmdsc_tencent20170419.apk";
		String path="http://192.168.2.124:12473/job/DataManage/ws/target/ROOT-release.zip";
		String fileCopeToPath="E:\\测试结果";
		File file =new File(path);
		if(file.exists()){
			//文件输入流
			FileInputStream fis = new FileInputStream(file);
			//文件输出流是用于将数据写入到文件中。
			FileOutputStream fos= new FileOutputStream(fileCopeToPath+ File.separator +path.substring(path.lastIndexOf("\\"),path.length()));
			byte[] b = new byte[fis.available()];
			int len = 0;
			while ((len = fis.read(b)) != -1){
				fos.write(b, 0, len);
				fos.flush();
			}
			fos.close();
			fis.close();
		}
	}
	
	public static void sendPost(){
		String path = "http://192.168.2.124:12473/job/DataManage/build?token=38cef1d2bd94c9a915ce5a6080e78f8c";
		String result = HttpHelper.post(path, "");
		System.out.println("success");
	}
	
	public static void queryState() throws InterruptedException{
		long st = System.currentTimeMillis();
		Thread.sleep(10000);
		String state="";
		while (true) {
			String path = "http://192.168.2.124:12473/api/json";
			String starte = RemoteHttpUtil.urlGet(path);
			JSONObject result = JSONObject.parseObject(starte);
			JSONArray jobArray = JSONArray.parseArray(result.getString("jobs"));
			for(int i=0;i<jobArray.size();i++){
				JSONObject job =  (JSONObject) jobArray.get(i);
				String name	      = job.getString("name");
				String serverName = job.getString("color");
				if (name.equals("DataManage")) {
					state = serverName;
					if(state.equals("blue_anime"))Thread.sleep(5000);
					System.out.println(state);
				}
			}
			if(state.equals("blue")){
				break;
			}
		}
		System.out.println("query use:"+(System.currentTimeMillis() - st));
	}
	
	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		try {
			sendPost();
			queryState();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("use:"+(System.currentTimeMillis()- s));
	}
}
