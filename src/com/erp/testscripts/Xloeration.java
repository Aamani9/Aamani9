package com.erp.testscripts;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.erp.master.LibFile;

public class Xloeration 

{
	public static  FileInputStream fis;
	public static void main(String[] args) throws IOException {
	
		LibFile file = new LibFile();
		file.launch();
		file.login("admin","master");
		fis= new FileInputStream("D:\\Aamani\\Aamani-Workspace\\ERP\\src\\com\\erp\\testdata\\erp.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		int rc = sh.getLastRowNum();
		System.out.println(rc);
		for( int i=1;i<=rc;i++){
			
			XSSFRow row = sh.getRow(i);
			XSSFCell cell = row.getCell(0);
			XSSFCell cell1 = row.getCell(1);
			XSSFCell cell2 = row.createCell(2);
			String uid,desc;
			uid=cell.getStringCellValue();
			desc=cell1.getStringCellValue();
			String res=file.uom(uid, desc);
			cell2.setCellValue(res);
			}
		FileOutputStream fo = new FileOutputStream("D:\\Aamani\\Aamani-Workspace\\ERP\\src\\com\\erp\\results\\unit.xlsx");
		wb.write(fo);
		wb.close();
		
	}
	
	
	
	
	
	
	
}
