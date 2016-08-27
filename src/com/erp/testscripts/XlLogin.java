package com.erp.testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.erp.master.LibFile;

public class XlLogin {

	
	static	FileInputStream fis;
	
	public static void main(String[] args) throws IOException {
		
		LibFile file = new LibFile();
		
		file.launch();
		
		
		fis = new FileInputStream("D:\\Aamani\\Aamani-Workspace\\ERP\\src\\com\\erp\\testdata\\login.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("LoginValidity");
		
		int rowc = sh.getLastRowNum();
		System.out.println(rowc);
			
		 	for ( int i =1;i<=rowc;i++)
		 	{
		 		
		 		XSSFRow row = sh.getRow(i);
		 		XSSFCell cel1 = row.getCell(0);
		 		XSSFCell cel2 = row.getCell(1);
		 		XSSFCell cel3 =row.createCell(2);
		 		
		 		String username = cel1.getStringCellValue();
		 		String password = cel2.getStringCellValue();
		 		
		 		String res = file.login(username, password);
		 		cel3.setCellValue(res);
		 		
		 		
		 	} 		

		 	
		 	FileOutputStream fo = new FileOutputStream("D:\\Aamani\\Aamani-Workspace\\ERP\\src\\com\\erp\\results\\login.xlsx");
			
			wb.write(fo);
			wb.close();
		 	
	}

}
