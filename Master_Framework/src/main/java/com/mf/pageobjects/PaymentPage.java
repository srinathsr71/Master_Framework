package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class PaymentPage extends BaseClass {
	
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath="//a[@class='bankwire']")
	private WebElement bankwire;
	
	@FindBy(xpath="//a[contains(text(),'Pay by check')]")
	private WebElement paycheck;
	
	public OrderSummary clickonpaymentwire() {
		Action.click(getDriver(), bankwire);
		return new OrderSummary();
	}

}
