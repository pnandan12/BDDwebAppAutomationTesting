
Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|praveenkumar51357@gmail.com|1praveen|

@accounts
Scenario: Accounts page title
Given user is on Accounts page
#When user gets the title of the page
#Then page title should be "My account - My Store"
Then user gets title of the page
And page title should be "My account - My Store"

@accounts
Scenario: Accounts section count
Given user is on Accounts page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
And accounts section count should be 6