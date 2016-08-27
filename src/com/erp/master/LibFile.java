package com.erp.master;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;

public class LibFile {

	public static WebDriver driver;
	public static Properties p;

	public static FileInputStream fis; 
	
	public static Actions act;
	
	public static String actl,exp;

	
	
public static void launch(){
		
		driver = new FirefoxDriver();
		driver.get("http://webapp.qedgetech.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("Successfully launched");
	}
	
	public static String login(String uname,String pwd) throws FileNotFoundException{
		
		driver.findElement(By.xpath(".//*[@id='username']")).clear();
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(uname);
		driver.findElement(By.xpath(".//*[@id='password']")).clear();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(pwd);
		driver.findElement(By.xpath(".//*[@id='btnsubmit']")).click();
		//System.out.println("Successfully logined");
	
		String act,exp;
		exp="Dashboard";
		act=driver.findElement(By.xpath(".//*[@id='mi_dashboard_php']/a")).getText();
		if(act.equals(exp)){
			
			
			logout();
			 return " login created ";
			
			 
		}
		else{
			
	
			 return " login failed";
		}
				
/*	String act,exp;
	act="";
	//exp=html/body/div[18]/div[2]/div/div[3]/div/div
		*/
		
		
		
		
		
}
	
	public static String suppliers(String name, String address,String city, String country, String cname,String mobilen,
			String email,String pno, String notes){
		driver.findElement(By.xpath(".//*[@id='mi_a_suppliers']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='x_Supplier_Name']")).sendKeys(name);
		driver.findElement(By.xpath(".//*[@id='x_Address']")).sendKeys(address);
		driver.findElement(By.xpath(".//*[@id='x_City']")).sendKeys(city);
		driver.findElement(By.xpath(".//*[@id='x_Country']")).sendKeys(country);
		driver.findElement(By.xpath(".//*[@id='x_Contact_Person']")).sendKeys(cname);
		driver.findElement(By.xpath(".//*[@id='x_Phone_Number']")).sendKeys(mobilen);
		driver.findElement(By.xpath(".//*[@id='x__Email']")).sendKeys(email);
		driver.findElement(By.xpath(".//*[@id='x_Mobile_Number']")).sendKeys(pno);
		driver.findElement(By.xpath(".//*[@id='x_Notes']")).sendKeys(notes);
		driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		
		
		
		String exp,act;
		
		exp="Add succeeded";
		
		act= driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
		
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		
		if (exp.equalsIgnoreCase(act)) {
			
			System.out.println("pass");
			
		}else{
			System.out.println("fail");
			}
		
		return "Successfully suppliers info added ";
	}
	
	
	public static void stockCatagories(String catagoryName){
		
		
		 act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).perform();
		driver.findElement(By.xpath(".//*[@id='mi_a_stock_categories']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='x_Category_Name']")).sendKeys(catagoryName);
		driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		System.out.println("stock catory added ");
		
	}
	
	public static String uom(String id, String decs){
		exp="Add succeeded";
		 act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).perform();
		driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='x_UOM_ID']")).sendKeys(id);
		driver.findElement(By.xpath(".//*[@id='x_UOM_Description']")).sendKeys(decs);
		driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
		Sleeper.sleepTightInSeconds(2);
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		
	actl=driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[3]/div/div")).getText();
	Sleeper.sleepTightInSeconds(2);
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
		
		if(exp.equalsIgnoreCase(actl))
		{
			return"PASS";
		}else{
		
		
		return "FAIL";
		}
	}
	
	public static void stockItems() throws IOException, InterruptedException
	{
		
		p = new Properties();
		fis = new FileInputStream("D:\\Aamani\\Aamani-Workspace\\ERP\\src\\com\\erp\\properties\\erp.properties");
		p.load(fis);
		
		
		driver.findElement(By.cssSelector(p.getProperty("supply"))).click();
		driver.findElement(By.xpath(p.getProperty("add"))).click();
		Thread.sleep(5);
		driver.findElement(By.id(p.getProperty("catagory"))).sendKeys(p.getProperty("cname"));
		driver.findElement(By.id(p.getProperty("sno"))).sendKeys(p.getProperty("supplierno"));
		driver.findElement(By.xpath(p.getProperty("stockname"))).sendKeys(p.getProperty("stock_name"));
		driver.findElement(By.xpath(p.getProperty("uom"))).sendKeys(p.getProperty("uom_value"));
		driver.findElement(By.xpath(p.getProperty("purchase_price"))).clear();
		Thread.sleep(5);
		driver.findElement(By.xpath(p.getProperty("purchase_price"))).sendKeys(p.getProperty("purchasep"));
		driver.findElement(By.xpath(p.getProperty("selling_price"))).clear();
		driver.findElement(By.xpath(p.getProperty("selling_price"))).sendKeys(p.getProperty("selprice"));
		driver.findElement(By.xpath(p.getProperty("notes_value"))).sendKeys(p.getProperty("notes"));
		driver.findElement(By.xpath(p.getProperty("ok"))).click();
		driver.findElement(By.xpath(p.getProperty("2ok"))).click();
		
		System.out.println("stockitems added successfully");
		
		
		}
	
	
	public static void logout(){
		
		driver.findElement(By.xpath(".//*[@id='logout']")).click();
		
		
		
	}
	
	public static void close(){
		
		driver.close();
	}
	
}
