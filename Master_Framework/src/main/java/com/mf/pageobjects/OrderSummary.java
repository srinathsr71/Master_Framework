package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class OrderSummary extends BaseClass{
	
	
	public OrderSummary() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmorderBtn;
	
	public OrderConfirmationPage clickconfirmBtn() {
		Action.click(getDriver(), confirmorderBtn);
		return new OrderConfirmationPage();
	}

}
