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

public class Activity5 
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
 
    @Test(priority=1)
	public void loginPageValidCredientials() throws InterruptedException 
    {
    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.webkit.WebView")));
		
    	// Locate heading on page and print it
    	String pageTitle = driver.findElement(AppiumBy.className("android.webkit.WebView")).getText();
    	System.out.println("Page Heading: " + pageTitle);

    	//Scroll to find the Login Form card and click it.
    	// UiScrollable object string
     	String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
     	
    	// Scroll to required element
     	driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollForward(15)"));
     	driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Login Form  Please sign in. \"]")).click();
     	  
     	System.out.println("Clicked on Login Form card");
     	
     	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
		
		      
     	// Find heading of new page and print to console
        String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Login Form\"]")).getText();
        System.out.println("New Page Heading: " + pageHeading);
        
    	//Once the page loads, find the username and password input fields on the page and enter the following credentials in it:
    	//Username: admin     	Password: password
    	
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).clear();
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin");
    	
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).clear();
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
    	
    	//Click on the Log in button to submit.
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
    	
    	Thread.sleep(2000);
    	
    	String msg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();
    	
    	Assert.assertEquals(msg, "Welcome Back, admin");
    }
 
    @Test(priority=2)
	public void loginPageInValidCredientials() throws InterruptedException 
    {
    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")));
		
		      
     	// Find heading of new page and print to console
        String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Login Form\"]")).getText();
        System.out.println("New Page Heading: " + pageHeading);
        
    	//Once the page loads, find the username and password input fields on the page and enter the following credentials in it:
    	//valid - Username: admin     	Password: password
    	
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).clear();
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")).sendKeys("admin1");
    	
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).clear();
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")).sendKeys("password");
    	
    	//Click on the Log in button to submit.
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
    	
    	Thread.sleep(2000);
    	
    	String msg = driver.findElement(AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]")).getText();
    	
    	Assert.assertEquals(msg, "Invalid Credentials");
    }
    
    // Tear down method
    @AfterClass
    public void tearDown() 
    {
        // Close the app
        driver.quit();
    }
}
