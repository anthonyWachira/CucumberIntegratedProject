Feature: Techfios Login

Scenario: Dashboard page login

Given User is on theTechfios home page
When User login with valid username and passord
Then User lands on the dashboard page
Then close the browser