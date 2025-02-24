package project;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity3 
{
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
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    // Tear down method
    @AfterClass
    public void tearDown() 
    {
        // Close the app
        driver.quit();
    }
    
    // Test method
    @Test
    public void googleKeepAddNote() throws InterruptedException  
    {
    	// Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create a note\"]")));
        
        //Open the Google Keep app.
    	
    	//click on Add new note
    	driver.findElement(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create a note\"]")).click();
    	
    	//Click the text
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"New text note\"]")).click();
    	
    	
    	//Add a title for the note and add a small description.
    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/edit_note_text\"]")));
        
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/edit_note_text\"]"))
    	.sendKeys("My Task 1 description with reminder");
    	
    	driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/editable_title\"]"))
    	.sendKeys("My Task 1 with reminder");
    	
    	//Click the reminder icon on the tool-bar to add a reminder for Afternoon of the same day.
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Reminder\"]")).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Pick a date & time\"]")));
    	
    	//Add reminder - click on pick date and time
    	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Pick a date & time\"]")).click();
    	
    	// Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Spinner[@content-desc=\"Date - Currently selected - February 7\"]")));
        
    	//select today for date
    	driver.findElement(AppiumBy.xpath("//android.widget.Spinner[@content-desc=\"Date - Currently selected - February 7\"]")).click();
    	
    	// Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/text\" and @text=\"Today\"]")));
        
        //select today
    	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/text\" and @text=\"Today\"]")).click();
    	
    	// Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.google.android.keep:id/time_spinner\"]")));
        
    	//select time
    	driver.findElement(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.google.android.keep:id/time_spinner\"]")).click();
    	
    	// Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/text\" and @text=\"Afternoon\"]")));
        
        //select afternoon
    	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/text\" and @text=\"Afternoon\"]")).click();
    	
    	// Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.keep:id/save\"]")));
        
    	//click on save
    	driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.google.android.keep:id/save\"]")).click();
    	
    	
    	//Press the back button 
    	driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();
    	
    	
    	//Make an assertion to ensure that the note was added with a reminder
    	
    	// Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create a note\"]")));
        
    	//Get number of tasks
        List<WebElement> list = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.StaggeredGridLayoutManager[@resource-id=\"com.google.android.keep:id/notes\"]/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"));
        System.out.println("number of tasks: " + list.size());
        
        
        //Click on each of the tasks added to strike them out.
        for(WebElement element : list)
        {
        	System.out.println("Name of tasks: " + element.getText());
        }
        
        
      //Get number of remindar
        List<WebElement> listR = driver.findElements(AppiumBy.xpath("//android.support.v7.widget.StaggeredGridLayoutManager[@resource-id=\"com.google.android.keep:id/notes\"]/androidx.cardview.widget.CardView/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"));
        System.out.println("number of reminder: " + listR.size());
        
        
        //Click on each of the tasks added to strike them out.
        for(WebElement element : listR)
        {
        	System.out.println("Time of reminder: " + element.getText());
        }
        
        Assert.assertEquals(list.size(), 1);        
           
    }
}
