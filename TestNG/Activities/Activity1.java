package sessiontestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    
    // Setup function
    @BeforeClass
    public void setUp() {
        // Initialize Firefox driver
        driver = new FirefoxDriver();
        // Open the page
        driver.get("https://training-support.net");
    }
    
    // Teardown function - close the browser once the test is done.
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
    
    // Test function
    @Test(priority = 1)
    public void homePageTest() 
    {
    	System.out.println("Page title is - " + driver.getTitle());
        // Assert page title
        Assert.assertEquals(driver.getTitle(), "Training Support");
        
        // Find and click the About page link
        driver.findElement(By.linkText("About Us")).click();
    }
    
    @Test(priority = 2)
    public void aboutPageTest() {
    	System.out.println("Page title is - " + driver.getTitle());
    	
        // Assert page title
        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }
    

}
