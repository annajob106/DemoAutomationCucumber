package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	protected  WebDriver driver;
	private final By phoneNoSelector = By.xpath("//input[@id='ap_email']");
	private final By continueBtnSelector = By.xpath("//input[@id='continue']");
	private final By passwordSelector  = By.xpath("//*[@id=\"ap_password\"]");
	private final By loginBtnSelector = By.xpath("//span[@id='auth-signin-button-announce']");
	private final By userBtnSelector = By.xpath("//span[@class='nav-line-2 nav-long-width']");
	private final By signOutBtnSelector = By.xpath("//a[@id='nav-item-signout']");


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
	//method for logout
	public  void clickSignout() {
		Actions action = new Actions(driver);
		WebElement user = driver.findElement(userBtnSelector);
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated( signOutBtnSelector));
		WebElement signOut = driver.findElement(signOutBtnSelector);
		if(user.isDisplayed()) {
			action.moveToElement(user).moveToElement(signOut).click().build().perform();
		}

	}
}
