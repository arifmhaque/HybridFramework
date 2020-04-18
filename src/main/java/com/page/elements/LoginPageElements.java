package com.page.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.main.frame.MainFrame;

public class LoginPageElements extends MainFrame {

	public LoginPageElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email")
	public WebElement userName;
	
	@FindBy(id = "pass")
	public WebElement pass;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	public WebElement loginBtn;

}
