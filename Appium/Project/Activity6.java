package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 
{
	AppiumDriver driver;
	WebDriverWait wait;
	
	//setup function
	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException 
	{
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();
 
		// Server URL
		URL serverURL = new URI("http://localhost:4723").toURL();
 
		// Driver initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
 
		// Open Selenium page
		driver.get("https://v1.training-support.net/selenium");
    }
	
	 // Tear down method
    @AfterClass
    public void tearDown() 
    {
        // Close the app
        driver.quit();
    }
    
    @Test(priority=1)
	public void popupsCard() throws InterruptedException 
    {
    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.webkit.WebView")));
		
    	// Locate heading on page and print it
    	String pageTitle = driver.findElement(AppiumBy.className("android.webkit.WebView")).getText();
    	System.out.println("Page Heading: " + pageTitle);

    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]")).click();
    	
    	wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.webkit.WebView[@text=\"Training Support - Selenium\"]/android.view.View[2]/android.view.View[3]")));
		
    	//Scroll to find the Popups card and click it.
    	
        // UiScrollable object string
     	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
     	
     	// Scroll to End
     	driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollToEnd(2)"));
     	
     	// Locate element
     	driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text, \"Popups\")]")).click();
     	System.out.println("Clicked on Popups card");
     	
     	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In \"]")));
		
     	// Find heading of new page and print to console
        String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Popups\"]")).getText();
        System.out.println("New Page Heading: " + pageHeading);
        
    }

    
    @Test(priority=2)
	public void popupsCardValidCredientials() throws InterruptedException 
    {   
        //Once the page loads, find the Sign In button on the page to open a popup with the login form.
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In \"]")).click();
     	
    	//Find the username and password input fields in the popup and enter the following credentials in it:
    	//Username: admin    	Password: password
        
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
		
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).clear();
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
    	
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).clear();
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
    	
    	  	
    	//Click on the Log in button to submit.
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
    	
    	Thread.sleep(2000);
    	
    	//If the credentials are correct, the following message should appear:
    	String msg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();
    	
    	Assert.assertEquals(msg, "Welcome Back, admin");
    }

    @Test(priority=3)
	public void popupsCardInValidCredientials() throws InterruptedException 
    {
    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In \"]")));
		
    	//Once the page loads, find the Sign In button on the page to open a popup with the login form.
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Sign In \"]")).click();
     	
    	//Find the username and password input fields in the popup and enter the following credentials in it:
    	//Username: admin1    	Password: password
        
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
		
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).clear();
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin1");
    	
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).clear();
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
    	
    	  	
    	//Click on the Log in button to submit.
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
    	
    	Thread.sleep(2000);
    	
    	//If the credentials are correct, the following message should appear:
    	String msg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();
    	
    	Assert.assertEquals(msg, "Invalid Credentials");
    }

}
