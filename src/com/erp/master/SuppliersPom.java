package com.erp.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.FindBy;

public class SuppliersPom {

	//LibFile file = new LibFile();
	
	@FindBy(xpath=".//*[@id='mi_a_suppliers']/a")
	WebElement slink;
	@FindBy(xpath=".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")
	WebElement addbtn;
	@FindBy(xpath=".//*[@id='x_Supplier_Number']")
	WebElement id;
	@FindBy(xpath=".//*[@id='x_Supplier_Name']")
	WebElement name;
	@FindBy(xpath=".//*[@id='x_Address']")
	WebElement address;
	@FindBy(xpath=".//*[@id='x_City']")
	WebElement city;
	@FindBy(xpath=".//*[@id='x_Country']")
	WebElement country;
	@FindBy(xpath=".//*[@id='x_Contact_Person']")
	WebElement cntPerson;
	@FindBy(xpath=".//*[@id='x_Phone_Number']")
	WebElement pno;
	@FindBy(xpath=".//*[@id='x__Email']")
	WebElement email;
	@FindBy(xpath=".//*[@id='x_Mobile_Number']")
	WebElement mobileno;
	@FindBy(xpath=".//*[@id='x_Notes']")
	WebElement notes;
	@FindBy(xpath=".//*[@id='btnAction']")
	WebElement add;
	@FindBy(xpath="html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")
	WebElement ok;
	
	public String suppliers(String sname,String saddress,String scity, String scountry, String scntperson,String spno,
			String semail,String mno, String snotes){
		
		slink.click();
		Sleeper.sleepTightInSeconds(3);
		addbtn.click();
		Sleeper.sleepTightInSeconds(3);
		//id.clear();
		//id.sendKeys(sid);
		
		name.sendKeys(sname);
		address.sendKeys(saddress);
		Sleeper.sleepTightInSeconds(3);
		city.sendKeys(scity);
		country.sendKeys(scountry);
		cntPerson.sendKeys(scntperson);
		Sleeper.sleepTightInSeconds(3);
		pno.sendKeys(spno);
		email.sendKeys(semail);
		mobileno.sendKeys(mno);
		notes.sendKeys(snotes);
		add.click();
		ok.click();
		return "suppliers created";
		
		
	}
	
	public void xloperation() throws IOException{
		
		
		slink.click();
		addbtn.click();
		FileInputStream fis = new FileInputStream("D:\\Aamani\\Aamani-Workspace\\ERP\\src\\com\\erp\\testdata\\suppliers.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		
		int rc = sh.getLastRowNum();
		System.out.println(rc);
		
		for(int i=1;i<rc;i++){
			
			
			XSSFRow row = sh.getRow(i);
			
			XSSFCell cel = row.getCell(0);
			XSSFCell cel1= row.getCell(1);
			XSSFCell cel2= row.getCell(2);
			XSSFCell cel3 = row.getCell(3);
			XSSFCell cel4 = row.getCell(4);
			XSSFCell cel5 = row.getCell(5);
			XSSFCell cel6 = row.getCell(6);
			XSSFCell cel7 = row.getCell(7);
			XSSFCell cel8 = row.getCell(8);
			XSSFCell result = row.getCell(9);
			
			String sname,saddress,scity,scountry,scno,spno,semail,smno,snotes;
			
			sname= cel.getStringCellValue();
			 saddress= cel1.getStringCellValue();
			scity= cel2.getStringCellValue();
			scountry= cel3.getStringCellValue();
			scno=cel4.getStringCellValue();
			spno=cel5.getStringCellValue();
			semail=cel6.getStringCellValue();
			smno=cel7.getStringCellValue();
			snotes=cel8.getStringCellValue();
			
			String res= suppliers(sname,saddress, scity, scountry, scno, spno, semail, smno, snotes);
			cel8.setCellValue(res);
			
			
		/*
			XSSFCell name = row.getCell(0);
			XSSFCell address = row.getCell(1);
			XSSFCell city = row.getCell(2);
			XSSFCell country = row.getCell(3);
			XSSFCell cno = row.getCell(4);
			XSSFCell pno = row.getCell(5);
			XSSFCell email = row.getCell(6);
			XSSFCell mno = row.getCell(7);
			XSSFCell notes = row.getCell(8);
			XSSFCell result= row.createCell(9);
			
			String sname,saddress,scity,scountry,scno,spno,semail,smno,snotes;
			sname=name.getStringCellValue();
			saddress=address.getStringCellValue();
			scity=city.getStringCellValue();
			scountry = country.getStringCellValue();
			scno=cno.getStringCellValue();
			spno=pno.getStringCellValue();
			semail=email.getStringCellValue();
			smno=mno.getStringCellValue();
			snotes = notes.getStringCellValue();*/
			
		/*	String res = file.suppliers(sname, saddress, scity, scountry, scno, spno, semail, smno, snotes);
			result.setCellValue(res);*/
			
			
		}
		
		
		FileOutputStream fos=new FileOutputStream("D:\\Aamani\\Aamani-Workspace\\ERP\\src\\com\\erp\\results\\supresults.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	
	
	
}
