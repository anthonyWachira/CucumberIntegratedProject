Feature: Tecfios addcontact page

Scenario: Adding contact on the contact page

Given User is on theTechfios home page
When User login with valid username and passord
Then User navigates to add contact page
Then user fills up the page with relevant details
Then close the browser
