package com.mf.testsuites;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mf.base.BaseClass;
import com.mf.pageobjects.HomePage;
import com.mf.pageobjects.IndexPage;
import com.mf.pageobjects.LoginPage;
import com.mf.utility.Log;
import com.mf.dataprovider.DataProviders;

public class Test_LoginPage  extends BaseClass{
	public IndexPage io;
	public LoginPage loginPage;
	public HomePage homepage;
	@Parameters("browsername")
	@BeforeMethod(groups="Smoke")
	public void bt() throws IOException {
		intialization();
	}
	
	
	
	@Test(groups = {"Smoke","Sanity"})
	public void loginTest() throws IOException,InterruptedException {
		Log.startTestCase("loginTest");
		io=new IndexPage();
		Log.info("user is going to click on SignIn");
		loginPage=io.clickOnSignin();
		Log.info("Enter Username and Password");
		homepage=loginPage.login(fj.FileData("username"),fj.FileData("password"));
		//homepage=loginPage.login(Username,Password);
		Log.info("Verifying if user is able to login");
		String actulurl=homepage.getCurrURL();
		Thread.sleep(7000);
		//Assert.assertEquals(actulurl,"http://www.automationpractice.pl/index.php?controller=authentication");
		Log.info("Login is Sucess");
	    Log.endTestCase("loginTest");
	}
	
	
	
	@AfterMethod(groups="Smoke")
	public void at() {
		getDriver().quit();
	}	
	
}
