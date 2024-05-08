package com.mf.testsuites;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mf.base.BaseClass;
import com.mf.pageobjects.IndexPage;
import com.mf.utility.Log;
public class Test_IndexPage extends BaseClass {
	public IndexPage in;
	@Parameters("browsername")
	@BeforeMethod(groups="Smoke")
	public void bt() throws IOException {
		intialization();
		System.out.println("browser parameter value");
	}

	@Test(groups="Smoke")
	public void verifyLogo() throws InterruptedException  { 
		Log.startTestCase("verifyLogo");
		in=new IndexPage();
		boolean result=in.validateLogo();
		Assert.assertTrue(result);
		Thread.sleep(7000);
		Log.endTestCase("verifyLogo");
	}
	
	
	@Test(groups="Smoke")
	public void verityTitle() throws InterruptedException  {
		Log.startTestCase("verityTitle");
		String  actTitle=in.getMyStoreTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle,"My Shop");
		Thread.sleep(7000);
		Log.endTestCase("verifyTitle");
	}
	
	
	
	
@AfterMethod(groups="Smoke")
	public void at() {
	getDriver().quit();
	}

}
