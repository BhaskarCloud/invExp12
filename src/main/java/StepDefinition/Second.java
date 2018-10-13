package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import lpl.pages.ActivityPage;
import lpl.pages.DashboardPage;
import lpl.pages.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lpl.base.TestBase;

public class Second extends TestBase {
	LoginPage loginPage;
	DashboardPage dashboardPage;

	private static WebDriver driver = null;

	public Second() {
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
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Then("^Home Page is loaded$")
	public void Home_Page_is_loaded() throws Throwable {
		System.out.println("This step verify User name lable.");
		waitt(5);
		Assert.assertTrue("User name label link is not available", dashboardPage.verifyusernameLabelLink());
		System.out.println("verifyusernameLabelLink assertion is true.");
		
		Assert.assertTrue("Dashboard link in Side Bar is not available", dashboardPage.verifydashboardLinkInSideBar());
		System.out.println("verifydashboardLinkInSideBar assertion is true.");
		
		Assert.assertTrue("Account link in Side Bar is not available", dashboardPage.verifyaccounsLinkInSideBar());
		System.out.println("verifyaccounsLinkInSideBar assertion is true.");
		
		Assert.assertTrue("position link in Side Bar is not available", dashboardPage.verifypositionsLinkInSideBar());
		System.out.println("verifypositionsLinkInSideBar assertion is true.");
		
		Assert.assertTrue("goal link in Side Bar is not available", dashboardPage.verifygoalsLinkInSideBar());
		System.out.println("verifygoalsLinkInSideBar assertion is true.");
		
		Assert.assertTrue("documents link in Side Bar is not available", dashboardPage.verifydocumentsLinkInSideBar());
		System.out.println("verifydocumentsLinkInSideBar assertion is true.");
		
	}
}