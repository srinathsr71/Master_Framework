package com.mf.testsuites;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mf.base.BaseClass;
//import com.mf.dataprovider.DataProviders;
import com.mf.pageobjects.AccountCreationPage;
import com.mf.pageobjects.HomePage;
import com.mf.pageobjects.IndexPage;
import com.mf.pageobjects.LoginPage;
import com.mf.utility.Log;
import com.mf.dataprovider.DataProviders;

public class Test_AccountCreation extends BaseClass {
	
	public IndexPage ip;
	public LoginPage loginpage1;
	public AccountCreationPage acp;
	@Parameters("browsername")
	@BeforeMethod
	public void bt() throws IOException {
		intialization();
		
	}
	
	@Test(dataProvider = "email",dataProviderClass = DataProviders.class,groups = "Sanity")
	public void verifyCreateAccountPage(String Email) throws IOException,InterruptedException {
		Log.startTestCase("verifyCreateAccountPage");
		ip=new IndexPage();
		loginpage1=ip.clickOnSignin();
		Thread.sleep(5000);
		acp=loginpage1.createNewAccount(Email);
		Thread.sleep(5000);
		boolean re=acp.validateformTitle();
		Assert.assertTrue(re);
		Log.endTestCase("verifyCreateAccountPage");
		
	}
	
	@AfterMethod
	public void at() {
		getDriver().quit();
	}

}
