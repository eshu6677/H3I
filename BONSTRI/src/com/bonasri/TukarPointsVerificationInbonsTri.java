package com.bonasri;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.utilities.BaseClass;

public class TukarPointsVerificationInbonsTri extends BaseClass {
	
	private static Logger logger = LogManager.getLogger(TukarPointsVerificationInbonsTri.class);
	
	@Test
	public void TukarPointsVerificationInbonsTri() throws Exception {
	
		Thread.sleep(8000);
		//Adding Name and value in ModHeader
		driver.get("chrome-extension://idgpnmonknjnojddfkpgkljpfnnfcklj/popup.html");
		driver.findElement(By.xpath("//input[@list=\"request-autocomplete\"]")).sendKeys(ModheaderName);
		driver.findElement(By.xpath("//input[@placeholder=\"Value\"]")).sendKeys(ModHeaderValue);
		Thread.sleep(6000);
		logger.info("(\"-----Enter BansTri URL------");
		driver.get("http://10.64.28.62/home");
		logger.info("-----Enter BansTri URL------");
		driver.get("http://10.64.28.62");
		
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
		
	//	options.setExperimentalOption("deviceMetrics", deviceMetrics);
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
    Reporter.log(Points);
    
	
}

}
