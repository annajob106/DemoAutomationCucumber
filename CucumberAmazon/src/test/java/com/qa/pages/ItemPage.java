package com.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ItemPage {
	protected  WebDriver driver;
	private final By drpMenuSelector = By.xpath("//select[@id='searchDropdownBox']");
	private final By searchTxtSelector = By.xpath("//input[@id='twotabsearchtextbox']");
	private final By ratingStarSelector = By.xpath("//*[@class='a-icon a-icon-star-medium a-star-medium-4']");
	private final By discountOfferSelector = By.xpath("//*[contains(text(),'10% Off or more')]");
	private final By searchOutputSelector = By.xpath("//div[@class='sg-col-inner'][1]");
	private final By discountRateSelector = By.xpath("//span[@class='a-price a-text-price']");
	private final By productDeatilListSelector = By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']");
	private final By nextBtnSelector = By.xpath("//li[@class='a-normal'][1]");



	public ItemPage(WebDriver driver) {
		this.driver = driver;
	}
	//method for search
	public  void searchItem() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Select drpMenu = new Select(driver.findElement( drpMenuSelector));
		drpMenu.selectByVisibleText("Electronics");
		WebElement searchTxtBox = driver.findElement(searchTxtSelector);
		searchTxtBox.sendKeys("Dell laptop");
		searchTxtBox.submit();
	}
	//method for filtering items
	public  void filterItem() {
		WebElement ratingStar = driver.findElement(ratingStarSelector);
		ratingStar.click();;
		WebElement discountOffer = driver.findElement(discountOfferSelector);
		discountOffer.click();
	}

	//method for geting product details
	public  void getDetailsProduct() {
		List<WebElement> ProductDetailList = driver.findElements(productDeatilListSelector);
		for(int i=0;i<ProductDetailList.size();i++) {
			String ProductDescription = ProductDetailList.get(i).getText().toString();
			System.out.println("product description- "+ProductDescription);
		}

	}

	//method for count
	public  void getSearchCount() {
		WebElement searchOutput = driver.findElement(searchOutputSelector);
		if(searchOutput.isDisplayed()) {
			String searchOutputValue = searchOutput.getText().toString();
			System.out.println("print search value"+searchOutputValue);
		}

	}

	//method for discount rate
	public void getDiscountRate() {
		List<WebElement> DiscountRateList = driver.findElements(discountRateSelector);
		for(int i=0;i<DiscountRateList.size();i++) {
			String DiscountRate = DiscountRateList.get(i).getText().toString();
			System.out.println("discontRate"+DiscountRate);
		}
	}
	//method for navigate to secondpage
	public  void clickNextPage() {
		WebElement nextBtn= driver.findElement(nextBtnSelector);
		nextBtn.click();

	}
}
