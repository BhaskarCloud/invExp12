package lpl.runner;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lpl.base.TestBase;
import lpl.pages.ActivityPage;
import lpl.pages.HomePage;
import lpl.pages.LoginPage;

public class Psvm extends TestBase {
	public Psvm() {
		super();
	}

public static void main(String[] args) throws IOException {
		LoginPage loginPage;
		HomePage homePage;

		ActivityPage activityPage = null;

		System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		String url = "http://clientworksqa.lpl.com";
		driver.get(url);
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String ActualTitle = homePage.verifyHomePageTitle();
		System.out.println(ActualTitle);
		// Assert.assertEquals("[]Client Management", ActualTitle);
		System.out.println("^Home Page is loaded and verified");

		homePage.clickOnActivityLink();

		waitt(3);
		takefoto();
		System.out.println(activityPage.verifyActivityPageTitle());
		Assert.assertTrue("Activities Lable is not dysplayed", activityPage.verifydateFilter());
		System.out.println("Activity Page is loaded and verified");

	}

	public static void takefoto() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("pathTOSaveFile"));
	}
}
