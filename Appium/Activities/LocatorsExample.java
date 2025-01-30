package examples;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.Assert;

public class LocatorsExample {
	
	//Declare Appium Driver
	AppiumDriver driver;
	
	//Setup function
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException
	{
		 // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.calculator2");
        options.setAppActivity(".Calculator");
        options.noReset();
 
        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();
 
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
	}
	
	//Test
	@Test
	public void addTest()
	{
		//find digit 5 and tap it
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		
		//find + symbol and tap it
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		//find digit 9 and tap it
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
		//find equals symbol and tap it
		driver.findElement(AppiumBy.accessibilityId("equals")).click();
				
		
		//Assertions
		String result = driver.findElement(AppiumBy.id("com.android.calculator2:id/result")).getText();
		assertEquals(result, "14");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
