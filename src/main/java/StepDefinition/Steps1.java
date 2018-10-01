package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lpl.base.TestBase;
import lpl.pages.ActivityPage;
import lpl.pages.HomePage;
import lpl.pages.LoginPage;
import lpl.util.TestUtil;

public class Steps1  extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	ActivityPage activityPage= null;
	
	public Steps1() {
		super();
	}

	@Before
	public void StartUp() {
		System.out.println("---------------31------------------");
		System.out.println("----This will run before scenario--");
	}
	
	@After
	public void TearDoen() {
		System.out.println("---------------38------------------");
		System.out.println("----This will run after scenario--");
		driver.quit();
	}
	@Before("@Firstuuu")
	public void StartUp1() {
		System.out.println("---------------45------------------");
		System.out.println("----This will run before First scenario--");
	}
	
	@After("@Firstuuu")
	public void TearDoen1() {
		System.out.println("---------------51------------------");
		System.out.println("----This will run after First scenario--");
		driver.quit();
	}
	
	@Given("^Home Page is loaded and verified$")
	public void home_Page_is_loaded_and_verified() throws Throwable {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String ActualTitle = homePage.verifyHomePageTitle();
		System.out.println(ActualTitle);
		//Assert.assertEquals("[]Client Management", ActualTitle);
		System.out.println("^Home Page is loaded and verified");
	}

	@When("^I click on activty link$")
	public void i_click_on_activty_link() throws Throwable {
	    homePage.clickOnActivityLink();
	    activityPage= new ActivityPage();
	}

	@Then("^Activity Page is displayed and Default date filter verified$")
	public void activity_Page_is_displayed_and_Default_date_filter_verified() throws Throwable {
		waitt(3);
		 takefoto();
		
		Assert.assertTrue("Activities Lable is not dysplayed", activityPage.verifydateFilter());
		System.out.println("Activity Page is loaded and verified");
		
	    //throw new PendingException();
	}
	public void takefoto() throws IOException {
	 File scrFile = ((TakesScreenshot) driver)
             .getScreenshotAs(OutputType.FILE);
     //FileUtils.copyFile(scrFile, new File("pathTOSaveFile")); 001
     
	 //String currentDir = System.getProperty("user.dir"); // 002
		
	//	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".jpg")); //002
		
		String ResultsFolderPath =TestUtil.createresultsfolder() ; //003
		
		System.out.println(ResultsFolderPath);
		FileUtils.copyFile(scrFile, new File(ResultsFolderPath + "\\screenshots\\"+ TestUtil.CurrentDateAndTime+".jpg")); //003
		
	}
}
