Feature: Checking 

Scenario Outline: Checking the Buying property

Given Getting the driver from HomePage
Then Click on Buy
Then Enter the as Locality as "<locality>" 
And press the down button
Then press the Enter button
And Clicks on Search button

Examples:
|locality|
|White Field|