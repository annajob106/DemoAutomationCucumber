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

Feature: sorting and buying product in amazon
  I want to use this template for my feature file

  @tag1
  Scenario: Succesful login with valid credentials
    Given user is on home page
    When  user navigate to login page
    Then  user login as "9447249725"and "Izzamaria@6"  
    
    @tag2
    Scenario: search for delllaptop and apply rating filter and find product details,count,discounted price
    
    Given user selects electronics and search dell laptop
    When user apply filter to search result
    Then user find product details
    And user find product count
    And user find discounted rate
    When user navigates to second page
    And user find product details of second page
    And user find discound rates of second page
    
    @tag3
    Scenario: user add new address to account 
    Given user navigates to addres page
    Then  user press add addres icon
    And  user adding addres details
    Then user submit new addres and verify new addres
    
    @tag4
    Scenario: Succesful logout from application
    Given user signout from application
    Then  user quit browser
    
    
    
   
          
   

 
