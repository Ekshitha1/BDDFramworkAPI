@tagapi   
Feature: JSONPlaceholder API
  As a user of the JSONPlaceholder API
  I want to retrieve, create, and update posts
  So that I can test the functionality of the API



Scenario: Creat User
    Given Build the request "createuser"
    When The resquest type is "POST"
    Then the response status code should be 201
    And the response should contain "Leanne Graham"

Scenario: Retrieve all posts
    Given I have the base URI "http://jsonplaceholder.typicode.com"
    When I send a GET request to "/posts"
    Then the response status code should be 200
    
   