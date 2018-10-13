package lpl.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.lpl.config.ConfigProperties;
import com.lpl.service.AutomationService;

import lpl.util.TestUtil;
import lpl.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	protected static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	protected TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/lpl"
					+ "/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		
		}
	}
	
	public static void initialization() {
		AutomationService automationService = new AutomationService();
		
		driver = automationService.initialize("Config.properties");
		 
		ConfigProperties prop  = new ConfigProperties("Config.properties");
	
	 	driver.get(prop.getURL());
		//for event firing
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	public static void initializationOld(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
		
			System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			
			System.setProperty("webdriver.firefox.bin", "C:\\Users\\bkhimani\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			System.setProperty("webdriver.gecko.driver", "BrowserServers\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		else if(browserName.equals("headless")){
		
			
			System.setProperty("webdriver.chrome.driver",
	                "BrowserServers\\chromedriver.exe");
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("headless");
	        options.addArguments("window-size=1200x600");
	         driver = new ChromeDriver(options);
		}
		else if(browserName.equals("htmlunit")){
			
	        driver = new HtmlUnitDriver();
	   
		}
		
		//for event firing
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	protected static boolean waitt(long timeInSec) //LINE 597
	{
		boolean stepStatus;
		try
		{
			Thread.sleep(timeInSec*1000);
			stepStatus = true;
		}
		catch (Exception e) 
		{
			stepStatus=false;
		}
		return stepStatus;
	}
	
	
	
	
	

}
