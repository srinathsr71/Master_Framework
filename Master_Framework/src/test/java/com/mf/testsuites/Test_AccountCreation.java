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
	@Parameters("browser")
	@BeforeMethod
	public void bt() throws IOException {
		intialization();
		
	}
	
	@Test
	public void verifyCreateAccountPage() throws IOException {
		Log.startTestCase("verifyCreateAccountPage");
		ip=new IndexPage();
		loginpage1=ip.clickOnSignin();
		acp=loginpage1.createNewAccount("shu@gmail.com");
		boolean re=acp.validateformTitle();
		Assert.assertTrue(re);
		Log.endTestCase("verifyCreateAccountPage");
		
	}
	
	@AfterMethod
	public void at() {
		getDriver().quit();
	}
}
