# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait

# Start the Driver
with webdriver.Firefox() as driver:

    # Define the wait
    wait = WebDriverWait(driver, 10)

    # Navigate to the URL
    driver.get("https://training-support.net/webelements/dynamic-controls")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the football
    checkbox = driver.find_element(By.ID, "checkbox")
    # Find the dropzone1
    toogle_checkbox = driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/div[2]/section[1]/button")
    
    print("checkbox is visible " , checkbox.is_displayed())

    toogle_checkbox.click()

    # Wait for a condition
    wait.until(EC.invisibility_of_element(checkbox))

    print("checkbox is visible " , checkbox.is_displayed())

    toogle_checkbox.click()

    # Wait for a condition
    wait.until(EC.element_to_be_clickable(checkbox))

    print("checkbox is visible " , checkbox.is_displayed())

    checkbox.click()

    print("checkbox is selected " , checkbox.is_selected())

    #close the browser
    driver.quit()