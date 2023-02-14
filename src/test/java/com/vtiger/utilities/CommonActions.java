package com.vtiger.utilities;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

public class CommonActions {
	
	private static WebDriver driver;
	private static ExtentTest logger;
	static WebDriverWait wait;
	public CommonActions(WebDriver driver,ExtentTest logger)
	{
		this.driver=driver;
		this.logger=logger;
	 wait=new WebDriverWait(driver,Duration.ofSeconds(30));	
	}
	
	

	public static void EnterValue(WebElement elm,String value,String msg)
	{
	try
	{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.clear();
		elm.sendKeys(value);
		logger.pass(value + msg + "<a href="+getscreenshot()+"><span class='label end-time'>Screenshot</span></a>");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		logger.fail("Unable to enter text due to error:"+e.getMessage()+ "<a href="+getscreenshot()+"><span class='label end-time'>Screenshot</span></a>");
	}
	}
	public static void ClickElement(WebElement elm,String msg)
	{
	try
	{
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
		logger.pass(msg + "<a href="+getscreenshot()+"><span class='label end-time'>Screenshot</span></a>");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		logger.fail("Unable to click due to error:"+e.getMessage()+ "<a href="+getscreenshot()+"><span class='label end-time'>Screenshot</span></a>");
	}
}
	public static void ElementExist(WebElement elm)
	{
	try
	{
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isDisplayed();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
}

	public static String getscreenshot() {
		DateFormat f= new SimpleDateFormat("yyyyMMddhhmmss");
		Date d = new Date();
		String str=f.format(d);
		TakesScreenshot scrShot= ((TakesScreenshot)driver);
		File SrcFile =scrShot.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/src/test/java/com/vtiger/reports/screenshots/image"+str+".png";
				File DestFile= new File(path);
		try {
			FileUtils.copyFile(SrcFile,DestFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return path;
	}
}
		
		
		