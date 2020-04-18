package com.page.actions;

import org.openqa.selenium.WebDriver;

import com.page.elements.LoginPageElements;

public class LoginPageActions extends LoginPageElements {

	public LoginPageActions(WebDriver driver) {
		super(driver);
	}
	
	public void setUser(String email) {
		userName.sendKeys(email);
	}
	public void setPass(String password) {
		pass.sendKeys(password);
	}
	
	public void clickSubmit() {
		clickMethod(loginBtn);
		
	}

}
