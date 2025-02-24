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
    driver.get("https://training-support.net/webelements/tabs")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Print the handle of the parent window
    original_window = driver.current_window_handle
    print("Current tab: ", original_window)

    print("Current Page message: ", driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/div/h2").text)
    
    # Find the button to open a new tab and click it.
    wait.until(EC.element_to_be_clickable((By.XPATH, "//button[text()='Open A New Tab']"))).click()
    
    # Wait for the new tab to open. Once it opens, print all the handles.
    wait.until(EC.number_of_windows_to_be(2))
    # Print all window handles
    print("Currently open windows: ", driver.window_handles)
    driver.switch_to.window(driver.window_handles[1])

    # Switch to the newly opened tab, print the new tab's title and message.
    wait.until(EC.element_to_be_clickable((By.XPATH, "//button[contains(text(), 'Another One')]")))
    # Print the handle of the current tab
    original_window = driver.current_window_handle
    print("Current tab: ", original_window)

    # Print the title and heading of the new page
    print("New Page title: ", driver.title)
    print("New Page message: ", driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/h2").text)
    
    # Repeat the steps by clicking the button in the new tab page

    # Find and click the button on page to open another tab
    driver.find_element(By.XPATH, "//button[contains(text(), 'Another One')]").click()

    # Wait for new tab to open
    wait.until(EC.number_of_windows_to_be(3))

    # Switch focus
    for handle in driver.window_handles:
        driver.switch_to.window(driver.window_handles[2])

    # Print the handle of the current tab
    original_window = driver.current_window_handle
    print("Current tab: ", original_window)

    # Print the title and heading of the new page
    print("New Page title: ", driver.title)
    print("New Page message: ", driver.find_element(By.XPATH, "/html/body/div/main/div/div/div/div/h2").text)
   
    #close the browser
    driver.quit()