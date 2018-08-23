package com.syg.manage.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.biff.DisplayFormat;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.DateFormats;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.xml.sax.SAXException;

public class ExcelUtil {
	
	@SuppressWarnings("rawtypes")
	public static List read(String xmlConfig, Class clazz, MultipartFile excelFile){
		
		InputStream inputXML = new BufferedInputStream(ExcelUtil.class.getResourceAsStream(xmlConfig));
        XLSReader mainReader;
		try {
		    CommonsMultipartFile cf= (CommonsMultipartFile)excelFile;
	        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
	        File targetFile = fi.getStoreLocation();
	        FileInputStream inputXLS = new FileInputStream(targetFile);
		    
			mainReader = ReaderBuilder.buildFromXML(inputXML);
		 	Object obj = clazz.newInstance();
	        List list = new ArrayList();
	        Map<String, Object> beans = new HashMap();
	        beans.put("obj", obj);
	        beans.put("list", list);
	        XLSReadStatus readStatus = mainReader.read(inputXLS, beans);
	        return list;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void createExcel(Excel[] excels , List objects , Class clazz, String fileName, HttpServletResponse response){
		OutputStream os = null;
		WritableWorkbook wwb = null;
		Object obj2 = null;
		try {
			response.reset();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			response.setHeader("Content-disposition", "attachment; filename="
					+ java.net.URLEncoder.encode(fileName + dateFormat.format(new Date()) +".xls", "UTF-8"));
			response.setContentType("application/msexcel");
			os = response.getOutputStream();
			wwb = Workbook.createWorkbook(os);
			WritableSheet ws = wwb.createSheet(fileName, 0);
			WritableFont[] fonts = setWritableFont();
			WritableCellFormat[] formats = setWritableCellFormat();

			WritableCellFormat titleFormat = setWritableCellFormat(
					fonts[1], NumberFormats.FORMAT1, Colour.LAVENDER);
			Excel[] excelArray = sortExcelByIndex(excels);
			for (int i = 0; i < excelArray.length; i++) {
				ws.setColumnView(i, excelArray[i].getWidth());
				ws.addCell(new Label(i, 0, excelArray[i].getTitle(), titleFormat));
			}
			obj2 = clazz.newInstance();
			for (int i = 0; i < objects.size(); i++) {
				Object obj = objects.get(i);
				for (int k = 0; k < excelArray.length; k++) {
					Object cellValue = null;
					if(excelArray[k].getMethodName() != null && excelArray[k].getMethodName().length() > 0){
						Method method = null;
						try {
							method = clazz.getDeclaredMethod(getMethodName(excelArray[k].getMethodName()), getMethodArgTypes(obj ,excelArray[k].getMethodName()));
							method.setAccessible(true);
							cellValue = method.invoke(obj2, getMethodArgFieldValues(obj, excelArray[k].getMethodName()));
						} catch (Exception e) {
							e.printStackTrace();
							throw new RuntimeException(e.getMessage());
						}						
					}else if(excelArray[k].getField().split("\\.").length > 1){
						cellValue = getFieldValue(getFieldValue(obj , excelArray[k].getField().split("\\.")[0]) , excelArray[k].getField().split("\\.")[1]);
					}else{
						cellValue = getFieldValue(obj , excelArray[k].getField());
					}
					if (cellValue==null) {
						cellValue="-";
					}
					if(cellValue instanceof Integer){
						ws.addCell(new jxl.write.Number(k, i + 1, (Integer)cellValue, formats[i%2]));
					}else if(cellValue instanceof Long){
						ws.addCell(new jxl.write.Number(k, i + 1, (Long)cellValue, formats[i%2]));
					}else if(cellValue instanceof Double){
						ws.addCell(new jxl.write.Number(k, i + 1, (Double)cellValue, formats[i%2]));
					}else if(cellValue instanceof Float){
						ws.addCell(new jxl.write.Number(k, i + 1, (Float)cellValue, formats[i%2]));
					}else if(cellValue instanceof String){
						ws.addCell(new Label(k, i + 1, (String)cellValue, formats[i%2]));
					}else if(cellValue instanceof Date){
						try {
							ws.addCell(new DateTime(k, i + 1, (Date)cellValue, formats[i%2+2]));
						} catch (Exception e) {
							ws.addCell(new Label(k, i + 1, "", formats[i%2]));
						}
					}else{
						ws.addCell(new Label(k, i + 1, (String)cellValue, formats[i%2]));
					}
				}
			}
			wwb.write();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				if (wwb != null) {
					try {
						wwb.close();
					} catch (WriteException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				wwb = null;
				os = null;
				excels = null;
				objects.clear();
				objects = null;
				obj2 = null;
		}
	}
	
	public static void createExcel(Collection<Excel> excels , List objects , Class clazz, String fileName, HttpServletResponse response){
		createExcel(excels.toArray(new Excel[0]), objects, clazz, fileName, response);
	}
	
	public static Excel[] sortExcelByIndex(Excel[] excels){
		Excel[] excelArray = new Excel[excels.length];
		for (Excel e : excels) {
			if(e.getIndex() != 0){
				if(excelArray[e.getIndex()-1] != null){
					throw new RuntimeException("excel index " + e.getIndex() + " echo");
				}
				excelArray[e.getIndex()-1] = e;
			}
		}
		int t = 0;
		for (Excel e : excels) {
			if(e.getIndex() == 0){
				for (int i = t; i < excelArray.length; i++) {
					if(excelArray[i] == null){
						excelArray[i] = e;
						t = i + 1;
						break;
					}
				}
			}
		}
		excels = null;
		return excelArray;
	}

	public static Object getFieldValue(Object object , String field) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method method = object.getClass().getDeclaredMethod("get" +field.substring(0 ,1).toUpperCase()+field.substring(1));
		method.setAccessible(true);
		return method.invoke(object);
	}
	public static Object getFieldValue2(Object object , String field) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Method method = object.getClass().getDeclaredMethod("get" +field);
		method.setAccessible(true);
		return method.invoke(object);
	}
	public static Class autoload(Class clazz){
		Class[] clazzs = new Class[]{int.class , long.class , double.class , float.class ,boolean.class, 
				Integer.class, Long.class ,Double.class , Float.class , Boolean.class };
		String[] classNames = new String[]{"Integer" , "Long" , "Double" , "Float" ,"Boolean", 
				"int", "long" ,"double" , "float" , "boolean"};
		String[] split = clazz.getName().split("\\.");
		for (int i = 0; i < clazzs.length; i++) {
			if(split[split.length-1].equals(classNames[i])){
				return clazzs[i];
			}
		}
		return clazz;
	}
	
	public static Class getClassByString(String clazzName){
		String[] classNames = new String[]{"int" , "long" , "double" , "float" ,"boolean", 
				"Integer", "Long" ,"Double" , "Float" , "Boolean" , "String" , "Date" , "List" ,
				"ArrayList" , "LinkedList" , "Set" , "HashSet" , "TreeSet", "Map" , "HashMap"};
		Class[] clazzs = new Class[]{int.class , long.class , double.class , float.class ,boolean.class, 
				Integer.class, Long.class ,Double.class , Float.class , Boolean.class ,String.class , Date.class , List.class ,ArrayList.class , LinkedList.class ,
				Set.class, HashSet.class , TreeSet.class , Map.class , HashMap.class};
		for (int i = 0; i < classNames.length; i++) {
			if(clazzName.equals(classNames[i])){
				return clazzs[i];
			}
		}
		return null;
	}
	
	public static String[] splitMethod(String method){
		return method.replaceAll("[ ]+", " ").split("\\(|,|\\)");
	}
	
	public static String getMethodName(String method){
		return splitMethod(method)[0];
	}
	
	public static Class[] getMethodArgTypes(Object obj , String method) throws SecurityException, NoSuchFieldException{
		String[] splitMethod = splitMethod(method);
		Class[] clazzNames = new Class[splitMethod.length - 1];
		for (int i = 1; i < splitMethod.length; i++) {
			clazzNames[i - 1] = getClassByString(splitMethod[i].trim().split(" ")[0]);
			if(clazzNames[i - 1] == null){
				clazzNames[i - 1] = getFieldType(obj , splitMethod[i].trim().split(" ")[1]);
			}
		}
		return clazzNames;
	}
	
	public static Object[] getMethodArgFieldValues(Object object , String method) throws SecurityException, IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException{
		String[] splitMethod = splitMethod(method);
		Object[] values = new Object[splitMethod.length - 1];
		for (int i = 1; i < splitMethod.length; i++) {
			values[i-1] = getFieldValue(object, splitMethod[i].trim().split(" ")[1]);
		}
		return values;
	}
	
	public static Class getFieldType(Object obj , String name) throws SecurityException, NoSuchFieldException{
		Field field = obj.getClass().getDeclaredField(name);
		return field.getType();
	}
	
	public static WritableFont[] setWritableFont(){
		WritableFont[] wf = new WritableFont[2];
		wf[0] = new WritableFont(WritableFont.ARIAL, 12, WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		wf[1] = new WritableFont(WritableFont.ARIAL, 12, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE, Colour.BLACK);
		return wf;
	}

	public static WritableCellFormat[] setWritableCellFormat(){
		WritableCellFormat[] format = new WritableCellFormat[4];
		WritableFont[] font = setWritableFont();
		format[0] = setWritableCellFormat(font[0] , NumberFormats.FORMAT1 , Colour.ICE_BLUE);
		format[1] = setWritableCellFormat(font[0] , NumberFormats.FORMAT1 , Colour.PALE_BLUE);
		format[2] = setWritableCellFormat(font[1] , DateFormats.FORMAT1 , Colour.ICE_BLUE);
		format[3] = setWritableCellFormat(font[1] , DateFormats.FORMAT1 , Colour.PALE_BLUE);
		return format;
	}
	
	public static WritableCellFormat setWritableCellFormat(WritableFont font , DisplayFormat format , Colour color){
		WritableCellFormat titleFormat = new WritableCellFormat(font, format);
		try {
			titleFormat.setAlignment(jxl.format.Alignment.CENTRE);
			titleFormat.setBackground(color);
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return titleFormat;
	}
	
	public static WritableSheet setColumnViews(WritableSheet ws , int[] widths){
		for (int i = 0; i < widths.length; i++) {
			ws.setColumnView(i, widths[i]);
		}
		return ws;
	}
	
	public static WritableSheet setTitle(WritableSheet ws , WritableCellFormat format , String[] titles){
		for (int i = 0; i < titles.length; i++) {
			try {
				ws.addCell(new Label(i, 0, titles[i], format));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ws;
	}
	
	/**
	 * 大数据下 导入多个sheet
	 * @param excels
	 */
	public static void createExcelLarge(Excel[] excels , List objects , Class clazz, String fileName, HttpServletResponse response){
		OutputStream os = null;
		WritableWorkbook wwb = null;
		Object obj2 = null;
		try {
			response.reset();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			response.setHeader("Content-disposition", "attachment; filename="+ java.net.URLEncoder.encode(fileName + dateFormat.format(new Date()) +".xls", "UTF-8"));
			response.setContentType("application/msexcel");
			os = response.getOutputStream();
			wwb = Workbook.createWorkbook(os);
			//最大数据50000
			int totle = objects.size();
			int maxNum = 50000;
			int avg = totle / maxNum;
			for (int i = 0; i < avg + 1; i++) {
				WritableSheet ws = wwb.createSheet("列表" + (i + 1), i);
				WritableFont[] fonts = setWritableFont();
				WritableCellFormat[] formats = setWritableCellFormat();
				WritableCellFormat titleFormat = setWritableCellFormat(fonts[1], NumberFormats.FORMAT1, Colour.LAVENDER);
				Excel[] excelArray = sortExcelByIndex(excels);
				for (int b = 0; b < excelArray.length; b++) {
					ws.setColumnView(b, excelArray[b].getWidth());
					ws.addCell(new Label(b, 0, excelArray[b].getTitle(), titleFormat));
				}
				obj2 = clazz.newInstance();
				int num = i * maxNum;
				int index = 0;
				for (int m = num; m < objects.size(); m++) {
					if (index == maxNum) {//判断index == mus的时候跳出当前for循环
						break;
					}
					Object obj = objects.get(m);
					for (int k = 0; k < excelArray.length; k++) {
						Object cellValue = null;
						if(excelArray[k].getMethodName() != null && excelArray[k].getMethodName().length() > 0){
							Method method = null;
							try {
								method = clazz.getDeclaredMethod(getMethodName(excelArray[k].getMethodName()), getMethodArgTypes(obj ,excelArray[k].getMethodName()));
								method.setAccessible(true);
								cellValue = method.invoke(obj2, getMethodArgFieldValues(obj, excelArray[k].getMethodName()));
							} catch (Exception e) {
								e.printStackTrace();
								throw new RuntimeException(e.getMessage());
							}						
						}else if(excelArray[k].getField().split("\\.").length > 1){
							cellValue = getFieldValue(getFieldValue(obj , excelArray[k].getField().split("\\.")[0]) , excelArray[k].getField().split("\\.")[1]);
						}else{
							cellValue = getFieldValue(obj , excelArray[k].getField());
						}
						if (cellValue==null) {
							cellValue="-";
						}
						if(cellValue instanceof Integer){
							ws.addCell(new jxl.write.Number(k, index + 1, (Integer)cellValue, formats[m%2]));
						}else if(cellValue instanceof Long){
							ws.addCell(new jxl.write.Number(k, index + 1, (Long)cellValue, formats[m%2]));
						}else if(cellValue instanceof Double){
							jxl.write.NumberFormat nf = new jxl.write.NumberFormat("#,##0.00");    //设置数字格式
							jxl.write.WritableCellFormat wcfN = new jxl.write.WritableCellFormat(nf);
							ws.addCell(new jxl.write.Number(k, index + 1, (Double)cellValue, wcfN));
						}else if(cellValue instanceof Float){
							ws.addCell(new jxl.write.Number(k, index + 1, (Float)cellValue, formats[m%2]));
						}else if(cellValue instanceof String){
							ws.addCell(new Label(k, index + 1, (String)cellValue, formats[m%2]));
						}else if(cellValue instanceof Date){
							try {
								ws.addCell(new DateTime(k, index + 1, (Date)cellValue, formats[m%2+2]));
							} catch (Exception e) {
								ws.addCell(new Label(k, index + 1, "", formats[m%2]));
							}
						}else{
							ws.addCell(new Label(k, index + 1, (String)cellValue, formats[m%2]));
						}
					}
					index++;
				}
			}
			wwb.write();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
				if (wwb != null) {
					try {
						wwb.close();
					} catch (WriteException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				wwb = null;
				os = null;
				excels = null;
				objects.clear();
				objects = null;
				obj2 = null;
		}
	}
	
}
