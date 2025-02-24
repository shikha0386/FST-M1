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
    driver.get("https://training-support.net/webelements/dynamic-content")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the button
    button = driver.find_element(By.ID, "genButton")
    # Find the word
    wordlist = driver.find_element(By.XPATH, "//*[@id=\"word\"]")
    
    button.click()

    if wait.until(EC.text_to_be_present_in_element((By.XPATH, "//*[@id=\"word\"]"), "release")) :
        print("Word found: " , wordlist.text)

    #close the browser
    driver.quit()