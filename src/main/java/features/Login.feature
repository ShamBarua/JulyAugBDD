#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Login functionality
 Registered user should be able to login with valid credentials

  Scenario: Positive login functionality test
  	Given user is in homePage
  	When user provides valid username and valid password
  	And user clicks submit button
  	Then login should happen and login success message should be displayed
  	
  	
  Scenario: Negative login functionality test with both invalid credentials	
  	Given user is in homePage
  	When user provides invalid username and invalid password
  	And user clicks submit button
  	Then login should not happen  and error message should be displayed
  	