#features means the application and the feature you are testing
Feature: To vaildate Payments

Background:
Given i should open the browser and navigate to the login page of amazon.com

@Payment1
Scenario: To test Payment 
When Click on Add to cart button
And  Click on check out button
And  Click on dilver to this address

