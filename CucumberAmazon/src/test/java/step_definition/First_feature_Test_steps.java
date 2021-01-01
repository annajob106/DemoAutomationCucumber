package step_definition;


import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.HomePage;
import com.qa.pages.ItemPage;
import com.qa.pages.LoginPage;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

public class First_feature_Test_steps  {
	static WebDriver driver;
	Logger log;
	HomePage homePage;
	LoginPage loginPage;
	ConfigFileReader configFileReader;
	ItemPage itemPage;

	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		configFileReader = new ConfigFileReader();
		System.setProperty(configFileReader.getDriver(),configFileReader.getDriverPath());
		driver = new ChromeDriver();
		log = LogManager.getLogger(First_feature_Test_steps.class);
		String log4jConfPath =configFileReader.getlog4jConfigPath();
		BasicConfigurator.configure();
		PropertyConfigurator.configure(log4jConfPath);
		log.info("This is to inform you that,user enters home page");
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();

	}

	@When("^user navigate to login page$")
	public void user_navigate_to_login_page() throws Throwable {
		homePage.navigateToLoginPage();
		log.info("This is to inform you that,user enters login page");

	}

	@Then("^user login as \"([^\"]*)\"and \"([^\"]*)\"$")
	public void user_login_as_and(String arg1, String arg2) throws Throwable {
		
		loginPage = new LoginPage(driver);
		loginPage.Login(arg1, arg2);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		log.info("This is to inform you that,user complete login succesfully");
	}


	@Given("^user selects electronics and search dell laptop$")
	public void user_selects_electronics_and_search_dell_laptop() throws Throwable {
		itemPage = new ItemPage(driver);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		itemPage.searchItem();
		//  log.info("This is to inform you that,user search item");

	}

	@When("^user apply filter to search result$")
	public void user_apply_filter_to_search_result() throws Throwable {
		itemPage.filterItem();

	}

	@Then("^user find product details$")
	public void user_find_product_details() throws Throwable {
		itemPage.getDetailsProduct();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Then("^user find product count$")
	public void user_find_product_count() throws Throwable {
		itemPage.getSearchCount();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Then("^user find discounted rate$")
	public void user_find_discounted_rate() throws Throwable {
		itemPage.getDiscountRate();

	}

	@When("^user navigates to second page$")
	public void user_navigates_to_second_page() throws Throwable {
		itemPage.clickNextPage();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@When("^user find product details of second page$")
	public void user_find_product_details_of_second_page() throws Throwable {
		itemPage.getDetailsProduct();
	}

	@When("^user find discound rates of second page$")
	public void user_find_discound_rates_of_second_page() throws Throwable {
		itemPage.getDiscountRate();
	}
	
	@Given("^user navigates to addres page$")
	public void user_navigates_to_addres_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Then("^user press add addres icon$")
	public void user_press_add_addres_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^user adding addres details$")
	public void user_adding_addres_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  
	}

	@Then("^user submit new addres and verify new addres$")
	public void user_submit_new_addres_and_verify_new_addres() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}


	@Given("^user signout from application$")
	public void user_signout_from_application() throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.clickSignout();

	}
	@Then("^user quit browser$")
	public void user_quit_browser() throws Throwable {
		driver.quit();
	}






}
