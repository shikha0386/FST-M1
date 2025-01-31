package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	
	// Driver Declaration
	AndroidDriver driver;
	WebDriverWait wait;
	
	 // Set up method
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException
	{
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		
		// Open the page in Chrome
        driver.get("https://training-support.net");
		
	}
	
	@Test
    public void chromeTest() 
    {
		// Find heading on the page
		String pageHeading =driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Training Support\"]")).getText();
		
		// Print to console
        System.out.println("Heading: " + pageHeading);
        
     // Find and click the About Us link
       driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]")).click();
        
       wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]"))));
        
     // Find heading of new page and print to console
        String aboutPageheading = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"About Us\"]")).getText();
        
        System.out.println("About us Heading "+aboutPageheading);
        
    }
	
	// Tear down method
	@AfterClass
	public void tearDown()
	{
		//close the app
		driver.quit();
	}
}
