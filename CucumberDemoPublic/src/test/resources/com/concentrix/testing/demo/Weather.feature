Feature: Demonstrate Cucumber using BBC Weather

Requirements: We want glorious sunshine every day.

	Scenario: Adding two numbers
		Given I have a calculator
		When I add 1 and 2
		Then I should get 3
		
	Scenario: Navigate to Weather
		Given I have a web browser
		And I've navigated to "https://www.bbc.co.uk"
		When I click "News Link"
		Then I'm taken to the BBC News page
		
	Scenario: Ho to weather
		Given I'm at the "BBC News" page
		When I click "Weather Link"
		Then I'm taken to the "Weather" page
	
	Scenario: Glorious sunshine for a given post code
		Given I'm at the "Weather" page
		And I enter "SK8 4HZ" into the "Post Code" field
		When I click "Post Code Search"
		Then I see "Glorious Sunshine"

  