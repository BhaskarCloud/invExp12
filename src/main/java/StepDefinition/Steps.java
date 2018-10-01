package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lpl.pages.ActivityPage;
import lpl.pages.HomePage;
import lpl.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lpl.base.TestBase;

public class Steps extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	private static WebDriver driver = null;

	public Steps() {
		super();
	}

	@Given("^Open the Firefox and launch the application$")
	public void open_the_Firefox_and_launch_the_application() throws Throwable {
		initialization();
		loginPage = new LoginPage();

	}

	@When("^Enter the Username and Password$")
	public void enter_the_Username_and_Password() throws Throwable {

		System.out.println("This step enter the Username and Password on the login page.");
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^Home Page is loaded$")
	public void Home_Page_is_loaded() throws Throwable {
		System.out.println("This step verify home lable.");
		waitt(5);
		Assert.assertTrue("Home link is not available", homePage.verifyHomeLink());
		System.out.println("Home lable assertion is true.");
	}
//ActivityPage activityPage;
	/*
	@Given("^Home Page is loaded and verified$")
	public void home_Page_is_loaded_and_verified() throws Throwable {
		String ActualTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals("Client Management", ActualTitle);
		System.out.println("^Home Page is loaded and verified");
	}

	@When("^I click on activty link$")
	public void i_click_on_activty_link() throws Throwable {
	    homePage.clickOnActivityLink();
	}

	@Then("^Activity Page is displayed$")
	public void activity_Page_is_displayed() throws Throwable {
		Assert.assertTrue("Activities Lable is not dysplayed", activityPage.verifyActivitiesLable());
		System.out.println("Activity Page is loaded and verified");
		
	    //throw new PendingException();
	}*/
}