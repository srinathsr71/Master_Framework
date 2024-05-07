package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class HomePage extends BaseClass {
	public Action ab=new Action();

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[contains(text(),'My personal information')]")
	private WebElement mywishlist;
	
	@FindBy(xpath="//span[contains(text(),'Order history and details')]")
	private WebElement orderHistory;
	
	public boolean validateMyWishlist() {
		return ab.isDisplayed(getDriver(), mywishlist);
	}
	public boolean validateorderHistory() {
		return ab.isDisplayed(getDriver(),orderHistory);
	}
	
	public String  getCurrURL() {
		String curl=getDriver().getCurrentUrl();
		return curl;
	}
	
	
	
	
	
	

}
