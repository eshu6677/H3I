package com.bonasri;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class bonasriCRMverification {
	String bonusnmae = "'MABAR Zero Quota:'";
	@Test
	public void test() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://10.64.19.138:6100/ecommunications_enu/start.swe?");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//input[@name='SWEUserName']")).sendKeys("sadmin");
	    driver.findElement(By.xpath("//input[@name='SWEPassword']")).sendKeys("sadminu#t");
	    driver.findElement(By.xpath("//a[contains(@onclick,'SWEExecuteLogin')]")).click();
	    
	    Thread.sleep(15000);
	    driver.findElement(By.xpath("//a[contains(text(),\"Subscriptions\")]")).click();
	    driver.findElement(By.xpath(bonusnmae).xpath("//input[@aria-label=\"MSISDN\"]")).sendKeys("6289688041448");
	    driver.findElement(By.xpath("//button[@aria-label=\"Search:Go\"]")).click();
	    driver.findElement(By.xpath("	//a[@class=\"drilldown\" and @name=\"HCPT-MSISDN\"]")).click();
		
		WebElement select = driver.findElement(By.xpath("//select[@aria-label=\"Third Level View Bar\"]"));
		
		Select s= new Select(select);
		s.selectByVisibleText("Bonus & Promotions");
		for(int i=6; i>1;i--) {
			
		System.out.println("click on next button");
		driver.findElement(By.xpath("(//span[@title=\"Next record set\"])[1]")).click();
		
		}
		driver.findElement(By.xpath("//td[@title="+bonusnmae+"]")).click();
		
		
		String DetailedBonus= driver.findElement(By.xpath("//td[@title=\"MABAR Zero Quota:\"]/following-sibling::td")).getText();
	System.out.println(" DetailedBonus = " + DetailedBonus);
	
	DetailedBonus.substring(5);
	
	
	
	}  

}
