package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class OrderPage extends BaseClass {
	
	public OrderPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(xpath="//td[@class='cart_unit']/ul/li")
	private WebElement unitPrice;
	
	@FindBy(xpath="//span[@id='total_price']")
	private WebElement totalPrice;

	@FindBy(xpath="//p[@class='cart_navigation clearfix']/a/span")
	private WebElement proceedtocheckout;
	
	
	
	
	public double getUnitPrice() {
		String unitprice1=unitPrice.getText();
		String unit=unitprice1.replaceAll("[^a-zA-Z0-9]","");
		double finalunitprice=Double.parseDouble(unit);
		return finalunitprice/100;
	}
	
	public double getTotalPrice() {
		String totalprice1=totalPrice.getText();
		String tot=totalprice1.replaceAll("[^a-zA-Z0-9]","");
		double finaltotalprice=Double.parseDouble(tot);
		return finaltotalprice/100;
	}
	
	public LoginPage clickOnCheckout() {
		Action.click(getDriver(), proceedtocheckout);
		return new LoginPage();
	}
}
