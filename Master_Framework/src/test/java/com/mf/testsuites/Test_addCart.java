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
import com.mf.pageobjects.AddToCartPage;
import com.mf.pageobjects.IndexPage;
import com.mf.pageobjects.LoginPage;
import com.mf.pageobjects.SearchResultPage;
import com.mf.utility.Log;

public class Test_addCart extends BaseClass{
	
	public IndexPage ip;
	public SearchResultPage sp;
	public AddToCartPage acp;
	
	@BeforeMethod
	public void bt() throws IOException {
		intialization();
	}

	
	@Test
	public void addtocart() {
		Log.startTestCase("addtocart");
		ip=new IndexPage();
		sp=ip.searchProduct("Dresses");
		acp=sp.clickonProduct();
		//acp.closeIcon();
		acp.enterPopup();
//		acp.getProductText();
		acp.selectsize("S");
		acp.product_color();
		acp.enterQuantity("2");
		acp.ClickonAddToCart();
		boolean gt=acp.validateAddtocart();
		Assert.assertTrue(gt);
		Log.endTestCase("addtocart");
	}
	
	@AfterMethod
	public void at() {
		getDriver().quit();
	}			
	
	
}
