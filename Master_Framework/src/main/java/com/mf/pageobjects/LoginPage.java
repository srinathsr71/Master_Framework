package com.mf.pageobjects;

import org.apache.poi.ss.formula.functions.Address;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mf.actions.Action;
import com.mf.base.BaseClass;

public class LoginPage extends BaseClass{

	public Action av=new Action();
	
	
@FindBy(id="email")
private WebElement userName;

@FindBy(name="passwd")
private WebElement password;
	
@FindBy(id="SubmitLogin")
private WebElement signInBtn;
	
@FindBy(name="email_create")
private WebElement emailForNewAccount;

@FindBy(name="SubmitCreate")
private WebElement createNewAccountBtn;

public LoginPage() {
	PageFactory.initElements(getDriver(),this);
}
	
public HomePage login(String uname,String pswd) {
	av.type(userName, uname);
	av.type(password, pswd);
	Action.click(getDriver(), signInBtn);
	av.implicitWait(getDriver(), 10);
	return new HomePage();
}

public AddressPage login1(String uname,String pswd) {
	av.type(userName, uname);
	av.type(password, pswd);
	Action.click(getDriver(), signInBtn);
	return new AddressPage();
}


public AccountCreationPage createNewAccount(String newemail) {
	av.type(emailForNewAccount, newemail);
	Action.click(getDriver(), createNewAccountBtn);
	return new AccountCreationPage();
}



}
