package com.mf.testsuites;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mf.base.BaseClass;
import com.mf.pageobjects.AddToCartPage;
import com.mf.pageobjects.IndexPage;
import com.mf.pageobjects.OrderPage;
import com.mf.pageobjects.OrderSummary;
import com.mf.pageobjects.SearchResultPage;
import com.mf.utility.Log;

public class Test_OrderPage extends BaseClass {
	public IndexPage ip;
	public SearchResultPage sp;
	public AddToCartPage acp;
	public OrderPage os;
	@Parameters("browsername")
	@BeforeMethod
	public void bt() throws IOException {
		intialization();
	}
	
	@Test(groups = "Regression")
	public void verifyProductPrice() {
		Log.startTestCase("verifyProductPrice");
		ip=new IndexPage();
		sp=ip.searchProduct("Dresses");
		acp=sp.clickonProduct();
		acp.enterPopup();
		acp.selectsize("S");
		acp.product_color();
		acp.enterQuantity("2");
		acp.ClickonAddToCart();
		os=acp.clickOnCheckOut();
		Double unitprice =os.getUnitPrice();
		System.out.println(unitprice);
		Double totalprice=os.getTotalPrice();
		System.out.println(totalprice);
		Double totalexpectedprice=(unitprice*2)+2;
		System.out.println(totalexpectedprice);
		//Assert.assertEquals(tp,ttp);
		Log.endTestCase("verifyProductPrice");
	}
	
	@AfterMethod
	public void at() {
		getDriver().quit();
	}	
			
}
