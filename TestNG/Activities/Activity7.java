package sessiontestng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 
{
	WebDriver driver;
	WebDriverWait wait;
	
	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
	    return new Object[][] { 
	        { "testuser_1", "Test@123", "Invalid credentials" }, 
	        { "testuser_2", "Test@456", "Invalid credentials" },
	        { "admin", "password", "Welcome Back, Admin!" }
	    };
	}
	
    @BeforeClass
    public void setUp() 
    {
        driver = new FirefoxDriver();
        
        // Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open browser
        driver.get("https://training-support.net/webelements/login-form");
    }
    
    @AfterClass
    public void tearDown() 
    {
        // Close browser
        driver.close();
    }
    
    @Test(dataProvider = "Authentication")
    public void loginTest(String sUsername, String sPassword, String expectedMessage) 
    {
    	// Find the username and password fields
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));

        // Clear the input fields
        username.clear();
        password.clear();
        
        // Enter credentials
        username.sendKeys(sUsername);
        password.sendKeys(sPassword);

        // Click login
        driver.findElement(By.xpath("//button[text()='Submit']")).click();

        // Read login message
        String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
        
        //System.out.println("login message - " + loginMessage);
        
        if (!loginMessage.matches("Welcome Back, Admin!"))
        {
        	loginMessage = driver.findElement(By.id("subheading")).getText();  
        }
        
        System.out.println("login message - " + loginMessage);
        
        Assert.assertEquals(loginMessage, expectedMessage);
    }


}
