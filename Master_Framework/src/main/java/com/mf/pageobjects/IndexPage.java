package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class IndexPage extends BaseClass {
	public Action ac=new Action();
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
@FindBy(xpath="//a[@class='login']")
private WebElement signInBtn;

@FindBy(xpath="//img[@class='logo img-responsive']")
private WebElement mystorelogo;

@FindBy(id="search_query_top")
private WebElement searchbox;

@FindBy(name="submit_search")
private WebElement searchbtn;


	public LoginPage clickOnSignin() {
		Action.click(getDriver(),signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() {
		return ac.isDisplayed(getDriver(), mystorelogo);
	}
	
	
	public String getMyStoreTitle() {
		String mystore=getDriver().getTitle();
		return mystore;
	}
	
	public SearchResultPage searchProduct(String productname) {
		ac.type(searchbox, productname);
		Action.click(getDriver(), searchbtn);
		return new SearchResultPage();
	}
	
	
	
	
}
