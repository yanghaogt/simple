package com.syg.manage.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {
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
	
	
	public static String formatDir(String org){
		String res;
//		if (OSinfo.isWindows()) {
//			res = org.replaceAll("\\/", "\\");
//		}else{
//			res = org.replaceAll("\\", "/");
//		}
		res = org.replaceAll("\\\\", "/");
		return res;
	}
	
	public static String formatDirWin(String org){
		String res;
//		if (OSinfo.isWindows()) {
//			res = org.replaceAll("\\/", "\\");
//		}else{
//			res = org.replaceAll("\\", "/");
//		}
		res = org.replaceAll("/", "\\\\");
		return res;
	}
	
	public static void write2File(String txt,String strFile){
		FileWriter fileWriter = null;
		try {
			strFile = formatDir(strFile);
			checkFileAndCreateDir(strFile);
			
			fileWriter = new FileWriter(strFile);
			fileWriter.write(txt);
			fileWriter.flush();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				fileWriter.close();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public static boolean checkFileAndCreateDir(String filePath) {
		filePath = formatDir(filePath);
		String paths[] = filePath.split("/");
		String dir = paths[0];
		int c = 2;
		if (filePath.endsWith("/")) {
			c = 1;
		}
		for (int i = 0; i < paths.length - c; i++) {// 注意此处循环的长度
			try {
				dir = dir + "/" + paths[i + 1];
				File dirFile = new File(dir);
				if (!dirFile.exists()) {
					dirFile.mkdir();
				}
			} catch (Exception err) {
				throw new RuntimeException(err);
			}
		}
		File fp = new File(filePath);
		if (fp.exists()) {
			return true; // 文件存在
		} else {
			return false; // 文件不存在
		}
	}
	
	public static void write2ResFileByStr(String txt,String file){
		String fileName = FileUtil.class.getResource("/").getPath()+file;
		write2File(txt, fileName);
	}
	
	public static void cleanAndCreateDir(String dir){
		delete(dir);
		checkFileAndCreateDir(dir+"/a");
	}
	
	public static boolean checkDirExist(String filePath){
		File f = new File(filePath);
		if (f.isDirectory() && f.exists()) {
			return true;
		}
		return false;
	}
	
	public static boolean checkFileExist(String filePath){
		File f = new File(filePath);
		if (f.exists()) {
			return true;
		}
		return false;
	}
	
    /**
     *  根据路径删除指定的目录或文件，无论存在与否
     *@param sPath  要删除的目录或文件
     *@return 删除成功返回 true，否则返回 false。
     */
    public static boolean delete(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 判断目录或文件是否存在
        if (!file.exists()) {  // 不存在返回 false
            return flag;
        } else {
            // 判断是否为文件
            if (file.isFile()) {  // 为文件时调用删除文件方法
                return deleteFile(sPath);
            } else {  // 为目录时调用删除目录方法
                return deleteDirectory(sPath);
            }
        }
    }
	
    /**
     * 删除单个文件
     * @param   sPath    被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }
    
    /**
     * 删除目录（文件夹）以及目录下的文件
     * @param   sPath 被删除目录的文件路径
     * @return  目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirectory(String sPath) {
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        //如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        //删除文件夹下的所有文件(包括子目录)
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            //删除子文件
            if (files[i].isFile()) {
                flag = deleteFile(files[i].getAbsolutePath());
                if (!flag) break;
            } //删除子目录
            else {
                flag = deleteDirectory(files[i].getAbsolutePath());
                if (!flag) break;
            }
        }
        if (!flag) return false;
        //删除当前目录
        if (dirFile.delete()) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void copyOrMove(String src, String des,boolean override,boolean delOld) {
        File srcFile=new File(src);
        File descFile=new File(des);
        
        if (!srcFile.exists()) {
			throw new RuntimeException("文件不存在:"+src);
		}
        FileUtil.checkFileAndCreateDir(des);
        if (srcFile.isFile()) {
        	fileCopy(src, des,override,delOld);
		}else{
			File[] fs=srcFile.listFiles();  
			if(!descFile.exists()){  
	            descFile.mkdirs();  
	        }
	        for (File f : fs) {  
	            if(f.isFile()){  
	                fileCopy(f.getPath(),des+"/"+f.getName(),override,delOld); //调用文件拷贝的方法  
	            }else if(f.isDirectory()){  
	            	copyOrMove(f.getPath(),des+"/"+f.getName(),override,delOld);
	            }  
	        }
	        if (override && delOld) {
	        	srcFile.delete();
			}
		}
    }
    
    public static void copyDir(String src, String des) {
        copyOrMove(src, des, true, false);
    }
    public static void copyFile(String src, String des) {
        copyOrMove(src, des, true, false);
    }
    
    
    
    public static void move(String src,String des,boolean override){
    	copyOrMove(src, des, override, true);
    }
  
    /** 
     * 文件拷贝的方法 
     */  
    private static void fileCopy(String src, String des,boolean override,boolean delOld) {
		File f1 = new File(src);
		File f2 = new File(des);
		if (f2.exists()) {
			if (override) {
				f2.delete();
			} else {
				return;
			}
		}

		int length = 2097152;
		FileInputStream in = null;
		FileOutputStream out = null;
		boolean bSuc=false;
		try {
			in = new FileInputStream(f1);
			out = new FileOutputStream(f2);
			FileChannel inC = in.getChannel();
			FileChannel outC = out.getChannel();
			ByteBuffer b = null;
			while (true) {
				if (inC.position() == inC.size()) {
					inC.close();
					outC.close();
					break;
				}
				if ((inC.size() - inC.position()) < length) {
					length = (int) (inC.size() - inC.position());
				} else{
					length = 2097152;
				}
				b = ByteBuffer.allocateDirect(length);
				inC.read(b);
				b.flip();
				outC.write(b);
				outC.force(false);
			}
			bSuc = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
				out.close();
				if (bSuc && delOld) {
					f1.delete();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    
    public static void rename(String src, String des){
    	File f = new File(src);
    	f.renameTo(new File(des));
    }
    
    /**
	 * 获取文件的MD5值
	 * 
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String getMd5ByFile(File file){
		String value = null;
		FileInputStream in = null;
		FileChannel fc = null;
		try {
			in = new FileInputStream(file);
			fc = in.getChannel();
			MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
			int zero = 32 - value.length();
			for (int i = 0; i < zero; i++) {
				value = "0"+value;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("获取MD5异常",e);
		} finally {
			try {
				fc.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
	/**
	 * 获取文件夹下所有文件
	 * @param filepath
	 * @return List&lt;File&gt; 文件列表
	 */
	public static List<File> listFile(String filepath) {
		List<File> files = new ArrayList<>();
		File file = new File(filepath);
		if (file.isDirectory()) {
			String[] filelist = file.list();
			for (int i = 0; i < filelist.length; i++) {
				File readfile = new File(filepath + File.separator + filelist[i]);
//				System.out.println(readfile.getPath());
				if (readfile.isFile() && readfile.canRead() && readfile.getName().endsWith(".zip")) {
					files.add(readfile);
				}
			}
		}
		return files;
	}
	
	/**
	 * 列出某目录下所有指定格式的文件名
	 * @param filepath
	 * @return
	 */
	public static List<String> listFileNames(String filepath, String extension) {
		List<String> fileNames = new ArrayList<>();
		File file = new File(filepath);
		if (file.isDirectory()) {
			String[] filelist = file.list();
			for (int i = 0; i < filelist.length; i++) {
				if (extension != null && !"".equals(extension) && !filelist[i].endsWith("."+extension)) {
					continue;
				}
				fileNames.add(filelist[i]);
			}
		}
		return fileNames;
	}
	
	/**
	 * 列出某目录下以及子目录下所有指定格式的文件名
	 * @param filepath
	 * @param recursion
	 * @return
	 */
	public static List<String> listAllFileNames(String filepath, boolean recursion) {
		List<String> fileNames = new ArrayList<>();
		File file = new File(filepath);
		if (file.isDirectory()) {
			String[] filelist = file.list();
			for (int i = 0; i < filelist.length; i++) {
				String fileAbsolutePath = filepath+File.separator+filelist[i];
				if(recursion){
					File file1 = new File(fileAbsolutePath);
					if(file1.isDirectory()){
						fileNames.addAll(listAllFileNames(fileAbsolutePath, recursion));
					}else{
						fileNames.add(fileAbsolutePath);
					}
				}else{
					fileNames.add(fileAbsolutePath);
				}
			}
		}
		return fileNames;
	}
}