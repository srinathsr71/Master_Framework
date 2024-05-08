package com.mf.testsuites;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mf.base.BaseClass;
import com.mf.pageobjects.HomePage;
import com.mf.pageobjects.IndexPage;
import com.mf.pageobjects.LoginPage;
import com.mf.utility.Log;

public class Test_homePage extends BaseClass {
	public IndexPage il;
	public LoginPage loginPage1;
	public HomePage homepage1;
	@Parameters("browsername")
	@BeforeMethod(groups="Smoke")
	public void bt() throws IOException {
		intialization();
	}
	
	
	@Test(groups="Smoke")
	public void wishListTest() throws IOException, InterruptedException  {
		Log.startTestCase("wishListTest");
		il=new IndexPage();
		loginPage1=il.clickOnSignin();
		homepage1=loginPage1.login(fj.FileData("username"),fj.FileData("password"));
		Thread.sleep(7000);
		boolean result=homepage1.validateMyWishlist();
		Assert.assertTrue(result);
		Thread.sleep(7000);
		Log.endTestCase("wishListTest");
	
	}
	
	@Test(groups="Smoke")
	public void orderHistoryTest() throws IOException, InterruptedException  {
		Log.startTestCase("orderHistoryTest");
		il=new IndexPage();
		loginPage1=il.clickOnSignin();
		homepage1=loginPage1.login(fj.FileData("username"),fj.FileData("password"));
		boolean result1=homepage1.validateorderHistory();
		Assert.assertTrue(result1);
		Thread.sleep(7000);
		Log.endTestCase("orderHistoryTest");
	}
	
	
	@AfterMethod(groups="Smoke")
	public void at() {
		getDriver().quit();
	}	
}
