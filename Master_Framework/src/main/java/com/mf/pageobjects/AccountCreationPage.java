package com.mf.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class AccountCreationPage extends BaseClass{
	public Action ah=new Action();
	

	public AccountCreationPage() {
		PageFactory.initElements(getDriver(),this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Create an account')]")
	private WebElement formTitle;
	
	
	public boolean validateformTitle() {
		return ah.isDisplayed(getDriver(), formTitle);
	}

	
	
}
