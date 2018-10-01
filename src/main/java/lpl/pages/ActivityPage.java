package lpl.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lpl.base.TestBase;

public class ActivityPage extends TestBase{
	//OR
	@FindBy(xpath = "//span[contains(text(),'Activities')]")
	WebElement activitiesLable;
	
	@FindBy(xpath = ".//*[@id='date-filter']/div/button")
	WebElement dateFilter;

	//Initializing the Page Objects:
	public ActivityPage() {
		PageFactory.initElements(driver, this);
	}


	//Actions:
	public String verifyActivityPageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifydateFilter(){
		return dateFilter.isDisplayed();
	}
	
	public boolean verifyActivitiesLable(){
		return activitiesLable.isDisplayed();
	}
}
