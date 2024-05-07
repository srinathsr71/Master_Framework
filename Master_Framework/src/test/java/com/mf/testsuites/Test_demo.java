package com.mf.testsuites;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mf.base.BaseClass;
import com.mf.pageobjects.IndexPage;
import com.mf.utility.Log;

public class Test_demo extends BaseClass {
	@Parameters("browseropen")
	@BeforeMethod
	public void bt() throws IOException {
		intialization();
	}
	
	
	@Test
	public void wishListTest() throws IOException {
		System.out.println("welcome to homepage");
	}
	
	@AfterMethod
	public void at() {
		getDriver().quit();
	}
}
