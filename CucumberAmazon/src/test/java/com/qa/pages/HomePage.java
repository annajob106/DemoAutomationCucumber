package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.util.BasePage;

public class HomePage extends BasePage {
	
	private final By signinSelector = By.xpath("//span[@class='nav-line-2 nav-long-width']");
	
 
  public HomePage(WebDriver driver) {
		super(driver);
		}


//method for navigating to login page
public void navigateToLoginPage() {
	WebElement signin = driver.findElement(signinSelector);
	if(signin.isDisplayed()) {
		try {
			signin.click();
		}
		catch(Exception e) {
			System.out.println("Exeption is"+e);
		}
		
		
		
	}
}

	
}



