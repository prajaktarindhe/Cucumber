Feature: Checking

Scenario Outline: Checking the property available for Rental

Given Get the driver from BuyProperty Page
Then Click on Rent
Then Enter the Locality as "<Locality>"
And press down button
Then press Enter button
And Click on Search

Examples:
|Locality|
|MG Road|