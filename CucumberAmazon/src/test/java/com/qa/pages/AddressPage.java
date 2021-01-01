package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {
	
	protected WebDriver driver;
	private final By userSelector = By.xpath("//span[@class='nav-line-2 nav-long-width']");
	private final By accountSelector = By.xpath("//*[@id=\"nav-al-your-account\"]/a[1]");
	private final By addressPlusIconSelector = By.xpath("//div[@id='ya-myab-plus-address-icon']");
	private final By fullNameSelector = By.xpath("//input[@id='address-ui-widgets-enterAddressFullName']");
	private final By phoneNumberSelector = By.xpath("//input[@id='address-ui-widgets-enterAddressPhoneNumber']");
	private final By postalCodeSelector = By.xpath("//input[@id='address-ui-widgets-enterAddressPostalCode']");
	private final By addressLineOneSelector = By.xpath("//input[@id='address-ui-widgets-enterAddressLine1']");
	private final By addresLineTwoSelector = By.xpath("//input[@id='address-ui-widgets-enterAddressLine2']");
	private final By landmarkSelector = By.xpath("//input[@id='address-ui-widgets-landmark']");
	private final By citySelector = By.xpath("//input[@id='address-ui-widgets-enterAddressCity']");
	private final By stateDropdownSelector = By.xpath("//select[@id='address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId']");
	private final By timeDropdownSelector = By.xpath("//select[@name='address-ui-widgets-addr-details-address-type-and-business-hours']");
	private final By submitBtnSelector = By.xpath("//input[@aria-labelledby='address-ui-widgets-form-submit-button-announce']");
	
	public AddressPage(WebDriver driver) {
		this.driver = driver;
	}
	//method for navigating to address page
	public void navigateToAddresPage() {
		Actions action = new Actions(driver);
		WebElement user = driver.findElement(userSelector);
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated( accountSelector));
		WebElement account = driver.findElement(accountSelector);
		if(user.isDisplayed()) {
			action.moveToElement(user).moveToElement(account).click().build().perform();
		}
	}
	//method for  clicking add address button
	public void clikAddAddressButton() {
		WebElement addressPlusIcon = driver.findElement(addressPlusIconSelector);
		 addressPlusIcon.click();
	}
	
	//method for adding address
	public void addAddress() {
		WebElement name = driver.findElement(fullNameSelector);
		name.sendKeys("Job");
		WebElement phoneNumber = driver.findElement(phoneNumberSelector);
		phoneNumber.sendKeys("9446144187");
		WebElement postalcode = driver.findElement(postalCodeSelector);
		postalcode.sendKeys("680721");
		
	}
	
    //method for clickng submit button
	public void clickSubmit() {
		
	}
}
