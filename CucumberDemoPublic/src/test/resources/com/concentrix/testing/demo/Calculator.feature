Feature: Demonstrate Cucumber

# Test Cucumber file. Adds two numbers, then goes off and gets the 
# weather.  Test 2 navigates to the web page of the BBC, goes to 
# News, then weather and enters a post code into checks if that
# post code has light rain.

# So what's the calculator all about? Well, this started out as
# Cucumber training project (courtesty of Pluralsight) and then
# evolved into Cucumber/Selenium project undertaken suring Maven
# training (also on Pluralsight).

	Scenario: Adding two numbers
		Given I have a calculator
		When I add 1 and 2
		Then I should get 3
		
	Scenario: Navigate to Weather
		Given I have a web browser
		And I've navigated to "https://www.bbc.co.uk"
		When I click "News Link"
		Then I'm taken to the BBC News page
		
	Scenario: Go to weather
		Given I'm at the "BBC News" page
		When I click "Weather Link"
		Then I'm taken to the "Weather" page
	
	Scenario: Light rain for a given post code
		Given I'm at the "Weather" page
		And I enter "SK8 4HZ" into the "Post Code" field
		When I click "Post Code Search"
		Then I see "Light rain"

# So how do we run this?  Quite simply run mvn clean verify 
# (or right click on the POM and run verify in whatever IDE
# you happwen to be usint).  This will attempt the build and
# and then search for any Java file with test in the name.
# In this case, it will find com:
#
#    com.concentrix.testing.demo.TestCucumber.java

  