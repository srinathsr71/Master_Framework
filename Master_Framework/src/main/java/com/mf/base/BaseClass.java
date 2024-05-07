package com.mf.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.mf.actions.Action;
import com.mf.utility.ExtentManager;
import com.mf.utility.FileInfo;
//import com.mf.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriverManager drivermanager;
//public static WebDriver driver;
public static FileInfo fj=new FileInfo();

public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
public void beforesuite() throws IOException {
	ExtentManager.setExtent();
	DOMConfigurator.configure("log4j.xml");
}


public static WebDriver getDriver() {
	return driver.get();
}

//	@BeforeClass
//	@Parameters("browseropen")
//	public void intialization(String bname) throws IOException  {
//		if(bname.equalsIgnoreCase("chrome")) {
//			System.out.println("setting up chrome browser");
//			drivermanager.chromedriver().setup();
//			driver.set(new ChromeDriver()) ;
//		}else if(bname.equalsIgnoreCase("firefox")) {
//			System.out.println("setting up chrome browser");
//			drivermanager.firefoxdriver().setup();
//			driver.set(new FirefoxDriver()) ;
//		}else if(bname.equalsIgnoreCase("edge")) {
//			System.out.println("setting up edge browser");
//			drivermanager.edgedriver().setup();
//			driver.set(new EdgeDriver()) ;
//		}else {
//			System.out.println("browser is not opening");
//		}
public void intialization() throws IOException  {
	if(fj.FileData("browser").equalsIgnoreCase("chrome")) {
		System.out.println("setting up chrome browser");
		drivermanager.chromedriver().setup();
		driver.set(new ChromeDriver()) ;
	}else if(fj.FileData("browser").equalsIgnoreCase("firefox")) {
		System.out.println("setting up chrome browser");
		drivermanager.firefoxdriver().setup();
		driver.set(new FirefoxDriver()) ;
	}else if(fj.FileData("browser").equalsIgnoreCase("edge")) {
		System.out.println("setting up edge browser");
		drivermanager.edgedriver().setup();
		driver.set(new EdgeDriver()) ;
	}else {
		System.out.println("browser is not opening");
	}
		//driver.set(new EdgeDriver());
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 10);
		Action.pageLoadTimeOut(getDriver(), 10);
		getDriver().get(fj.FileData("url"));
	}
	
	
	
	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
