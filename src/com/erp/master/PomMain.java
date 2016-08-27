package com.erp.master;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class PomMain {

	public WebDriver driver;
	
	@Test
	public void pom()
	{
	
	driver = new FirefoxDriver();
	
	driver.navigate().to("http://webapp.qedgetech.com/");
	
	driver.manage().window().maximize();
	
	PomFramework p = PageFactory.initElements(driver,PomFramework.class);
	
	p.login("admin", "master");
	
	}
	
	@Test(dependsOnMethods="pom")
	public void spom() throws IOException{
		
		SuppliersPom pm = PageFactory.initElements(driver, SuppliersPom.class);
		//pm.suppliers("1245", "madhu", "jcl", "hyd", "india", "swaran", "9885013699", "aamani.naidu9@gmail.com", "458455","idiot");
		pm.xloperation();
		
		
	}
	
}
