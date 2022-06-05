Feature: Checking

Scenario Outline: Checking the property available for Commercial purpose

Given Get the driver from RentalProperty Page
Then Click on Commercial
Then Entered the Locality as "<Locality>"
And pressed down button
Then pressed Enter button
And Clicked on Search

Examples:
|Locality|
|Tipu Sultan|