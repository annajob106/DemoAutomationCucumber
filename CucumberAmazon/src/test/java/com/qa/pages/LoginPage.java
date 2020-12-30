package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {
	protected  WebDriver driver;
     private final By phoneNoSelector = By.xpath("//input[@id='ap_email']");
     private final By continueBtnSelector = By.xpath("//input[@id='continue']");
     private final By passwordSelector  = By.xpath("//*[@id=\"ap_password\"]");
     private final By loginBtnSelector = By.xpath("//span[@id='auth-signin-button-announce']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//method for login
	public void Login(String username,String password) {
		WebElement phoneNo = driver.findElement(phoneNoSelector);
		WebElement continueBtn = driver.findElement(continueBtnSelector);
		
		
		try {
			if(phoneNo.isDisplayed()) {
				phoneNo.sendKeys(username);
				if(continueBtn.isDisplayed()) {
					continueBtn.click();
					WebElement passwordTxt = driver.findElement(passwordSelector);
					WebElement loginBtn = driver.findElement(loginBtnSelector);
					if(passwordTxt.isDisplayed()) {
						passwordTxt.sendKeys(password);
						if(loginBtn.isDisplayed()) {
							Actions act = new Actions(driver);
							act.moveToElement( loginBtn).click().perform();
						}
					}
					
					
				}
				
			}
			
			
			}
		catch (Exception e) {
			System.out.println("print exception"+e);
		}
		
		
	}
}
