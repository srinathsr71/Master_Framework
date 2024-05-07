package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class ShippingPage extends BaseClass {
	
	
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="cgv")
	private WebElement terms;
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedtocheckoutbtn;
	
	public void checkTerms() {
		Action.click(getDriver(), terms);
	}
	public PaymentPage clickOnProceedcheckoutbtn() {
		Action.click(getDriver(), proceedtocheckoutbtn);
		return new PaymentPage();
	}	

}
