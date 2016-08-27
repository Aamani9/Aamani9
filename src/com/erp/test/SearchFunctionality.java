package com.erp.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchFunctionality {

	public static void main(String[] args) {
	
		WebDriver driver = new FirefoxDriver();
		driver.navigate().to("http://webapp.qedgetech.com/");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		driver.findElement(By.xpath(".//*[@id='username']")).clear();
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath(".//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("master");
		driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
		
		//suppliers
		driver.findElement(By.xpath(".//*[@id='mi_a_suppliers']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[2]/div[2]/div/button")).click();
		driver.findElement(By.xpath(".//*[@id='psearch']")).sendKeys("Aamani");
		driver.findElement(By.xpath(".//*[@id='el1_a_suppliers_checkbox']/input")).click();
		
		new Select(driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[2]/div/button"))).selectByIndex(0);
		
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		
		
		
		
		
		
		
		
		
	}

}
