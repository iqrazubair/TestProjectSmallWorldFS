@LoginTest
Feature: Test the Login page
  I want to Test the login page
  
  @LoginAndAddToCartFunctionalityTest
   Scenario: Testing the Login and add to cart functionality
    Given Open the application
    Then test the login functionality and verify the validation msg
    
    |UserName|Password|
    |iqra@gmail.com|12345|
    |standard_user|12345|
    |iqra1|secret_sauce|
    |standard_user|secret_sauce|
    
    Then Verify user successfully login to the home page
    Then Verify the add items Functionality
    |LineItemNo|
    |1|
    |2|
    |3|
    |4|
    |5|
    |6|
    
    Then Verify the remove items Functionality
    |LineItemNo|
    |3|
    |4|
    |5|
    
    Then click on the Checkout Button
    Then check the validations of checkout information form and get all the price of items and verify the total amount
    |Fname|Lname|Zipcode|
    |Iqra|Zubair|12233|