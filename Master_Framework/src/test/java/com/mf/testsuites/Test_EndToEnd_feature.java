package com.mf.testsuites;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mf.base.BaseClass;
import com.mf.dataprovider.DataProviders;
//import com.mf.dataprovider.DataProviders;
import com.mf.pageobjects.AddToCartPage;
import com.mf.pageobjects.AddressPage;
import com.mf.pageobjects.IndexPage;
import com.mf.pageobjects.LoginPage;
import com.mf.pageobjects.OrderConfirmationPage;
import com.mf.pageobjects.OrderPage;
import com.mf.pageobjects.OrderSummary;
import com.mf.pageobjects.PaymentPage;
import com.mf.pageobjects.SearchResultPage;
import com.mf.pageobjects.ShippingPage;
import com.mf.utility.Log;

public class Test_EndToEnd_feature extends BaseClass {
	public IndexPage ip;
	public SearchResultPage sp;
	public AddToCartPage acp;
	public OrderPage os;
	public LoginPage lp;
	public AddressPage adp;
	public ShippingPage ss;
	public PaymentPage pp;
	public OrderSummary op;
	public OrderConfirmationPage cop;
	
	@Parameters("browsername")
	@BeforeMethod(groups = "Smoke")
	public void bt() throws IOException {
		intialization();
	}
	
	@Test(groups = "Smoke")
	public void endToEndTest() throws IOException {
		Log.startTestCase("endToEndTest");
		ip=new IndexPage();
		sp=ip.searchProduct("Dresses");
		acp=sp.clickonProduct();
		acp.enterPopup();
		acp.selectsize("S");
		acp.product_color();
		acp.enterQuantity("2");
		acp.ClickonAddToCart();
		os=acp.clickOnCheckOut();
		lp=os.clickOnCheckout();
		adp=lp.login1(fj.FileData("username"),fj.FileData("password"));
		//adp=lp.login1(Username,Password);
		
		ss=adp.clickOncheckout();
		ss.checkTerms();
		pp=ss.clickOnProceedcheckoutbtn();
		op=pp.clickonpaymentwire();
		cop=op.clickconfirmBtn();
		String actual=cop.validateconfirmmessage();
		Assert.assertEquals(actual,"Your order on My Shop is complete.");
		Log.endTestCase("endToEndTest");
	}
	
	@AfterMethod(groups = "Smoke")
	public void at() {
		getDriver().quit();
	}	

}
