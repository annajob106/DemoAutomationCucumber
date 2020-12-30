package com.qa.util;

//import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.qa.pages.HomePage;


public class BasePage {
	public WebDriver driver;
	//public static Properties prop;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
	}
	//method for fetching home page
	public HomePage navigateToHomePage() {
		driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		return new HomePage(driver);
	}
	

}
