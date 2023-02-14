package com.vtiger.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.pages.HeaderPage;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends BaseTest{
	
	
	@Test
	public void invalidLoginTc01() {
		String TCName="invalidLoginTc01";
		logger=extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(dt.get(TCName).get("UserId"), dt.get(TCName).get("Password"));
		extent.flush();
	}
	
	@Test
	public void ValidLoginTc02() {
		String TCName="ValidLoginTc02";
		logger=extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(dt.get(TCName).get("UserId"), dt.get(TCName).get("Password"));
		extent.flush();
		HeaderPage hdp = new HeaderPage(driver,logger);
		hdp.clickLogout();
	}
	
}