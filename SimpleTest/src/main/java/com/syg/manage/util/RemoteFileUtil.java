package com.syg.manage.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.web.multipart.MultipartFile;


/**
 * 远程文件操作
 * @author Tommy
 * @version 1.0
 * 
 */
public class RemoteFileUtil {
	private static String[] serverIps;
	private static String[] serverPorts;
	static {
//		String serverIp = ParamUtil.getValue(ParamKeyConstant.SERVERIPS_KEY);
//		String serverPort = ParamUtil.getValue(ParamKeyConstant.SERVERPORTS_KEY);
//		serverIps = serverIp.contains(";") ? serverIp.split(";") : new String[]{serverIp}; 
//		serverPorts = serverPort.contains(";") ? serverPort.split(";") : new String[]{serverPort};
		//imagesPath = "upload";
	}
		
	public static void init(String[] serverIps,String[] serverPorts) {  
    	RemoteFileUtil.serverIps = serverIps;
    	RemoteFileUtil.serverPorts = serverPorts;
    }  
	
    public static void init(String serverIpsStr,String serverPortsStr) {  
    	RemoteFileUtil.serverIps = serverIpsStr.split(";");
    	RemoteFileUtil.serverPorts = serverPortsStr.split(";");
    }  
    
    public static synchronized void copyImage(File src, String filename) {
		try {
			//copy(src, imagesPath + "/" + filename);
			copy(src, filename);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("请检查服务器：" + serverIps[0] + ":" + serverPorts[0] + "是否连接通畅");
		}
	}
	
	/**
	 * 文件拷贝
	 * @param src 文件
	 * @param filename 另存为名称
	 */
//	public static synchronized void copy(File src, String filename) {
//		int index = 0;
//		for (String serverIp : serverIps) {
//			try {
//				Socket client = new Socket(serverIp, Integer.parseInt(serverPorts[index]));
//				OutputStream ous = client.getOutputStream(); 
//				ous.write((filename + ";").getBytes());
//				byte[] byteBuffer = new byte[1024];
//				FileInputStream fis = new FileInputStream(src);
//				while (fis.read(byteBuffer) != -1) {
//					ous.write(byteBuffer);
//				}
//				ous.flush();
//				fis.close();
//				ous.close();
//				client.close();
//			} catch (NumberFormatException e) {
//				e.printStackTrace();
//			} catch (UnknownHostException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} 
//		}
//	}
    
    private static synchronized void copy(File src, String filename)
			throws UnknownHostException, IOException {
		for (int i = 0; i < serverIps.length; i++) {
			Socket client = new Socket(serverIps[i], Integer
					.parseInt(serverPorts[i]));
			OutputStream os = client.getOutputStream();
			os.write((filename + ";").getBytes());
			byte[] byteBuffer = new byte[1];
			FileInputStream fis = new FileInputStream(src);
			BufferedInputStream bis = new BufferedInputStream(fis);
			System.out.println(filename);
			while (bis.read(byteBuffer) != -1) {
				os.write(byteBuffer);
			}
			os.flush();
			bis.close();
			fis.close();
			os.close();
			client.close();
			System.out.println(client.getLocalAddress());
		}
	}

	public static synchronized void copy(MultipartFile src, String filename) {
		int index = 0;
		for (String serverIp : serverIps) {
			try {
				Socket client = new Socket(serverIp, Integer.parseInt(serverPorts[index]));
				OutputStream ous = client.getOutputStream(); 
				ous.write((filename + ";").getBytes());
				byte[] byteBuffer = new byte[1];
				FileInputStream fis = (FileInputStream)src.getInputStream();
				while (fis.read(byteBuffer) != -1) {
					ous.write(byteBuffer);
				}
				ous.flush();
				fis.close();
				ous.close();
				client.close();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	public static void copy(byte[] bytes, String newFileName) {
		
	}
	
//	//将MultipartFile 转换为File
//	public static void SaveFileFromInputStream(InputStream stream,String path,String savefile) throws IOException{      
//       FileOutputStream fs=new FileOutputStream( path + "/"+ savefile);
//       System.out.println("------------"+path + "/"+ savefile);
//       byte[] buffer =new byte[1024*1024];
//       int bytesum = 0;
//       int byteread = 0; 
//       while ((byteread=stream.read(buffer))!=-1)
//       {
//          bytesum+=byteread;
//          fs.write(buffer,0,byteread);
//          fs.flush();
//       } 
//       fs.close();
//       stream.close();      
//   }       
}
