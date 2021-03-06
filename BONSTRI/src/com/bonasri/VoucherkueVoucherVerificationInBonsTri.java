package com.bonasri;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utilities.BaseClass;

public class VoucherkueVoucherVerificationInBonsTri extends BaseClass {
	
	
	private static Logger logger = LogManager.getLogger(VoucherkueVoucherVerificationInBonsTri.class);
	@Test
	public void VoucherkueVoucherVerificationInBonsTri() throws Exception {
		
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
      
      driver.findElement(By.xpath("//a[contains(text(),'Used Voucher')]")).click();
      
      
      
		
      
      
		
		
	}
	

}
