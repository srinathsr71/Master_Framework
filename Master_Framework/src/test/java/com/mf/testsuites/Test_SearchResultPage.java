package com.mf.testsuites;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mf.base.BaseClass;
import com.mf.dataprovider.DataProviders;
import com.mf.pageobjects.AccountCreationPage;
import com.mf.pageobjects.IndexPage;
import com.mf.pageobjects.LoginPage;
import com.mf.pageobjects.SearchResultPage;
import com.mf.utility.Log;

public class Test_SearchResultPage extends BaseClass {

	public IndexPage ip;
	public SearchResultPage srp;
	@Parameters("browser")
	@BeforeMethod
	public void bt() throws IOException, InterruptedException {
		intialization();
	}
	
	
	@Test
	public void productAvialable() {
		Log.startTestCase("productAvialable");
		ip=new IndexPage();
		srp=ip.searchProduct("Dresses");
		boolean res=srp.isProductAvailable();
		Assert.assertTrue(res);		
		Log.endTestCase("productAvialable");
	}
	
	
	
	@AfterMethod
	public void at() {
		getDriver().quit();
	}	
	
}
