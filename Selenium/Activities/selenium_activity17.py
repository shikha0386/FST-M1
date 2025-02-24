# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

# Start the Driver
with webdriver.Firefox() as driver:

    # Navigate to the URL
    driver.get("https://training-support.net/webelements/selects")
    # Print the title of the page
    print("Page title is: ", driver.title)

    # Find the dropdown
    dropdown = driver.find_element(By.CLASS_NAME, "h-80")
    # Pass the WebElement to the Select object
    multiSelect = Select(dropdown)

    # Print all the options
    allOptions = multiSelect.options
    print("Options in the dropdown: ")
    for option in allOptions: 
        print(option.text)

    # Select the "HTML" option using the visible text.
    multiSelect.select_by_visible_text("HTML")
    
    # Select the 4th, 5th and 6th options using the index.
    multiSelect.select_by_index(4)
    multiSelect.select_by_index(5)
    multiSelect.select_by_index(6)
    
    # Select the "Node" option using the value.
    multiSelect.select_by_value("nodejs")
    
    # Print all selected options
    allSelectedOptions = multiSelect.all_selected_options
    print("Options in the dropdown: ")
    for option in allSelectedOptions: 
        print(option.text)

    # De-select the 5th option using index.
    multiSelect.deselect_by_index(5)

    # Print all selected options
    allSelectedOptions = multiSelect.all_selected_options
    print("Options in the dropdown: ")
    for option in allSelectedOptions: 
        print(option.text)

        
    #close the browser
    driver.quit()