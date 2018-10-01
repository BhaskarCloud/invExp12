package Selenium.cucumber;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class hdless {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver",
                "BrowserServers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        //options.addArguments("window-size=1200x600");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://clientworksqa.lpl.com");
        
        
    	driver.manage().window().maximize();
       //river.get("https://www.google.co.in/");
        System.out.println("title is: " + driver.getTitle());
        File scrFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("pathTOSaveFile"));
        driver.quit();
			System.out.println("Title of the page is -> " );//itDriver.getTitle());

		}

	}

