package sessiontestng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 
{
	WebDriver driver;

	@BeforeClass(alwaysRun = true)
    public void beforeClass() 
    {
        driver = new FirefoxDriver();

        // Open browser
        driver.get("https://training-support.net/webelements/target-practice");
    }
    
	@AfterClass(alwaysRun = true)
    public void afterClass() 
    {
        // Close browser
        driver.close();
    }
    
    @Test(groups = { "HeaderTests", "ButtonTests" })
    public void pageTitleTest() {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Selenium: Target Practice");
    }
    
    //Find the third header and assert the text in the h3 tag.
    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "HeaderTests" })
    public void HeaderTests1() 
    {
    	WebElement header3 = driver.findElement(By.xpath("//h3[contains(@class, 'orange')]"));
    	System.out.println("name of Heading #3 - " + header3.getText());
        Assert.assertEquals(header3.getText(), "Heading #3");
        
    }
    
    //Find and assert the colour of the fifth header tag element.
    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "HeaderTests" })
    public void HeaderTests2() 
    {
    	String color = driver.findElement(By.xpath("/html/body/div/main/div/div/div/div/div[2]/h5")).getCssValue("color");
    	System.out.println("color of Heading #5 - " + color);
        Assert.assertEquals(color, "rgb(147, 51, 234)");
        
    }

    //Find the button with the class emerald and assert it text.
    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
    public void ButtonTests1() 
    {
    	WebElement emerald = driver.findElement(By.xpath("//button[contains(@class, 'emerald')]"));
    	System.out.println("name of button - " + emerald.getText());
        Assert.assertEquals(emerald.getText(), "Emerald");
    }
    
    //Find and assert the colour of the first button in the third row.
    @Test(dependsOnMethods = { "pageTitleTest" }, groups = { "ButtonTests" })
    public void ButtonTests2() 
    {
    	Color button2Color = Color.fromString(driver.findElement(By.xpath("//button[contains(@class, 'teal')]")).getCssValue("color"));
    	System.out.println("color of button - " + button2Color);
    	Assert.assertEquals(button2Color.asHex(), "#134e4a");
    }
}
