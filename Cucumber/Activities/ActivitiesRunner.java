package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith; 

/*

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features")
@ConfigurationParameter(
  key = Constants.GLUE_PROPERTY_NAME,
  value = "stepDefinitions")
@ConfigurationParameter(
  key = Constants.FILTER_TAGS_PROPERTY_NAME,
  value = "@activity1")

 */

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "Features",
		glue = {"stepDefinitions"},
		//run scenario which has either the tags
		//tags = "@PromptAlert or @ConfirmAlert",
		//run scenario which has both the tags
		//tags = "@SmokeTest and @SimpleAlert",
		tags = "@activity1 or @activity2 or @activity3 or @activity4 or @activity5",
		plugin = {"pretty"},
		//create HTML report file
		//plugin = {"html: test-reports"},
		//create JSON report file (we cant create folder we need to specifiy file name only
		//plugin = {"json: json-report.json"},
		monochrome = true
			
)

public class ActivitiesRunner {}
