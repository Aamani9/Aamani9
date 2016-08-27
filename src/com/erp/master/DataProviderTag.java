package com.erp.master;

import java.io.FileNotFoundException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.erp.testscripts.NewTest;

public class DataProviderTag extends NewTest {

	
	
  public void launch1(){
		
		file.launch();
		
	}
	
	public void login1() throws FileNotFoundException{
		
		
		
	file.login("admin", "password");
	}
	
	
	@Test(dataProvider = "uom1")
	public void uom1(String uid,String desc){
		
		
		file.uom(uid,desc);
		
	}
	
	@DataProvider 
	public Object[][] uom1(){
		
		Object[][] obj = new Object [4][2];
		
		
		obj[0][0]= "sel123";		
		obj[0][1]="selenium course";
		

		obj[1][0]= "seljvjkd";		
		obj[1][1]="selenium course gdfg";
		return obj;
	}
	
	
	
	
	
	
	
}
