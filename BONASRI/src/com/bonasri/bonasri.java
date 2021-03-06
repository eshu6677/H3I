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
import org.testng.annotations.Test;

public class bonasri {
	
    String ModheaderName = "X-MSP-MSISDN";
	String ModHeaderValue = "6289688041448";
	String TurkaPoints = "'5 point'";
	private static Logger logger = LogManager.getLogger(bonasri.class);
	
	@Test
	public void TestBonasriVocher() throws Exception {
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		Map<String , String > mobileEmulation = new HashMap<>();
		mobileEmulation.put("deviceName", "Samsung Galaxy S8+");
		
		Map<String , Object > deviceMetrics = new HashMap<>();
		
		deviceMetrics.put("width", "480");
		deviceMetrics.put("height", "525");
		
;		ChromeOptions options = new ChromeOptions();
		
		//Adding Chrome Extension
		options.addExtensions(new File("C:\\Users\\DELL\\H3I pROJECT\\BONASRI\\ExtensionsCRXFile\\3.1.26_0.crx"));
		
		
		WebDriver driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(8000);
		//Adding Name and value in ModHeader
		driver.get("chrome-extension://idgpnmonknjnojddfkpgkljpfnnfcklj/popup.html");
		driver.findElement(By.xpath("//input[@list=\"request-autocomplete\"]")).sendKeys(ModheaderName);
		driver.findElement(By.xpath("//input[@placeholder=\"Value\"]")).sendKeys(ModHeaderValue);
		Thread.sleep(6000);
		logger.info("(\"-----enter URL------");
		driver.get("http://10.64.28.62/home");
		logger.info("-----enter URL------");
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
		
		options.setExperimentalOption("deviceMetrics", deviceMetrics);
		driver.get("http://10.64.28.62");
		
		robot.keyPress(KeyEvent.VK_F12);
		Thread.sleep(5000);
		robot.keyRelease(KeyEvent.VK_F12);
		
		Thread.sleep(5000);
      //clicking on close ----X-----
		logger.info("--------clicking on close ----X-----");
      driver.findElement(By.xpath("//span[@aria-hidden=\"true\"]")).click();
      Thread.sleep(10000);
      logger.info("--------GET POINTS---------");
     String Points= driver.findElement(By.xpath("(//strong[contains(text,hari)])[2]")).getText();
    System.out.println("Total Points Available = " + Points);
    
    logger.info("--------CLICK ON Tukar---------");
    driver.findElement(By.xpath("//b[contains(text(),'Tukar')]")).click();
    logger.info("--------CLICK ON TurkaPoints---------");
    driver.findElement(By.xpath("//span[contains(text(),"+TurkaPoints+")]")).click();
    Thread.sleep(5000);
    logger.info("--------CLICK ON Points---------");
    JavascriptExecutor js= (JavascriptExecutor) driver;
    
    WebElement ele = driver.findElement(By.xpath("(//div[contains(text(),'point')])[2]"));
    js.executeScript("arguments[0].click();", ele);
    logger.info("--------CLICK ON Tukar---------");
    driver.findElement(By.xpath("//button[contains(text(),'Tukar')]")).click();
    logger.info("--------get text---------");
    Thread.sleep(10000);
    String BerhasilMessage =  driver.findElement(By.xpath("//h3[contains(text(),\"Berhasil!\")]")).getText();
    System.out.println("BerhasilMessage = " + BerhasilMessage); 
    
    driver.get("http://10.64.19.138:6100/ecommunications_enu/start.swe?");
    
    driver.findElement(By.xpath("//input[@name='SWEUserName']")).sendKeys("sadmin");
    driver.findElement(By.xpath("//input[@name='SWEPassword']")).sendKeys("sadminu#t");
    driver.findElement(By.xpath("//a[contains(@onclick,'SWEExecuteLogin')]")).click();
    
    Thread.sleep(15000);
    driver.findElement(By.xpath("//a[contains(text(),\"Subscriptions\")]")).click();
    driver.findElement(By.xpath("//input[@aria-label=\"MSISDN\"]")).sendKeys(ModHeaderValue);
    driver.findElement(By.xpath("//button[@aria-label=\"Search:Go\"]")).click();
    driver.findElement(By.xpath("	//a[@class=\"drilldown\" and @name=\"HCPT-MSISDN\"]")).click();
    
    
 
	}


	}


