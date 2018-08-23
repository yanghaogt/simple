package com.syg.manage.util;

import java.io.UnsupportedEncodingException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
 
/**
 * 工具类，提供一些方便的方法，有些主要是用于调试用途，有些不是
 * 
 * @author luma
 * @author notXX
 */

public class IPUtil {
	/**
	 * 根据某种编码方式将字节数组转换成字符串
	 * 
	 * @param b
	 *            字节数组
	 * @param offset
	 *            要转换的起始位置
	 * @param len
	 *            要转换的长度
	 * @param encoding
	 *            编码方式
	 * @return 如果encoding不支持，返回一个缺省编码的字符串
	 */
	public static String getString(byte[] b, int offset, int len,
			String encoding) {
		try {
			return new String(b, offset, len, encoding);
		} catch (UnsupportedEncodingException e) {
			return new String(b, offset, len);
		}
	}

	/**
	 * @param ip
	 *            ip的字节数组形式
	 * @return 字符串形式的ip
	 */
	public static String getIpStringFromBytes(byte[] ip) {
		StringBuilder sb = new StringBuilder();
		sb.delete(0, sb.length());
		sb.append(ip[0] & 0xFF);
		sb.append('.');
		sb.append(ip[1] & 0xFF);
		sb.append('.');
		sb.append(ip[2] & 0xFF);
		sb.append('.');
		sb.append(ip[3] & 0xFF);
		return sb.toString();
	}

	/**
	 * 从ip的字符串形式得到字节数组形式
	 * 
	 * @param ip
	 *            字符串形式的ip
	 * @return 字节数组形式的ip
	 */
	public static byte[] getIpByteArrayFromString(String ip) {
		byte[] ret = new byte[4];
		StringTokenizer st = new StringTokenizer(ip, ".");
		try {
			ret[0] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[1] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[2] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
			ret[3] = (byte) (Integer.parseInt(st.nextToken()) & 0xFF);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return ret;
	}
	
	/**
	 * 获取访问IP地址
	 * @param request
	 * 			访问请求
	 * @return
	 * 			IP地址
	 */
	public static final String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if(!ifRealIp(ip)){
			ip =  request.getHeader("X-Real-IP") ;
		}
		if (!ifRealIp(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (!ifRealIp(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}		
		if (!ifRealIp(ip)) {
			ip = request.getRemoteAddr();
		}		
		return ip;
	}

	private static boolean ifRealIp(String ip){
		if(ip == null){
			return false;
		}
		if(ip.trim().length() == 0){
			return false;
		}
		if("unknown".equalsIgnoreCase(ip)){
			return false;
		}
		if("127.0.0.1".equals(ip)){
			return false;
		}
		if(ip.split("\\.").length != 4){
			return false;
		}
		return true;
	}
	
	public static String getLocalIP() {
		String ip = "";
		try {
			Enumeration<?> e1 = (Enumeration<?>) NetworkInterface
					.getNetworkInterfaces();
			while (e1.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface) e1.nextElement();
				if (!ni.getName().equals("eth0")) {
					continue;
				} else {
					Enumeration<?> e2 = ni.getInetAddresses();
					while (e2.hasMoreElements()) {
						InetAddress ia = (InetAddress) e2.nextElement();
						if (ia instanceof Inet6Address)
							continue;
						ip = ia.getHostAddress();
					}
					break;
				}
			}
		} catch (SocketException e) {
			e.printStackTrace();
		}
		return ip;
	}
	
}
