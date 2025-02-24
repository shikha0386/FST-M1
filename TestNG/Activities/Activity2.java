package sessiontestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 
{
	WebDriver driver;
	
	// Setup function
    @BeforeClass
    public void setUp() 
    {
        // Initialize Firefox driver
        driver = new FirefoxDriver();
        // Open the page
        driver.get("https://training-support.net/webelements/target-practice/");
    }
    
    // Teardown function - close the browser once the test is done.
    @AfterClass
    public void tearDown() 
    {
        // Close the browser
        driver.quit();
    }
    
    // Test function
    @Test(priority = 1)
    public void test1() 
    {
    	System.out.println("Page title is - " + driver.getTitle());
        // Assert page title
        Assert.assertEquals(driver.getTitle(), "Selenium: Target Practice");
    }
    
 // Test function
    @Test(priority = 2)
    public void test2() 
    {
    	WebElement blackButton = driver.findElement(By.name("Black"));
    	System.out.println("blackButton title is - " + blackButton.getText());
    	
    	Assert.assertTrue(blackButton.isDisplayed());
        //Assert.assertEquals(blackButton.getText(), "black");
    }
    
 // Test function
    @Test(priority = 3, enabled = false)
    public void test3() 
    {
    	// This test will be skipped and not counted
    	System.out.println("This test will be skipped");
    	
        String subHeading = driver.findElement(By.className("sub")).getText();
        Assert.assertTrue(subHeading.contains("Practice"));
    }
    
 // Test function
    @Test(priority = 4)
    public void test4() 
    {
    	System.out.println("This test will be skipped with exception");
    	 // This test will be skipped and will be be shown as skipped
        throw new SkipException("Skipping test case");
    }
	

}
