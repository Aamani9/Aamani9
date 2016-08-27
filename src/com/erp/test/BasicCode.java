package com.erp.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BasicCode {

	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://webapp.qedgetech.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='username']")).clear();
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath(".//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("master");
		driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
	
	//Suppliers
		driver.findElement(By.xpath(".//*[@id='mi_a_suppliers']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='x_Supplier_Name']")).sendKeys("Aamani");
		driver.findElement(By.xpath(".//*[@id='x_Address']")).sendKeys("APHB colony Jcl");
		driver.findElement(By.xpath(".//*[@id='x_City']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath(".//*[@id='x_Country']")).sendKeys("India");
		driver.findElement(By.xpath(".//*[@id='x_Contact_Person']")).sendKeys("Kaivalya");
		driver.findElement(By.xpath(".//*[@id='x_Phone_Number']")).sendKeys("9703819699");
		driver.findElement(By.xpath(".//*[@id='x__Email']")).sendKeys("aamani.gunukula@gmail.com");
		driver.findElement(By.xpath(".//*[@id='x_Mobile_Number']")).sendKeys("9885953566");
		driver.findElement(By.xpath(".//*[@id='x_Notes']")).sendKeys("May i know product price?");
		driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();

		//StockItems
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).perform();
		driver.findElement(By.xpath(".//*[@id='mi_a_stock_categories']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='x_Category_Name']")).sendKeys("Shirts");
		driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		
	
		
	//UOM
		
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).perform();
		driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='x_UOM_ID']")).sendKeys("3699");
		driver.findElement(By.xpath(".//*[@id='x_UOM_Description']")).sendKeys("gyg");
		driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		
	
	
	
	}

}
