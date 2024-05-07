package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class AddToCartPage extends BaseClass {
	public Action ak=new Action();
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//p[@id='add_to_cart']/button")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id='layer_cart']//h2/i")
	private WebElement addtocartmessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	@FindBy(xpath="//body[@id='product']/div/div/div[2]/h1")
	private WebElement protext;
	
	@FindBy(xpath="//a[@class='fancybox-item fancybox-close']")
	private WebElement closing;
	
	
	@FindBy(id="product")
	private WebElement pids;
	
	
	@FindBy(xpath="//a[@title='Pink']")
	private WebElement pcolor;
	
	public void product_color() {
		ak.click(getDriver(), pcolor);
	}
	
	public void closeIcon() {
		ak.click(getDriver(), closing);
	}
	public void enterPopup() {
		//ak.switchToFrameByName(getDriver(), "fancybox-frame1714398297066");
		ak.switchToFrameByIndex(getDriver(), 0);
		
	}
	
	public void getProductText() {
		String ju=protext.getText();
		System.out.println(ju);
	}
	public void enterQuantity(String quan) {
		ak.type(quantity, quan);
	}
	public void selectsize(String size1) {
		ak.selectByValue(size,size1);
	}

	public void ClickonAddToCart() {
		ak.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddtocart() {
		return ak.isDisplayed(getDriver(),addtocartmessage);
	}
	
	public OrderPage clickOnCheckOut() {
		ak.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
}
