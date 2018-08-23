package com.syg.manage.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 字符编码
 * @author yanghao
 *
 */
public class Code {

	public static void main(String[] args){  
        String s = "CSS测试";
        
//		String pcName = URLDecoder.decode(request.getParameter("pcName"),"utf-8");
//		String pcName1 = new String(pcName.getBytes("iso-8859-1"), "utf-8");
//		String pcName2 = new String(pcName.getBytes("GB2312"), "utf-8");
//		String pcName3 = new String(pcName.getBytes("GBK"), "utf-8");
//		String pcName4 = URLDecoder.decode(request.getParameter("pcName"),"utf-8");
//		String pcName2 = new String(request.getParameter("pcName").getBytes("iso-8859-1"), "utf-8");
//		String pcName3 = new String(request.getParameter("pcName").getBytes("iso-8859-1"), "utf-8");
        
        try {
            //URLEncoder()函数可把字符串作为URI进行编码
            s = URLEncoder.encode(s, "UTF-8");
            System.out.println("encode :"+s);
            //URLDecoder()函数可把字符串作为 URI组件进行编码。
            s = URLDecoder.decode(s, "UTF-8");
            System.out.println("decode :"+s);
            s = new String(s.getBytes(),"GBK");
            System.out.println("GBK :" +s); 
            //combine encoding change  
        //  s = new String(URLDecoder.decode(s, "UTF-8").getBytes(),"GBK");  
        } catch (UnsupportedEncodingException e) {  
            System.out.println("encoding cause,change failure");  
        }catch (Exception e) {  
            System.out.println("others cause,change failure");  
        }  
    }  
	
}
