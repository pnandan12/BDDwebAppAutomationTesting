Feature: Login Page Feature

Scenario: Login page title
 Given user is on login page
 When user gets title of the page
 Then page title should be "Login - My Store"
 
 Scenario: Forgot Password link
 Given user is on login page
 Then forgot password link should be displayed

Scenario: Login with correct credentials
 Given user is on login page
 When user enters the username "praveenkumar51357@gmail.com"
 And user enters the password "1praveen"
 And user click on login button
 Then user gets title of the page
 And page title should be "My account - My Store"
 