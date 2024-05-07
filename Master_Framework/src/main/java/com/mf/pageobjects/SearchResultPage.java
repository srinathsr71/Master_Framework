package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class SearchResultPage extends BaseClass {
	public Action aj=new Action();
	public SearchResultPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	
	@FindBy(xpath="//ul[@class='product_list grid row']/li[2]//img")
	private WebElement productresult;
	

	public boolean isProductAvailable() {
		return aj.isDisplayed(getDriver(), productresult);
	}
	
	public AddToCartPage clickonProduct() {
		Action.click(getDriver(), productresult);
		return new AddToCartPage();
	}


}
