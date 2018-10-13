package lpl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lpl.base.TestBase;

public class DashboardPage extends TestBase {

	@FindBy(xpath = "//div[contains(text(),' Account')]")
	@CacheLookup
	WebElement accountViewLabel;

	@FindBy(id = "dropdownMenuLink")
	private WebElement usernameLabel;	
	
	@FindBy(xpath = "//nav[2]/div/a[1]/i")
	WebElement dashboardLinkInSideBar;	
	
	@FindBy(xpath = "//nav[2]/div/a[2]/i")
	WebElement accounsLinkInSideBar;
	
	@FindBy(xpath = "//nav[2]/div/a[3]/i")
	WebElement positionsLinkInSideBar;
	
	@FindBy(xpath = "//nav[2]/div/a[4]/i")
	WebElement goalsLinkInSideBar;
	
	@FindBy(xpath = "//nav[2]/div/a[5]/i")
	WebElement documentsLinkInSideBar;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	@FindBy(xpath = "//a[contains(text(),'Activity')]")
	WebElement activitysLink;

	@FindBy(xpath = "//a[contains(text(),'Home') and @class = 'ng-scope' ]") 
	WebElement homeLink;
	// Initializing the Page Objects:
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	
	
	public boolean verifyAccountViewLabel(){
		return accountViewLabel.isDisplayed();
	}
	
	public boolean verifydashboardLinkInSideBar(){
		return dashboardLinkInSideBar.isDisplayed();
	}
	public boolean verifyaccounsLinkInSideBar(){
		return accounsLinkInSideBar.isDisplayed();
	}
	public boolean verifypositionsLinkInSideBar(){
		return positionsLinkInSideBar.isDisplayed();
	}
	public boolean verifygoalsLinkInSideBar(){
		return goalsLinkInSideBar.isDisplayed();
	}
	public boolean verifydocumentsLinkInSideBar(){
		return documentsLinkInSideBar.isDisplayed();
	}
	
	
	public ContactsPage clickOnContactsLink(){
		//contactsLink.click();
		return new ContactsPage();
	}
	public void clickOnActivityLink(){
		activitysLink.click();
		
	}

	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
	//	action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	public boolean verifyusernameLabelLink(){
		return usernameLabel.isDisplayed();
	}
	
	
	
	
	
	
	

}
