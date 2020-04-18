package com.main.frame;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainFrame {
 
	public WebDriver driver = null;
	
	public MainFrame(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void clickMethod(WebElement element) {
		element.click();
	}
	
	
}
