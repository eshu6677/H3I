package com.utilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	protected String ModheaderName = "X-MSP-MSISDN";
	protected String ModHeaderValue = "6289688038873";
	protected String TurkaPoints = "'5'";
	protected String bonusnmae = "'MABAR Zero Quota:'";
	protected String bonus = "'CLVoucher Heonz Cashback 50%'";
	
	protected WebDriver driver;
	@BeforeClass
	public void onStart() throws Exception{
		
		MyScreenRecorder.startRecording("navigationTest");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\H3I pROJECT\\BONSTRI\\Drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		//Adding Chrome Extension
		options.addExtensions(new File("C:\\Users\\DELL\\H3I pROJECT\\BONASRI\\ExtensionsCRXFile\\3.1.26_0.crx"));
		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		
		driver.close();
		
		MyScreenRecorder.stopRecording();
	}

}
