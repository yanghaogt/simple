package com.syg.manage.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
/**
 * 1024				:446581ms
 * 1024*1024		:10363ms
 * in.available()	:4563ms
 * @author yanghao
 */
public class HttpClientPostGet {

	private final static int BUFFER = 1024*1024;
		 
     private static void HttpClientLogin(String userName, String password,String loginUrl, String dataUrl) {
         HttpClient httpClient = new HttpClient();
         httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "utf-8");
         PostMethod postMethod = new PostMethod(loginUrl);
         NameValuePair[] postData = { new NameValuePair("j_username", userName),new NameValuePair("j_password", password) };
         postMethod.setRequestBody(postData);
         try {
             httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
             httpClient.executeMethod(postMethod);
             Cookie[] cookies = httpClient.getState().getCookies();
             StringBuffer stringBuffer = new StringBuffer();
             for (Cookie c : cookies) {
                 stringBuffer.append(c.toString() + ";");
             }
             GetMethod getMethod = new GetMethod(dataUrl);
             getMethod.setRequestHeader("Cookie", stringBuffer.toString());
             postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
             httpClient.executeMethod(getMethod);
             InputStream in = getMethod.getResponseBodyAsStream();
             FileOutputStream out = new FileOutputStream(new File("E:\\测试结果\\ROOT.zip"));
             
             
             //1.缓存到内存,一次性写入
//	         byte[] b = new byte[BUFFER];
//	         int len = 0;
//	         byte[] content = new byte[0];	
//	         int length = 0;
//	         //写文件，这里将所有的内容都缓存到内存中，最后一次性写入
//	         //判断是否还能转化成字节  -1：没有数据了
//	         while ((len = in.read(b)) > 0) {
//	                 // out.write(b,0,len);
//	                 length = content.length;
//	                 content = Arrays.copyOf(content, length + len);// 扩容
//	                 System.arraycopy(b, 0, content, length, len);// 将第二个数组与第一个数组合并
//	         }
//	         out.write(content, 0, content.length);
             
             //2.设置缓冲区为文件大小
             byte[] b = new byte[in.available()];
 			 int len = 0;
 			 while ((len = in.read(b)) != -1){
 				out.write(b, 0, len);
 				out.flush();
 			 }
	           
             in.close();
             out.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
         System.out.println("download, success!!");
     }
     
     public static void main(String[] args) {
		 long st = System.currentTimeMillis();
         String userName = "zzw";
         String password = "zhaozhanwei";
         String loginUrl = "http://192.168.2.124:12473/j_acegi_security_check";
         String dataUrl = "http://192.168.2.124:12473/job/DataManage/ws/target/ROOT-release.zip";
         HttpClientLogin(userName, password, loginUrl, dataUrl);
         System.out.println("use:"+(System.currentTimeMillis()-st));
     }
}
