package com.erp.master;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomFramework 
{

	
	@FindBy(xpath=".//*[@id='username']")
	WebElement uname;
	@FindBy(xpath=".//*[@id='password']")
	WebElement pwd;
	@FindBy(xpath=".//*[@id='btnsubmit']")
	WebElement login;
	@FindBy(xpath=".//*[@id='btnreset']")
	WebElement reset;
	
	
	public void login(String username,String password){
			
		reset.click();
		//uname.clear();
		uname.sendKeys(username);
		pwd.sendKeys(password);
		login.click();
		
	}
}
