# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

# Start the Driver
with webdriver.Firefox() as driver:

    # Define the wait
    wait = WebDriverWait(driver, timeout=10)

    # Navigate to the URL
    driver.get("https://training-support.net/webelements/alerts")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the button to open a SIMPLE alert and click it.
    driver.find_element(By.ID, "simple").click()
		 
    # Wait for the alert to be displayed and store it in a variable
    alert = wait.until(EC.alert_is_present())
        
    # Store the alert text in a variable
    alertText = alert.text

    print("Text on Alert" , alertText)
        
    # Press the OK button
    alert.accept()

    # Print the message
    print(driver.find_element(By.ID, "result").text)

        
    #close the browser
    driver.quit()