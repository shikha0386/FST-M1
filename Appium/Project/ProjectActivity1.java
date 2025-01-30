package liveProject;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectActivity1 {
	
	//Declare Appium Driver
		AppiumDriver driver;
		WebDriverWait wait;
		
		//Setup function
		@BeforeClass
		public void setUp() throws MalformedURLException, URISyntaxException
		{
			 // Desired Capabilities
	        UiAutomator2Options options = new UiAutomator2Options();
	        options.setPlatformName("android");
	        options.setAutomationName("UiAutomator2");
	        options.setAppPackage("com.google.android.apps.tasks");
	        options.setAppActivity(".ui.TaskListsActivity");
	        options.noReset();
	 
	        // Server Address
	        URL serverURL = new URI("http://localhost:4723").toURL();
	 
	        // Driver Initialization
	        driver = new AndroidDriver(serverURL, options);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		}
		
		//Test
		@Test
		public void addTest()
		{
			//for 1st task
			//find add button and click it
			driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
			// Wait for add task to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
			//com.google.android.apps.tasks:id/add_task_title
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
			
			//save buton
			//com.google.android.apps.tasks:id/add_task_done
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
			
		    //for 2nd task
			//find add button and click it
			driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
			// Wait for add task to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
			//com.google.android.apps.tasks:id/add_task_title
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
			
			//save buton
			//com.google.android.apps.tasks:id/add_task_done
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
			
			//for 3rd task
			//find add button and click it
			driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
			// Wait for add task to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
			//com.google.android.apps.tasks:id/add_task_title
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
			
			//save buton
			//com.google.android.apps.tasks:id/add_task_done
			driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();
			
			//To check the number of task
			//new UiSelector().resourceId("com.google.android.apps.tasks:id/task_data").instance(0)
			//new UiSelector().resourceId("com.google.android.apps.tasks:id/task_data").instance(1)
			
			//xpath
			//android.widget.TextView[@resource-id="com.google.android.apps.tasks:id/task_name" and @text="hello"]
			//android.widget.TextView[@resource-id="com.google.android.apps.tasks:id/task_name" and @text="hi"]
			
			//wait
			//int size = driver.findElements(AppiumBy.xpath("android.widget.TextView[@resource-id=\"com.google.android.apps.tasks:id")).size();
			
			//wait
		//	wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("android.widget.TextView[@resource-id=\"com.google.android.apps.tasks")));
			wait.until(ExpectedConditions.numberOfElementsToBe(AppiumBy.id("com.google.android.apps.tasks:id/task_name"), 3));
			// Find all text elements on the page
			
			 List<WebElement> listItems = driver.findElements(AppiumBy.id("com.google.android.apps.tasks:id/task_name"));
			
		//	with uiautomator
	      //  List<WebElement> listItems = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().text(\"Complete Activity with Google Tasks\")"));
	        ArrayList <String> arlist = new ArrayList<String>();
	        arlist.add("Complete the second Activity Google Keep");
	        arlist.add("Complete Activity with Google Keep");
	        arlist.add("Complete Activity with Google Tasks");
	        
	        int size = listItems.size();
	        System.out.println(listItems.size());
	        Boolean flag = false;
	        for (WebElement textItem : listItems) {
	           // System.out.println(textItem.getText());
	            if(arlist.contains(textItem.getText()))
	            {
	            	System.out.println(textItem.getText() +" found");
	            	flag =true;
	            }
	            else
	            	flag = false;
	        }
	        Boolean finalFlag;
	        if(size == 3 && flag == true)
	        	finalFlag= true;
	        else finalFlag = false ;
	        	
	        assertEquals(finalFlag, true);
		}
		
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}

}
