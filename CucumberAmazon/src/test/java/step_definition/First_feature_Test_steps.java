package step_definition;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dataProvider.ConfigFileReader;

public class First_feature_Test_steps  {
	WebDriver driver;
	Logger log;
	HomePage homePage;
	LoginPage loginPage;
	ConfigFileReader configFileReader;

	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
		log = LogManager.getLogger(First_feature_Test_steps.class);
		String log4jConfPath =configFileReader.getlog4jConfigPath();
		PropertyConfigurator.configure(log4jConfPath);
	    log.info("This is to inform you that,browser launches succesfully");
		homePage = new HomePage(driver);
		homePage.navigateToHomePage();

	}

	@When("^user navigate to login page$")
	public void user_navigate_to_login_page() throws Throwable {
		homePage.navigateToLoginPage();

	}

	@Then("^user login as \"([^\"]*)\"and \"([^\"]*)\"$")
	public void user_login_as_and(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		loginPage = new LoginPage(driver);
		loginPage.Login(arg1, arg2);
	}


	@Before
	public void startUp() {
		configFileReader = new ConfigFileReader();
		System.setProperty(configFileReader.getDriver(),configFileReader.getDriverPath());
		driver = new ChromeDriver();

	}
		@After
		public void tearDown() {
			driver.quit();
		}

	}
