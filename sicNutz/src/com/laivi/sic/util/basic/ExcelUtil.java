package com.laivi.sic.util.basic;


import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.nutz.log.Log;
import org.nutz.log.Logs;

public class ExcelUtil {
	private static Log log=Logs.get();
	
	public static Workbook getWorkBook(String filePath){
		Workbook book=null;
		try {
			book= Workbook.getWorkbook(new File(filePath));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			log.error("can't found excel file");
			e.printStackTrace();
		}
		return book;
	}
	
	public static WritableWorkbook getWritetWorkBook(String filePath){
		WritableWorkbook book=null;
		try {
			File file=new File(filePath);
			if(file.exists()){
				book= Workbook.createWorkbook(file,ExcelUtil.getWorkBook(filePath));
			}else{
				book= Workbook.createWorkbook(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public static WritableWorkbook getExistWritetWorkBook(String filePath){
		WritableWorkbook book=null;
		try {
			book= Workbook.createWorkbook(new File(filePath),ExcelUtil.getWorkBook(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public static WritableSheet getSheet(WritableWorkbook book,int index){
		Sheet[] sheets=book.getSheets();
		index=index<0?0:index;
		if(sheets.length<=index){
			for(int i=sheets.length;i<=index;i++){
				book.createSheet("sheet"+(i+1), i);
			}
			return book.getSheet(index);
		}else{
			return book.getSheet(index);
		}
	}
	
	public static Label getLabel(WritableSheet sheet,int col,int row){
		Label label=new Label(col,row, null);
		try {
			sheet.addCell(label);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return label;
	}
	
	public static Label getLabel(WritableSheet sheet,char col,int row){
		int colNum=Character.toUpperCase(col)-65;
		return ExcelUtil.getLabel(sheet, colNum, row);
	}
	
	public static Number getNumber(WritableSheet sheet,int col,int row){
		Number number=new Number(col,row,0);
		try {
			sheet.addCell(number);
		} catch (RowsExceededException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return number;
	}
	
	public static Number getNumber(WritableSheet sheet,char col,int row){
		int colNum=Character.toUpperCase(col)-65;
		return ExcelUtil.getNumber(sheet, colNum, row);
	}
	
	public static void close(WritableWorkbook book){
		try {
			book.write();
			book.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (WriteException e) {
			e.printStackTrace();
		}
	}
	

}
