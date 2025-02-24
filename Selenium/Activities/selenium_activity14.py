# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:

    # Navigate to the URL
    driver.get("https://training-support.net/webelements/tables")

    # Print the title of the page
    print("Page title is: ", driver.title)

    # Print the number of columns
    cols = driver.find_elements(By.XPATH, "//table/thead/tr/th")
    print("Number of columns: ", len(cols))
    
    # Print the number of rows
    rows = driver.find_elements(By.XPATH, "//table/tbody/tr")
    print("Number of rows: ", len(rows))

    # Find and print the Book Name in the 5th row.
    cellValue = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
    print("Second row, second cell value: ", cellValue.text)

    driver.find_element(By.XPATH, "//table/thead/tr/th[5]").click()

    #Find and print the Book Name in the 5th row.
    cellValue = driver.find_element(By.XPATH, "//table/tbody/tr[5]/td[2]")
    print("Second row, second cell value: ", cellValue.text)

    #close the browser
    driver.quit()