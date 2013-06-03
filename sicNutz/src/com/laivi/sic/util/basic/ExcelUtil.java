package com.laivi.sic.util.basic;


import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {
	
	public static Workbook getWorkBook(String filePath){
		Workbook book=null;
		try {
			book= Workbook.getWorkbook(new File(filePath));
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return book;
	}
	

}
