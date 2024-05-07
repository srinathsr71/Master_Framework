package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class OrderConfirmationPage extends BaseClass {
	public Action ko=new Action();
	public OrderConfirmationPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	private WebElement confirmmessage;
	
	public String validateconfirmmessage() {
		String confirmmsg=confirmmessage.getText();
		return confirmmsg;
	}

}
