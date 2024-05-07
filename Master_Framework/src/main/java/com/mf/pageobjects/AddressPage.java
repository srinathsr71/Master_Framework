package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;


public class AddressPage  extends BaseClass{
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//p[@class='cart_navigation clearfix']/button/span")
	private WebElement proceedtocheckout;
	
	public ShippingPage clickOncheckout() {
		Action.click(getDriver(), proceedtocheckout);
		return new ShippingPage();
	}

}
