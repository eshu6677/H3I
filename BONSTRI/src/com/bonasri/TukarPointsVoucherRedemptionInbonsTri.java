package com.bonasri;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.utilities.BaseClass;

public class TukarPointsVoucherRedemptionInbonsTri extends BaseClass {
	
  
	private static Logger logger = LogManager.getLogger(TukarPointsVoucherRedemptionInbonsTri.class);
	
	@Test
	public void TukarPointsRedemptionThroughbonsTri() throws Exception {
	
		
		Thread.sleep(8000);
		//Adding Chrome Extenction
		driver.get("chrome-extension://idgpnmonknjnojddfkpgkljpfnnfcklj/popup.html");
		driver.findElement(By.xpath("//input[@list=\"request-autocomplete\"]")).sendKeys(ModheaderName);
		driver.findElement(By.xpath("//input[@placeholder=\"Value\"]")).sendKeys(ModHeaderValue);
		Thread.sleep(6000);
		logger.info("(\"-----Enter BansTri URL------");
		driver.get("http://10.64.28.62/home");
		logger.info("-----Enter BansTri URL------");
		driver.get("http://10.64.28.62");
		
		Thread.sleep(6000);
        Robot robot= new Robot();
        robot.keyPress(KeyEvent.VK_F12);
		Thread.sleep(15000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(KeyEvent.VK_M);
		
		
		
        robot.keyRelease(KeyEvent.VK_M);
		robot.keyRelease(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_F12);
		
		Thread.sleep(15000);
		logger.info("-----Enter BansTri URL------");
		driver.get("http://10.64.28.62");
		
		robot.keyPress(KeyEvent.VK_F12);
		Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_F12);
		
		Thread.sleep(5000);
      //clicking on close ----X-----
		logger.info("--------clicking on close ----X-----");
      driver.findElement(By.xpath("//span[@aria-hidden=\"true\"]")).click();
      
      Thread.sleep(10000);
      logger.info("--------GET BonsTri POINTS---------");
      String Points= driver.findElement(By.xpath("(//strong[contains(text,hari)])[2]")).getText();
      System.out.println("Total Points Available = " + Points);
    
      Thread.sleep(10000);
    
      logger.info("--------Click on Vocher Kue---------");
      JavascriptExecutor js1= (JavascriptExecutor) driver;
      WebElement ele1 = driver.findElement(By.xpath("//b[contains(text(),'Voucher ku')]"));
      js1.executeScript("arguments[0].click();", ele1);
   
   
      Thread.sleep(10000);
      String VocherName = ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",driver.findElement(By.xpath("(//p[contains(text(),"+ bonus +")])[2]"))).toString();
      System.out.println(VocherName);

      Thread.sleep(10000);
 	
 	  logger.info("--------Click on Gunakan ---------");  
 	  JavascriptExecutor js4= (JavascriptExecutor) driver;
      WebElement ele3 = driver.findElement(By.xpath("(//div[contains(text(),'Gunakan')])[2]"));
      js4.executeScript("arguments[0].click();", ele3);
        
      logger.info("--------Click on Gunakan ---------");  
      JavascriptExecutor js2= (JavascriptExecutor) driver;
      WebElement ele2 = driver.findElement(By.xpath("//button[contains(text(),'Gunakan')]"));
      js2.executeScript("arguments[0].click();", ele2);
        
      String thankumessage = ((JavascriptExecutor) driver).executeScript("return arguments[0].innerHTML;",driver.findElement(By.xpath("//h3[contains(text(),'Terima kasih.')]"))).toString();
      //String thankumessage=driver.findElement(By.xpath("//h3[contains(text(),'Terima kasih.')]")).getText();
      System.out.println("Success message = " + thankumessage);
     
      driver.findElement(By.xpath("(//button[contains(text(),'OK')])[1]")).click();
  
 
 
 
      Thread.sleep(10000);
    
    logger.info("--------Lunch CRM Applicatiom ---------");
    driver.get("http://10.64.19.138:6100/ecommunications_enu/start.swe?");
    
    logger.info("--------Enter User Name In CRMGUI ---------");
    driver.findElement(By.xpath("//input[@name='SWEUserName']")).sendKeys("sadmin");
    
    logger.info("--------Enter Password Name In CRMGUI ---------");
    driver.findElement(By.xpath("//input[@name='SWEPassword']")).sendKeys("sadminu#t");
    
    logger.info("--------Click on LogIn Button in CRMGUI ---------");
    driver.findElement(By.xpath("//a[contains(@onclick,'SWEExecuteLogin')]")).click();
    
    WebDriverWait wait= new WebDriverWait(driver,80);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(),\"Subscriptions\")]")));
    Thread.sleep(10000);
    logger.info("--------Click on Subscriptions Button in CRMGUI ---------");
    driver.findElement(By.xpath("//a[contains(text(),\"Subscriptions\")]")).click();
    
    logger.info("--------Enter MSISDN Name In CRMGUI ---------");
    driver.findElement(By.xpath("//input[@aria-label=\"MSISDN\"]")).sendKeys(ModHeaderValue);
    
    logger.info("--------Click on Search Button in CRMGUI ---------");
    driver.findElement(By.xpath("//button[@aria-label=\"Search:Go\"]")).click();
    
    logger.info("--------Click on HCPT-MSISDN Link in CRMGUI ---------");
    driver.findElement(By.xpath("	//a[@class=\"drilldown\" and @name=\"HCPT-MSISDN\"]")).click();
    
    logger.info("--------Select Bonus & Promotions from Third Level View Bar in CRMGUI ---------");
    WebElement select = driver.findElement(By.xpath("//select[@aria-label=\"Third Level View Bar\"]"));
	Select s= new Select(select);
	s.selectByVisibleText("Bonus & Promotions");
	
	for(int i=6; i>1;i--) {	
		logger.info("--------click on next button in Bonus & Promotions---------");
	driver.findElement(By.xpath("(//span[@title=\"Next record set\"])[1]")).click();
	}
	
	logger.info("--------Select the Spacified Bonus under Bonus & Promotions---------");
	driver.findElement(By.xpath("//td[@title="+bonusnmae+"]")).click();
	
	logger.info("--------Get The Detailer Bonus From Bonus & Promotions ---------");
	String DetailedBonus= driver.findElement(By.xpath("//td[@title=\"MABAR Zero Quota:\"]/following-sibling::td")).getText();
    System.out.println(" DetailedBonus = " + DetailedBonus);

   



}  
 
	}


	


