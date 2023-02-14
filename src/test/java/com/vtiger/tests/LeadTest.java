package com.vtiger.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeadTest extends BaseTest {
	
	@Test
	public void CreateLeadwithMandatoryFieldsTc03() {
		String TCName="CreateLeadwithMandatoryFieldsTc03";
		logger=extent.createTest(TCName);
		LoginPage lp = new LoginPage(driver,logger);
		lp.login(dt.get(TCName).get("UserId"), dt.get(TCName).get("Password"));
		LeadPage ldp=new LeadPage(driver,logger);
		ldp.clickNewLead();
		ldp.createLeadwithMandatoryFields(dt.get(TCName).get("Lname"), dt.get(TCName).get("Company"));
		ldp.clickLogout();
		extent.flush();
	}

}
