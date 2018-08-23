package com.syg.manage.util;

import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;

public class ExcelTools {
	
	private final static Logger log = LoggerFactory.getLogger(ExcelTools.class);
	
	public static JSONArray readExcel(String fileName,InputStream is){
		Workbook wb = null;
		FormulaEvaluator formulaEvaluator =null;		
		try {		
			log.info("{}",fileName);
			if(fileName.endsWith("xlsx")){
				wb = new XSSFWorkbook(is);
				formulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) wb);			
			}else if(fileName.endsWith("xls")){
				wb = new HSSFWorkbook(is);
				formulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) wb);	
			}else{
				return null;
			}
			fileName=fileName.substring(0, fileName.indexOf("."));	
			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				Sheet sheet = wb.getSheetAt(i);
				log.info("{}" , sheet.getSheetName());				
				Iterator<Row> it = sheet.rowIterator();
				//log.info("{}", sheet.getLastRowNum());
				JSONArray out = new JSONArray();
				while (it.hasNext()) {
					Row row = it.next();
					JSONArray temp = new JSONArray();
					int size = row.getLastCellNum();
					for(int j=0;j<size;j++){
						if(row.getCell(j)==null)
							continue;
						if(row.getCell(j).getCellType()==Cell.CELL_TYPE_FORMULA){
							temp.add(row.getCell(j).getCellFormula());
						}else	if(row.getCell(j).getCellType()==Cell.CELL_TYPE_STRING){
							String temp2 = row.getCell(j).getStringCellValue().trim();
							temp.add(temp2);
						}else{			
							temp.add(row.getCell(j).toString().trim());
						}
					}					
					out.add(temp);
				}				
				return out;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
}
