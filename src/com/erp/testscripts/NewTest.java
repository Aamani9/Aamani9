package com.erp.testscripts;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.erp.master.LibFile;

public class NewTest {

	public LibFile file = new LibFile();
	
	@Test(priority=2)
  public void uom() {
		
		file.uom("5756ff44", "this is stupidity");
		
  }
	@Test(priority=3)
public void suppliers(){
	
		file.suppliers("swaran", "delhi","hyderabad", "India", "kutty", "9885943566","swaran@gmail.com","9885013699", "product avaliable");
	
}

	@BeforeTest
  public void beforeTest() throws FileNotFoundException {
	  
	  file.login("admin", "master");
  }
@AfterTest
  public void afterTest() {
	  
	  file.logout();
  }
  
  

  @BeforeSuite
  public void beforeSuite() {
	  
	  file.launch();
  }

  @AfterSuite
  public void afterSuite() {
	  
	  file.close();
	  
  }

}
